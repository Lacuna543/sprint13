package com.softserve.sprint13.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "marathon")
public class Marathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotNull
    private String title;

    @ManyToMany(mappedBy = "marathonUsers")
    @Fetch(value = FetchMode.SUBSELECT)
    List<User> users;

    @Override
    public String toString() {
        return "Marathon{" +
                "id=" + id +
                ", title='" + title +
                '}';
    }
}
