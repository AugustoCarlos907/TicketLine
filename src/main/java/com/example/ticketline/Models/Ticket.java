package com.example.ticketline.Models;

import com.example.ticketline.Models.Enum.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Código único legível (Ex: "TCK-2026-XYZ987") usado no atendimento ao cliente
    @Column(name = "ticket_code", nullable = false, unique = true, length = 50)
    private String ticketCode;

    // Hash criptográfico ou UUID para gerar o QR Code (evita falsificação e tentativas de adivinhar o ID)
    @Column(name = "qr_code_hash", nullable = false, unique = true)
    private String qrCodeHash;

    // Identificação do comprador (pode ser o ID ou e-mail do utilizador do sistema)
    @Column(name = "buyer_email", nullable = false)
    private String buyerEmail;

    // O preço real pago pelo bilhete (pode diferir do preço base do assento devido a taxas ou descontos)
    @Column(nullable = false)
    private Double pricePaid;

    // Data e hora em que a compra foi oficialmente concluída
    @Column(name = "purchase_date", nullable = false)
    private LocalDateTime purchaseDate;

    // Data e hora em que o cliente entrou no evento (validação na porta via QR Code)
    @Column(name = "validated_at")
    private LocalDateTime validatedAt;

    // Estado do bilhete para controle de fluxo do negócio
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TicketStatus status; // Ex: RESERVED, PAID, CANCELLED, USED


    private LocalDateTime created_at ;
    private LocalDateTime updated_at ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    // Ligação com o assento específico que foi comprado
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "seat_id", nullable = false)
//    private Seat seat;
//

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id" , nullable = false)
    private User user ;

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
