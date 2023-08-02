package com.application.springbootapp.controllers;

import com.application.springbootapp.models.ClientModel;
import com.application.springbootapp.respositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clients")
    public ResponseEntity<List<ClientModel>> getAllProducts() {
        var allClients = clientRepository.findAll();
        return ResponseEntity.ok(allClients);
    }
}
