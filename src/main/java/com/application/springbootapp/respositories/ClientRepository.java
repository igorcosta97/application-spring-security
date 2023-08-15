package com.application.springbootapp.respositories;

import com.application.springbootapp.models.client.ClientModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, String>{

}