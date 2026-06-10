package com.example.ticketline.Mappers;

import com.example.ticketline.DTO.EventDTO;
import com.example.ticketline.Models.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventMapper {

    public static EventDTO ToDTO(Event entity){
        if(entity ==  null )
            return null;

        EventDTO dto = new EventDTO();

        dto.setName(entity.getName());
        dto.setDate(entity.getDate());
        dto.setTotalSeats(entity.getTotal_seats());
        dto.setAvailableSeats(entity.getAvailable_seats());
        dto.setEventStatus(entity.getEventStatus());

        return dto;
    }
}
