package com.anggitwr.springkotlin.repository

import com.anggitwr.springkotlin.models.Employe
import org.springframework.data.jpa.repository.JpaRepository

interface IEmployeRepository: JpaRepository<Employe, Long>{

}