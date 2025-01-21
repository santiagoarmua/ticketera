package com.ticket.ticketpary.controller;

import com.ticket.ticketpary.entity.Usuario;
import com.ticket.ticketpary.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los clientes
    @GetMapping("/all")
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
        Optional<Usuario> cliente = usuarioService.findById(id);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo cliente
    @PostMapping("/create")
    public Usuario createCliente(@RequestBody Usuario cliente) {
        return usuarioService.save(cliente);
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateCliente(@PathVariable Integer id, @RequestBody Usuario clienteDetails) {
        Optional<Usuario> cliente = usuarioService.findById(id);
        if (cliente.isPresent()) {
            Usuario clienteToUpdate = cliente.get();
            clienteToUpdate.setUsername(clienteDetails.getUsername());
            clienteToUpdate.setPassword(clienteDetails.getPassword());
            clienteToUpdate.setMail(clienteDetails.getMail());
            Usuario updatedCliente = usuarioService.save(clienteToUpdate);
            return ResponseEntity.ok(updatedCliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        Optional<Usuario> cliente = usuarioService.findById(id);
        if (cliente.isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
