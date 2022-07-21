package com.example.javadesignpatternsspring.service;

import com.example.javadesignpatternsspring.model.Client;

public interface ClientService {
    Iterable<Client> searchAll();

    Client searchById(Long id);

    void create(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}
