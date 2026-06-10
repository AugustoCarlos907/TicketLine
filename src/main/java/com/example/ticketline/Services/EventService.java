package com.example.ticketline.Services;

import com.example.ticketline.DTO.EventDTO;
import com.example.ticketline.Mappers.EventMapper;
import com.example.ticketline.Models.Enum.EventStatus;
import com.example.ticketline.Models.Event;
import com.example.ticketline.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List <EventDTO> EventList(){
        return eventRepository.findAll()
                .stream()
                .map(EventMapper::ToDTO)
                .collect(Collectors.toList());
    }

    public EventDTO register (EventDTO dto) {
        Event event = new Event();

        event.setName(dto.getName());
        event.setDate(dto.getDate());
        event.setTotal_seats(dto.getTotalSeats());
        event.setAvailable_seats(dto.getAvailableSeats());
        event.setEventStatus(dto.getEventStatus());

        event = eventRepository.save(event);

        return EventMapper.ToDTO(event);
    }


    public EventDTO update(long id , EventDTO dto){
        Event event = eventRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Evento não encontrado"));

        event.setName(dto.getName());
        event.setDate(dto.getDate());
        event.setTotal_seats(dto.getTotalSeats());
        event.setAvailable_seats(dto.getAvailableSeats());
        event.setEventStatus(dto.getEventStatus());

        event = eventRepository.save(event);

        return EventMapper.ToDTO(event);
    }

    public void delete(long id){
        Event event = eventRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Evento não encontrado"));

        if (event.getTickets() != null && !event.getTickets().isEmpty()) {
            throw new IllegalStateException("Não é possível eliminar um evento que já possui bilhetes gerados/vendidos!");
        }

        eventRepository.delete(event);
    }

}
