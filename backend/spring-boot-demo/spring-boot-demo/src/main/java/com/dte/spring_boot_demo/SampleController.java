package com.dte.spring_boot_demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SampleController {
    List<Employee> employees = new ArrayList<>();

    {
        employees.add(new Employee("John Doe", 1, 50000));
        employees.add(new Employee("Jane Doe", 2, 60000));
        employees.add(new Employee("Ravi", 3 , 34343.3));
    }

    @RequestMapping(path="/employees", method=RequestMethod.GET)
    public List<Employee> fetchEmployees(){
        return this.employees;
    }


    @RequestMapping(path="/employees", method=RequestMethod.POST)
    public void addEmployee(@RequestBody Employee employee){
       this.employees.add(employee);
    }

    // This method will be called when the API endpoint "/hello" is accessed

    @RequestMapping(path = "/hello" , method=RequestMethod.GET)
    public String sayHello(){
        return "Hello, Spring Boot!";
    }
    
}
