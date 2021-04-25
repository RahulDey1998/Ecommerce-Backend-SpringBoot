package com.rahul.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "state")
@Getter
@Setter
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "id")
    private int id;

    @Column(columnDefinition = "name")
    private String name;

    @ManyToOne
    @JoinColumn(columnDefinition = "country_id")
    private  Country country;
}
