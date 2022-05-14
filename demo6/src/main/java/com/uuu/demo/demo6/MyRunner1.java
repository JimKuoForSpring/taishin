package com.uuu.demo.demo6;

import com.uuu.demo.demo6.beans.Customer;
import com.uuu.demo.demo6.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyRunner1 implements CommandLineRunner {
    @Autowired
    private CustomerRepository repository;

    @Override
    public void run(String... args) throws Exception {
        initSampleData();
        repository.findAllOrderByName()
                .forEach(customer -> log.info(customer.toString()));
    }

    private void initSampleData() {
        Customer c1 = repository.save(new Customer("Mark", "Ho"));
        log.info("first c1={}", c1);
        repository.save(new Customer("Peter", "Ho"));
        repository.save(new Customer("Peter", "Chen"));
        repository.save(new Customer("Peter", "Lee"));
        repository.save(new Customer("John", "Ho"));
        repository.save(new Customer("Jimmy", "Lee"));
        repository.save(new Customer("Abby", "Lin"));
        repository.findAll().forEach(p -> log.info(p.toString()));
    }
}

