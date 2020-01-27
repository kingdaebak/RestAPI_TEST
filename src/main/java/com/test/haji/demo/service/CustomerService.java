package com.test.haji.demo.service;

import com.test.haji.demo.domain.Customer;
import com.test.haji.demo.repogitory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll(){ return customerRepository.findAll(); }
    public Customer getOne(Integer id){ return customerRepository.getOne(id);}
    public Customer create(Customer customer){return customerRepository.save(customer);}
    public Customer update(Customer customer){return customerRepository.save(customer);}
    public void delete(Integer id){customerRepository.deleteById(id);}

}
