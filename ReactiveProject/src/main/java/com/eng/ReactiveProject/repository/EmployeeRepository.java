package com.eng.ReactiveProject.repository;

import com.eng.ReactiveProject.model.Employee;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {

    private static final Map<String, Employee> EMPLOYEE_MAP;

    static{
        EMPLOYEE_MAP = new HashMap<>();
        EMPLOYEE_MAP.put("1",new Employee("1","Employee 1"));
        EMPLOYEE_MAP.put("2",new Employee("2","Employee 2"));
        EMPLOYEE_MAP.put("3",new Employee("3","Employee 3"));
        EMPLOYEE_MAP.put("4",new Employee("4","Employee 4"));
        EMPLOYEE_MAP.put("5",new Employee("5","Employee 5"));
    }

    public Mono<Employee> findEmployeeById(String id){
        return Mono.just(EMPLOYEE_MAP.get(id));
    }

    public Flux<Employee> findAllEmployees(){
        return Flux.fromIterable(EMPLOYEE_MAP.values());
    }

    public Mono<Employee> updateEmployee(Employee e){
        Employee existingEmployee = EMPLOYEE_MAP.get(e.getId());
        if(existingEmployee != null){
            //se già esiste e, allora aggionro semplicemente il parametro nome
            existingEmployee.setName(e.getName());
        }
        return Mono.just(existingEmployee);
    }

}
