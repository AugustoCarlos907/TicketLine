package com.example.ticketline.DTO;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class VenueDTO {
    private long id;
    private String name;
    private String address;
    private String city;
    private int availability;

    private Long eventId; // Apenas o ID do evento pai
}
