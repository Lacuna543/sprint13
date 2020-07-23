package com.softserve.sprint13.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marathon_user")
public class MarathonUser  {
    @Id
    private int marathon_id;
    @Id
    private int user_id;

    public MarathonUser() {
    }
}
