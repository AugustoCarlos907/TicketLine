package com.example.ticketline.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    //representa os participantes e organizadores
    //mostra o histórico de compra

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private String name;
    private String email;
    private String password ;


    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL , fetch =  FetchType.EAGER)
    private Ticket ticket;
}
