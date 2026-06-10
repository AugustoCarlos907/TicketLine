package com.example.ticketline.Repositories;


import com.example.ticketline.Models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue , Long> {
}
