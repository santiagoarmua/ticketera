package com.ticket.ticketpary.controller;

import com.ticket.ticketpary.entity.Entrada;
import com.ticket.ticketpary.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entradas")
@CrossOrigin(origins = "http://localhost:4200")
public class EntradaController {
    @Autowired
    private EntradaService entradaService;

    // Obtener todas las entradas
    @GetMapping
    public List<Entrada> getAllEntradas() {
        return entradaService.findAll();
    }

    // Obtener una entrada por ID
    @GetMapping("/{id}")
    public ResponseEntity<Entrada> getEntradaById(@PathVariable Integer id) {
        Optional<Entrada> entrada = entradaService.findById(id);
        return entrada.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva entrada
    @PostMapping
    public Entrada createEntrada(@RequestBody Entrada entrada) {
        return entradaService.save(entrada);
    }

    // Actualizar una entrada existente
    @PutMapping("/{id}")
    public ResponseEntity<Entrada> updateEntrada(@PathVariable Integer id, @RequestBody Entrada entradaDetails) {
        Optional<Entrada> entrada = entradaService.findById(id);
        if (entrada.isPresent()) {
            Entrada entradaToUpdate = entrada.get();
            entradaToUpdate.setCliente(entradaDetails.getCliente());
            entradaToUpdate.setEvento(entradaDetails.getEvento());
            entradaToUpdate.setPrecio(entradaDetails.getPrecio());
            entradaToUpdate.setFechaVenta(entradaDetails.getFechaVenta());
            entradaToUpdate.setQr(entradaDetails.getQr());
            Entrada updatedEntrada = entradaService.save(entradaToUpdate);
            return ResponseEntity.ok(updatedEntrada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una entrada por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrada(@PathVariable Integer id) {
        Optional<Entrada> entrada = entradaService.findById(id);
        if (entrada.isPresent()) {
            entradaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
