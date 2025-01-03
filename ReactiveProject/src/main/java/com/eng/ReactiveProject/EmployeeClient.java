package com.eng.ReactiveProject;

import com.eng.ReactiveProject.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class EmployeeClient {

    @GetMapping("/helloMono")
    public String hello(){

        String resource = "Invocazione Fatta";

        WebClient webClient = WebClient.create("http://localhost:8080");

        Mono<Employee> employeeMono = webClient.get()
                .uri("/employees/{id}","1")
                .retrieve()
                .bodyToMono(Employee.class);

        employeeMono.subscribe(response -> {
            System.out.println("Risposta: "+response);
        }, error -> {System.err.println("error");});

        return resource;
    }

    @GetMapping("/helloFlux")
    public String hello2(){

        String resource = "Invocazione Fatta";

        WebClient webClient = WebClient.create("http://localhost:8080");

        Flux<Employee> employees = webClient.get()
                .uri("/employees")
                .retrieve()
                .bodyToFlux(Employee.class);

        employees.subscribe(response -> {
            System.out.println("Risposta: "+response);
        }, error -> {System.err.println("error");});

        return resource;
    }
}
