package com.anggitwr.springkotlin.service

import com.anggitwr.springkotlin.models.Employe
import com.anggitwr.springkotlin.repository.IEmployeRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class EmployeService(private val imployeRepository: IEmployeRepository) {

    fun getAllEmploye(): List<Employe> = imployeRepository.findAll()

    fun getEmployesById(employeId: Long): Employe = imployeRepository.findById(employeId)
        .orElseThrow { EmployeNotFoundException(HttpStatus.NOT_FOUND, "No Matching employe")}

    fun createEmploye(employe: Employe): Employe = imployeRepository.save(employe)

    fun updateEmployeById(employeId: Long, employe: Employe): Employe {
        return if (imployeRepository.existsById(employeId)){
            imployeRepository.save(
                Employe(
                    id = employe.id,
                    username = employe.username,
                    firstname = employe.firstname,
                    middlename = employe.middlename,
                    lastName = employe.lastName,
                    emailId = employe.emailId,
                    dayOfBirth = employe.dayOfBirth
                )
            )
        } else throw EmployeNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found")
    }

    fun deleteEmployesById(employeId: Long){
        return if (imployeRepository.existsById(employeId)){
            imployeRepository.deleteById(employeId)
        } else throw EmployeNotFoundException(HttpStatus.NOT_FOUND, "No matching employe was found")
    }
}