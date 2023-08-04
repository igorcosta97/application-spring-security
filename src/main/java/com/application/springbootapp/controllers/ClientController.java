package com.application.springbootapp.controllers;

import com.application.springbootapp.dtos.ClientRecordDto;
import com.application.springbootapp.models.ClientModel;
import com.application.springbootapp.respositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clients")
    public ResponseEntity<List<ClientModel>> getAllClients() {
        var allClients = clientRepository.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(allClients);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Object> getOneClient(@PathVariable(value="id") String id){
        var client = clientRepository.findById(id);
        if(client.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(client);
    }
    @PostMapping("/clients")
    public ResponseEntity<ClientModel> saveClient(@RequestBody @Valid ClientRecordDto clientRecordDto){
        var clientModel = new ClientModel();
        //Converte o clientRecordDto em clientModel não necessitando criar construtor
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(clientModel));
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable(value="id") String id, @RequestBody @Valid ClientRecordDto clientRecordDto){
        var client = clientRepository.findById(id);
        if(!client.isEmpty()) {
            var clientModel = client.get();
            BeanUtils.copyProperties(clientRecordDto, clientModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(clientModel));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value="id") String id){
        var client = clientRepository.findById(id);
        if(client.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        clientRepository.deleteById(id);
        return ResponseEntity.ok("Client deleted successfully");
    }
}
