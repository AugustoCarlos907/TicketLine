package com.example.ticketline.Mappers;

import com.example.ticketline.DTO.VenueDTO;
import com.example.ticketline.Models.Venue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VenueMapper {

    public static VenueDTO toDTO(Venue venue){
        if(venue == null)
            return null;

        VenueDTO dto = new VenueDTO();

        dto.setName(venue.getName());
        dto.setAddress(venue.getAddress());
        dto.setCity(venue.getCity());
        dto.setAvailability(venue.getAvailability());
        dto.setEventId(venue.getEvent().getId());

        return dto;
    }
}
