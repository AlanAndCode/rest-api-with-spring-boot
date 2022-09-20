package br.com.erudio.model

import jakarta.persistence.*

@Entity
@Table(name= "person")

data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
var id: Long = 0,
//nullabe for cant set null value in the column
    @Column(name = "first_name", nullable = false, length = 40)
var firstName: String = "",
    @Column(name = "last_name", length = 80)
var lastName: String = "",

@Column(nullable = false, length = 60)
var address: String = "",
    @Column(nullable = false, length = 8)
var gender: String = "",


)