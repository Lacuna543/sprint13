package com.softserve.sprint13.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate created;

    @NotNull
    private String title;

    @UpdateTimestamp
    private LocalDate updated;

    @ManyToOne
    private Sprint sprint;

    @OneToMany(mappedBy = "task")
    private List<Progress> progresses;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", created=" + created +
                ", title='" + title + '\'' +
                ", updated=" + updated +
                ", sprintId=" + sprint.getId() +
                '}';
    }
}
