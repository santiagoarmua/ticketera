package com.ticket.ticketpary.service;

import com.ticket.ticketpary.entity.Usuario;
import com.ticket.ticketpary.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para obtener todos los clientes
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // Método para obtener un cliente por su ID
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    // Método para crear o actualizar un cliente
    public Usuario save(Usuario cliente) {
        return usuarioRepository.save(cliente);
    }

    // Método para eliminar un cliente por su ID
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
