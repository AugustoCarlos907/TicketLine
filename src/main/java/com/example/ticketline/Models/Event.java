package com.example.ticketline.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {

// entidade central que representa o evento com os detalhes e agendamentos
// Gerencia os diferentes tipos de bilhetes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private String name;
    private Date date;
    private Integer total_seats;
    private Integer available_seats;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "event" ,  cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Ticket>tickets;

    @OneToMany(mappedBy = "event" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List <Venue> venues;


    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }




}
