package com.example.ticketline.Controllers;

import com.example.ticketline.DTO.EventDTO;
import com.example.ticketline.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/list")
    public ResponseEntity <List <EventDTO>> listEvents(){
        List<EventDTO> events = eventService.EventList();
        return ResponseEntity.ok(events);
    }

    @PostMapping("/create")
    public ResponseEntity<EventDTO> register(
            @RequestBody EventDTO dto
    ){
        EventDTO save = eventService.register(dto);
        return ResponseEntity.ok(save);
    }


    @PostMapping("/update")
    public ResponseEntity <EventDTO> update(
            @PathVariable long id,
            @RequestBody EventDTO dto
    ){
        EventDTO update = eventService.update(id , dto);
        return ResponseEntity.ok(update);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable long id
    ){
        eventService.delete(id);
        return ResponseEntity.noContent().build();// Retorna Status 204 (Sem conteúdo, mas operação com sucesso)
    }


}
