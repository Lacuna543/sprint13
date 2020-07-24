package com.softserve.sprint13.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="progress")
@Setter
@Getter
public class Progress {

    public enum TaskStatus {
        TODO, IN_PROGRESS, DONE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "started")
    private LocalDate started;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;

    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDate updated;

    @ManyToOne
    private Task task;

    @ManyToOne
    private User trainee;

}
