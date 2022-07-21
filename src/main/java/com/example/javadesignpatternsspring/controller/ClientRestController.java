package com.example.javadesignpatternsspring.controller;

import com.example.javadesignpatternsspring.model.Client;
import com.example.javadesignpatternsspring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientRestController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> searchAll() {
        return ResponseEntity.ok(clientService.searchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> searchById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        clientService.create(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        clientService.update(id, client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
