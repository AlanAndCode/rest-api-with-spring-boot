package br.com.erudio.mockito.services

import br.com.erudio.repository.PersonRepository
import br.com.erudio.unittests.mapper.mocks.MockPerson
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class PersonServiceTest {

    private lateinit var inputObject: MockPerson


    @InjectMocks
    private lateinit var service: PersonService

    @Mock
    private lateinit var repository: PersonRepository

    @BeforeEach
    fun setUp() {
        inputObject = MockPerson()
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun findById() {
        val person = inputObject.mockEntity(1)
        person.id = 1L
        `when`(repository.findById(1)).thenReturn(Optional.of(person))

        val result = service.finById(1)

        assertNotNull(result)
        assertNotNull(result.key)
        assertNotNull(result.links)
        println(result.links)
        assertTrue(result.links.toString().contains("/person/v1/1"))
        assertEquals("", result.address)
        assertEquals("", result.firstName)
        assertEquals("", result.lastName)
        assertEquals("", result.gender)


    }

    @Test
    fun findAll() {
    }

    @Test
    fun create() {
    }

    @Test
    fun createV2() {
    }

    @Test
    fun update() {
    }

    @Test
    fun delete() {
    }
}