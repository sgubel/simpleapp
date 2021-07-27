package com.simpleapp.simpleapplication.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected int id;

    @Column(name = "date_created", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false
    )
    protected LocalDateTime dateCreated;

    @Column(name = "date_updated")
    protected LocalDateTime dateUpdated;

    @PrePersist
    void onCreate() {
        setDateCreated(LocalDateTime.now());
    }

    @PreUpdate
    void onPersist() {
        setDateUpdated(LocalDateTime.now());
    }
}
