package com.ticket.ticketpary.repository;

import com.ticket.ticketpary.entity.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
}
