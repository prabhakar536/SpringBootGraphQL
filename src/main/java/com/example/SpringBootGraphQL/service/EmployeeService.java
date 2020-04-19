package com.example.SpringBootGraphQL.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.SpringBootGraphQL.exception.RecordNotFoundException;
import com.example.SpringBootGraphQL.model.Employee;
import com.example.SpringBootGraphQL.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService  implements GraphQLQueryResolver {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        if(employeeList.size() > 0)
        {
            return employeeList;
        }
        else {
            return new ArrayList<Employee>();
        }
    }
    public long countEmployees()
    {
        return employeeRepository.count();
    }
    public Employee getEmployee(long id) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent())
        {
            return employeeOptional.get();
        }
        else {
            throw  new RecordNotFoundException("No employee record exit given id...");
        }
    }

    public Employee createAndUpdate(Employee employee) throws RecordNotFoundException{
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmpId());
        if(optionalEmployee.isPresent())
        {
            Employee newEmployee = optionalEmployee.get();
            newEmployee.setEmpName(employee.getEmpName());
            newEmployee.setDesignation(employee.getDesignation());
            newEmployee.setSalary(employee.getSalary());
            return employeeRepository.save(newEmployee);
        }
        else
        {
            return employeeRepository.save(employee);
        }
    }

    public void deleteEmployeeById(long empId) throws RecordNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        if(optionalEmployee.isPresent())
        {
            employeeRepository.deleteById(empId);
        }
        else {
            throw new RecordNotFoundException("No employee record exist for given employee id....");
        }
    }


}
