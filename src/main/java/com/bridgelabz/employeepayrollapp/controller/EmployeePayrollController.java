package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public List<EmployeePayrollData> getAllEmployees() {
        return employeePayrollService.getEmployeePayrollData();
    }

    @GetMapping("/get/{id}")
    public EmployeePayrollData getEmployeeById(@PathVariable("id") int id) {
        return employeePayrollService.getEmployeePayrollDataById(id);
    }

    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        return employeePayrollService.createEmployeePayrollData(empPayrollDTO);
    }

    @PutMapping("/update/{id}")
    public EmployeePayrollData updateEmployee(@PathVariable("id") int id, @RequestBody EmployeePayrollDTO empPayrollDTO) {
        return employeePayrollService.updateEmployeePayrollData(id, empPayrollDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeePayrollService.deleteEmployeePayrollData(id);
    }
}
