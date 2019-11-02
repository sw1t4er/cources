package com.nbu.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "user_address")
public class Address extends SystemDirectory {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User addressUserId;

    @Column(name ="address")
    private String address;

    @Column(name = "zip")
    private String zip;
}
