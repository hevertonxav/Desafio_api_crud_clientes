package com.heverton.client_management_api.repositories;

import com.heverton.client_management_api.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Long> {

    boolean existsByCpf(String cpf);
}
