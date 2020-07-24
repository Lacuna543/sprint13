package com.softserve.sprint13.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Marathon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @OneToMany(mappedBy = "marathon")
    private List<Sprint> sprint;

    @ManyToMany(mappedBy = "marathon")
    private List<User> user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Sprint> getSprint() {
        return sprint;
    }

    public void setSprint(List<Sprint> sprint) {
        this.sprint = sprint;
    }
}
