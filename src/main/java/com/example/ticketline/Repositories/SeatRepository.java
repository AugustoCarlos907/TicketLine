package com.example.ticketline.Repositories;

import com.example.ticketline.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat , Long> {
}
