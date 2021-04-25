package com.rahul.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "id")
    private int id;

    @Column(columnDefinition = "code")
    private String code;

    @Column(columnDefinition = "name")
    private String name;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<State> states;
}
