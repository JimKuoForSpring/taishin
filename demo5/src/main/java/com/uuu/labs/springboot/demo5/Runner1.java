package com.uuu.labs.springboot.demo5;

import com.uuu.labs.springboot.demo5.beans.Beverage;
import com.uuu.labs.springboot.demo5.repositories.MyCRUDRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class Runner1 implements CommandLineRunner {
    public Runner1(MyCRUDRepository repository) {
        this.repository = repository;
    }

    MyCRUDRepository repository;


    @Override
    public void run(String... args) throws Exception {
        initDatabase();
        dumpAllDatabase();
        getOne();
        getSome();
        getByTitle();
        getByDetail();
    }

    private void getByDetail() {
        log.info("***get by detail***");
        List<Beverage> allWithMilk = repository.findMatchByDetail("with milk");
        for (Beverage b : allWithMilk) {
            log.info("beverage={}", b);
        }
    }

    private void getByTitle() {
        log.info("***get by title***");
        List<Beverage> allBlackCoffee = repository.findMatchByTitle("Black Coffee");
        for (Beverage b : allBlackCoffee) {
            log.info("beverage={}", b);
        }
    }

    private void getSome() {
        log.info("*******get some*****");
        PageRequest firstRequest = PageRequest.of(0, 3);
        Page<Beverage> p1 = repository.findAll(firstRequest);
        for (Beverage b : p1.getContent()) {
            log.info("beverage={}", b);
        }
        log.info("*******get more*****");

        PageRequest nextRequest = firstRequest.next();
        Page<Beverage> p2 = repository.findAll(nextRequest);
        for (Beverage b : p2.getContent()) {
            log.info("beverage={}", b);
        }

    }

    private void getOne() {
        Optional<Beverage> optioanlBeverage = repository.findById(1L);
        Beverage b = optioanlBeverage.get();
        b.setTitle("Green Tea!!!");
        repository.save(b);
        dumpAllDatabase();
    }

    private void dumpAllDatabase() {
        for (Beverage beverage : repository.findAll()) {
            log.info("beverage:{}:{}", beverage.getTitle(), beverage.getDetail());
        }
    }

    private void initDatabase() {
        repository.save(new Beverage("Black Tea", "with milk"));
        repository.save(new Beverage("Black Coffee", "with milk"));
        repository.save(new Beverage("Black Coffee", "no milk"));
        repository.save(new Beverage("Ice Coffee", "with milk"));
        repository.save(new Beverage("Ice Coffee", "no milk"));
        repository.save(new Beverage("Hot Latte", "with milk"));
        repository.save(new Beverage("Ice Latte", "with milk"));
        repository.save(new Beverage("Hot Americano", "no milk"));
        repository.save(new Beverage("Ice Americano", "no milk"));
        repository.save(new Beverage("Hot Espresso", "super strong"));
        repository.save(new Beverage("Ice Espresso", "super strong"));

    }
}
