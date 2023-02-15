package br.com.arche

import br.com.arche.controller.BookController
import br.com.arche.data.vo.v1.BookVO
import br.com.arche.exceptions.RequiredObjectisNullException
import br.com.arche.exceptions.ResourceNotFoundException
import br.com.arche.mapper.DozerMapper
import br.com.arche.model.Book
import br.com.arche.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.PagedModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class BookService {

    @Autowired
    private lateinit var repository: BookRepository

    @Autowired
    private lateinit var assembler: PagedResourcesAssembler<BookVO>

    private val logger = Logger.getLogger(BookService::class.java.name)

    fun findAll(pageable: Pageable): PagedModel<EntityModel<BookVO>> {
        logger.info("Finding all books!")
        val page = repository.findAll(pageable)
        val vos = page.map { b -> DozerMapper.parseObject(b, BookVO::class.java) }
        vos.map { p -> p.add(linkTo(BookController::class.java).slash(p.key).withSelfRel()) }
        return assembler.toModel(vos)
    }

    fun findById(id: Long): BookVO {
        logger.info("Finding one book with ID $id!")
        var book = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        val bookVO: BookVO = DozerMapper.parseObject(book, BookVO::class.java)
        val withSelfRel = linkTo(BookController::class.java).slash(bookVO.key).withSelfRel()
        bookVO.add(withSelfRel)
        return bookVO
    }

    fun create(book: BookVO?) : BookVO{
        if (book == null) throw RequiredObjectisNullException()
        logger.info("Creating one book with title ${book.title}!")
        var entity: Book = DozerMapper.parseObject(book, Book::class.java)
        val bookVO: BookVO = DozerMapper.parseObject(repository.save(entity), BookVO::class.java)
        val withSelfRel = linkTo(BookController::class.java).slash(bookVO.key).withSelfRel()
        bookVO.add(withSelfRel)
        return bookVO
    }

    fun update(book: BookVO?) : BookVO{
        if (book == null) throw RequiredObjectisNullException()
        logger.info("Updating one book with ID ${book.key}!")
        val entity = repository.findById(book.key)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.author = book.author
        entity.title = book.title
        entity.price = book.price
        entity.launchDate = book.launchDate
        val bookVO: BookVO = DozerMapper.parseObject(repository.save(entity), BookVO::class.java)
        val withSelfRel = linkTo(BookController::class.java).slash(bookVO.key).withSelfRel()
        bookVO.add(withSelfRel)
        return bookVO
    }

    fun delete(id: Long) {
        logger.info("Deleting one book with ID $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}