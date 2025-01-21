package com.ticket.ticketpary.service;

import com.ticket.ticketpary.entity.Entrada;
import com.ticket.ticketpary.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    // Método para obtener todas las entradas
    public List<Entrada> findAll() {
        return entradaRepository.findAll();
    }

    // Método para obtener una entrada por su ID
    public Optional<Entrada> findById(Integer id) {
        return entradaRepository.findById(id);
    }

    // Método para crear o actualizar una entrada
    public Entrada save(Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    // Método para eliminar una entrada por su ID
    public void deleteById(Integer id) {
        entradaRepository.deleteById(id);
    }
}
