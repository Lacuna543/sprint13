package com.softserve.sprint13.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table
public class Progress {

    public enum TaskStatus {
        PASS, FAIL, PENDING;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate started;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @UpdateTimestamp
    private LocalDate updated;

    @ManyToOne
    private Task task;

    @ManyToOne
    private User trainee;

    @Override
    public String toString() {
        return "Progress{" +
                "id=" + id +
                ", started=" + started +
                ", status=" + status +
                ", updated=" + updated +
                ", taskId=" + task.getId() +
                ", traineeId=" + trainee.getId() +
                '}';
    }
}
