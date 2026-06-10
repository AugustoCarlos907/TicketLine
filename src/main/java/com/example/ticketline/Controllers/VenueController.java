package com.example.ticketline.Controllers;

import com.example.ticketline.DTO.VenueDTO;
import com.example.ticketline.Models.Venue;
import com.example.ticketline.Services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venue")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @GetMapping("/list")
    public ResponseEntity <List<VenueDTO>> list(){
        List <VenueDTO> venue = venueService.venueList();
        return ResponseEntity.ok(venue);
    }

    @PostMapping("/create")
    public ResponseEntity <VenueDTO> register(
            @RequestBody VenueDTO dto
            ){
        VenueDTO save = venueService.regiter(dto);
        return  ResponseEntity.ok(save);
    }

    @DeleteMapping("/delete")
    public ResponseEntity <Void> delete(
            @PathVariable long id
    ){
         venueService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
