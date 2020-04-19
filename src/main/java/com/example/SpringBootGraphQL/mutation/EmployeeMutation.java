package com.example.SpringBootGraphQL.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.SpringBootGraphQL.model.Employee;
import com.example.SpringBootGraphQL.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMutation implements GraphQLMutationResolver {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee newEmployee(long empId, String empName, String designation, float salary)
    {
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setDesignation(designation);
        employee.setSalary(salary);
        employeeRepository.save(employee);
        return employee;

    }
    public void deleteEmployee(long empId)
    {
        employeeRepository.deleteById(empId);
    }

}
