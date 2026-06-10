package com.example.ticketline.Services;

import com.example.ticketline.DTO.VenueDTO;
import com.example.ticketline.Mappers.VenueMapper;
import com.example.ticketline.Models.Event;
import com.example.ticketline.Models.Venue;
import com.example.ticketline.Repositories.EventRepository;
import com.example.ticketline.Repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private EventRepository eventRepository;


    public List<VenueDTO> venueList(){
        return venueRepository.findAll()
                .stream()
                .map(VenueMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VenueDTO regiter(VenueDTO dto){

        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(()-> new RuntimeException("No event find"));

        Venue venue = new Venue();

        venue.setName(dto.getName());
        venue.setAddress(dto.getAddress());
        venue.setCity(dto.getCity());
        venue.setAvailability(dto.getAvailability());
        venue.setEvent(event);

        venue = venueRepository.save(venue);

        return VenueMapper.toDTO(venue);
    }

    public void delete(long id ){
        Venue venue = venueRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No venue find"));

        venueRepository.delete(venue);
    }
}
