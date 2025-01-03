package com.eng.ReactiveProject.controller;

import com.eng.ReactiveProject.model.Employee;
import com.eng.ReactiveProject.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable String id){
        return  employeeRepository.findEmployeeById(id);
    }

    @GetMapping
    public Flux<Employee> getAll(){
        return employeeRepository.findAllEmployees();
    }

}
