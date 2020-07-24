package com.softserve.sprint13.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "marathon")
@Setter
@Getter
public class Marathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    @NotNull
    private String title;

    @ManyToMany(mappedBy = "marathonUsers")
    List<User> users;
    public Marathon() {
    }

}
