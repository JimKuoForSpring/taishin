package com.uuu.labs.springboot.demo5.repositories;

import com.uuu.labs.springboot.demo5.beans.Beverage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MyCRUDRepository extends CrudRepository<Beverage, Long> {
    Page<Beverage> findAll(Pageable pageable);

    List<Beverage> findMatchByTitle(String title);

    List<Beverage> findMatchByDetail(String title);
}
