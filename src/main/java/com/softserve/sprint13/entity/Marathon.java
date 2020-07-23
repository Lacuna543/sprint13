package com.softserve.sprint13.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marathon")
public class Marathon {
    @Id
    private int id;
    private String title;

    public Marathon() {
    }

}
