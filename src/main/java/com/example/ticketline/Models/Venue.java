package com.example.ticketline.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 150)
    private String name; // Ex: "MEO Arena", "Estádio da Luz", "Teatro Rivoli"

    @Column(nullable = false, length = 255)
    private String address; // Rua, número e bairro

    @Column(nullable = false, length = 100)
    private String city; // Essencial para filtros de busca de eventos

    @Column(nullable = false)
    private int availability; // Limite máximo de segurança do local

    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id" , nullable = false)
    private Event event;

}
