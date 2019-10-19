package com.nbu.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table (name = "goods")
public class Good extends SystemDirectory {

    @Column(name = "name")
    private String name;

    @Column (name = "price")
    private Double price;
}
