package com.uuu.labs.springboot.demo5.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DRINK")
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String detail;

    public Beverage(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }
}
