package com.example.ticketline.DTO;

import com.example.ticketline.Models.Enum.EventStatus;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EventDTO {
    private long id;
    private String name;
    private Date date;
    private Integer totalSeats;
    private Integer availableSeats;
    private EventStatus eventStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
