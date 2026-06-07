package com.example.ticketline.Models;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "seats")

public class Seat {
    //assentos individuais
    //rastreia o número de assentos e diz se está resrvado/disponivel  e o preço de cada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private String seat_number;
    private String section ; //VIP / Normal
    private Double price;

    private LocalDateTime created_at ;
    private LocalDateTime updated_at ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id", nullable = false) // Cria a FK venue_id no PostgreSQL
    private Venue venue;

    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
        this.created_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }

}
