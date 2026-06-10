package com.example.ticketline.DTO;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class SeatDTO {
    private long id;
    private String seatNumber;
    private String section;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Long venueId; // Vincula diretamente ao ID do local
}
