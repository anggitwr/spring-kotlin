package com.anggitwr.springkotlin.controller

import com.anggitwr.springkotlin.models.Employe
import com.anggitwr.springkotlin.service.EmployeService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeController(private val employeService: EmployeService) {

    @GetMapping("/employes")
    fun getAllEmployes(): List<Employe> = employeService.getAllEmploye()

    @GetMapping("/employes/{id}")
    fun getEmployesById(@PathVariable("id") employeId: Long): Employe =
        employeService.getEmployesById(employeId)

    @PostMapping("/employes")
    fun createEmploye(@RequestBody payload: Employe): Employe = employeService.createEmploye(payload)

    @PutMapping("/employes/{id}")
    fun updateEmployeById(@PathVariable("id") employeId: Long, @RequestBody payload: Employe): Employe =
        employeService.updateEmployeById(employeId, payload)

    @DeleteMapping("/employes/{id}")
    fun deleteEmployesById(@PathVariable("id") employeId: Long): Unit =
        employeService.deleteEmployesById(employeId)
}