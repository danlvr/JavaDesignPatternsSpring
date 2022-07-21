package com.example.javadesignpatternsspring.service.implementation;

import com.example.javadesignpatternsspring.model.Address;
import com.example.javadesignpatternsspring.model.AddressRepository;
import com.example.javadesignpatternsspring.model.Client;
import com.example.javadesignpatternsspring.model.ClientRepository;
import com.example.javadesignpatternsspring.service.ClientService;
import com.example.javadesignpatternsspring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> searchAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client searchById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void create(Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientBd = clientRepository.findById(id);
        if (clientBd.isPresent()) {
            saveClientWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientWithCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.consultCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
