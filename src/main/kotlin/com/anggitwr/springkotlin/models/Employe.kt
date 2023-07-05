package com.anggitwr.springkotlin.models

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "employe")
data class Employe (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "user_name", unique = true, nullable = false)
    val username: String,
    @Column(name = "first_name", nullable = true)
    val firstname: String?,
    @Column(name = "middle_name", nullable = false)
    val middlename: String,
    @Column(name = "last_name", nullable = false)
    val lastName: String,
    @Column(name = "email_address", nullable = false)
    val emailId: String,
    @Column(name = "day_of_birth", nullable = false)
    val dayOfBirth: LocalDate
)