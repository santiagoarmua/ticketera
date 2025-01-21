package com.ticket.ticketpary.service;

import com.ticket.ticketpary.entity.Evento;
import com.ticket.ticketpary.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // Método para obtener todos los eventos
    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    // Método para obtener un evento por su ID
    public Optional<Evento> findById(Integer id) {
        return eventoRepository.findById(id);
    }

    // Método para crear o actualizar un evento
    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    // Método para eliminar un evento por su ID
    public void deleteById(Integer id) {
        eventoRepository.deleteById(id);
    }
}
