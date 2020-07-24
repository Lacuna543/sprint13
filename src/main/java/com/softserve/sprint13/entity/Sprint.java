package com.softserve.sprint13.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="sprint")
@Setter
@Getter
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @CreationTimestamp
    @Column(name = "finish")
    private LocalDate finish;

    @NotNull
    @CreationTimestamp
    @Column(name = "start_date")
    private LocalDate start_date;

    @NotNull
    @Column(name = "title")
    private String title;

    @ManyToOne
    private Marathon marathon;

    @OneToMany(mappedBy = "sprint")
    private List<Task> tasks;
}
