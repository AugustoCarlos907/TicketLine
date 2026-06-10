package com.example.ticketline.DTO;

import com.example.ticketline.Models.Enum.TicketStatus;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class TicketDTO {
    private long id;
    private String ticketCode;
    private String qrCodeHash;
    private String buyerEmail;
    private Double pricePaid;
    private LocalDateTime purchaseDate;
    private LocalDateTime validatedAt;
    private TicketStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Long eventId; // ID do evento associado
    private Long userId;  // ID do utilizador que comprou (mapeado do seu @OneToOne User)
}
