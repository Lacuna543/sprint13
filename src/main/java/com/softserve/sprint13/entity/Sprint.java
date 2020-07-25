package com.softserve.sprint13.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate finish;

    @CreationTimestamp
    private LocalDate start_date;

    @NotNull
    private String title;

    @ManyToOne
    private Marathon marathon;

    @OneToMany(mappedBy = "sprint")
    private List<Task> tasks;

    @Override
    public String toString() {
        return "Sprint{" +
                "id=" + id +
                ", finish=" + finish +
                ", start_date=" + start_date +
                ", title='" + title + '\'' +
                ", marathonId=" + marathon.getId() +
                '}';
    }
}
