package com.gssprototype.service;

import com.gssprototype.exceptions.ResourceNotFoundException;
import com.gssprototype.models.Employee;
import com.gssprototype.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    // Constructor with EmployeeRepository dependency
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }
    // Service layer method for addEmployee POST API method
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Service layer method for getAllEmployees GET API method
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Service layer method for getEmployeeById GET/{id} API method
    @Override
    public Employee getEmployeeById(long id) {
        // Check if employee exists in database. Get employee if exists, throw exception if not
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return employee.get();
        }
        else
            throw new ResourceNotFoundException("Employee", "Id", id);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // Check if employee exists in database and throw if not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id)
        );

        // Update and save employee in database
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    // Service layer method for deleteEmployee DELETE API method
    @Override
    public void deleteEmployee(long id) {

        // Check if employee exists in database, throw if not
        employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id)
        );
        // Delete employee
        employeeRepository.deleteById(id);
    }

}
