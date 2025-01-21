package com.ticket.ticketpary.controller;

import com.ticket.ticketpary.entity.Evento;
import com.ticket.ticketpary.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "http://localhost:4200")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    // Obtener todos los eventos
    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.findAll();
    }

    // Obtener un evento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Integer id) {
        Optional<Evento> evento = eventoService.findById(id);
        return evento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo evento
    @PostMapping
    public Evento createEvento(@RequestBody Evento evento) {
        return eventoService.save(evento);
    }

    // Actualizar un evento existente
    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Integer id, @RequestBody Evento eventoDetails) {
        Optional<Evento> evento = eventoService.findById(id);
        if (evento.isPresent()) {
            Evento eventoToUpdate = evento.get();
            eventoToUpdate.setLugar(eventoDetails.getLugar());
            eventoToUpdate.setFecha(eventoDetails.getFecha());
            eventoToUpdate.setHorario(eventoDetails.getHorario());
            eventoToUpdate.setCategoria(eventoDetails.getCategoria());
            eventoToUpdate.setImagen(eventoDetails.getImagen());
            eventoToUpdate.setNombre(eventoDetails.getNombre());
            Evento updatedEvento = eventoService.save(eventoToUpdate);
            return ResponseEntity.ok(updatedEvento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un evento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Integer id) {
        Optional<Evento> evento = eventoService.findById(id);
        if (evento.isPresent()) {
            eventoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
