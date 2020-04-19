package com.example.SpringBootGraphQL.controller;

import com.example.SpringBootGraphQL.exception.RecordNotFoundException;
import com.example.SpringBootGraphQL.model.Employee;
import com.example.SpringBootGraphQL.repository.EmployeeRepository;
import com.example.SpringBootGraphQL.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        List<Employee> employeeList =  employeeService.getAllEmployee();
        return new ResponseEntity<List<Employee>>(employeeList, new HttpHeaders(), HttpStatus.OK );
    }
    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") Long empId) throws RecordNotFoundException {
        Employee employee= employeeService.getEmployee(empId);

       return new ResponseEntity<Employee>(employee, new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Employee> createAndUpdateEmployee(@RequestBody Employee employee) throws RecordNotFoundException {
       Employee creUp = employeeService.createAndUpdate(employee);
       return new ResponseEntity<Employee>(creUp, new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping("/{empId}")
    public  HttpStatus deleteEmployeeById(@PathVariable("empId") long empId) throws RecordNotFoundException {
        employeeService.deleteEmployeeById(empId);
        return HttpStatus.FORBIDDEN;
    }


}
