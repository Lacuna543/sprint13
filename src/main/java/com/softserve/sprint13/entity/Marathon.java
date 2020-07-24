package com.softserve.sprint13.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "marathon")
public class Marathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "marathonUsers")
    List<User> users;
    public Marathon() {
    }

}
