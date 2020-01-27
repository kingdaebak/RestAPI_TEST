package com.test.haji.demo.controller;


import com.test.haji.demo.domain.Customer;
import com.test.haji.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    List<Customer> getCustomers(){
        return customerService.findAll();
    }

    @PostMapping
    ResponseEntity<Customer> postCustomer (@RequestBody Customer customer, UriComponentsBuilder uriBuilder) {
        Customer created = customerService.create(customer);
        URI location = uriBuilder.path("api/customers/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping(path = "{id}")
    //@RequestMapping(value = "one",method = RequestMethod.GET)
    Customer getCustomer(@PathVariable Integer id){
    //Customer getCustomer(@RequestParam Integer id){
        return customerService.getOne(id);
    }pwd



    @PutMapping(path = "{id}")
    Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer){
        customer.setId(id);
        return customerService.update(customer);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id){
        customerService.delete(id);
    }
}
