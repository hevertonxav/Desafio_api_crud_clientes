package com.heverton.client_management_api.services;

import com.heverton.client_management_api.dto.ClientDTO;
import com.heverton.client_management_api.dto.ClientUpdateDTO;
import com.heverton.client_management_api.entities.Client;
import com.heverton.client_management_api.repositories.ClientRepository;
import com.heverton.client_management_api.services.exceptions.CpfAlreadyExistsException;
import com.heverton.client_management_api.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;



    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
       Client client = repository.findById(id).orElseThrow(
               () -> new ResourceNotFoundException("Recurso não encontrado")
       );

       return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        checkDuplicateCpf(dto);
        Client entity = new Client();
        copyToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientUpdateDTO update(Long id, ClientUpdateDTO dto){

        try {
            Client entity = repository.getReferenceById(id);
            copyToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientUpdateDTO(entity);
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {

        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        repository.deleteById(id);
    }

    //método usado para criar um novo cliente
    private void copyToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }

    //método usado para atualizar um cliente já existente
    private void copyToEntity(ClientUpdateDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }

    private void checkDuplicateCpf(ClientDTO dto){

        if(repository.existsByCpf(dto.getCpf())){
            throw new CpfAlreadyExistsException("Cliente com o CPF " + dto.getCpf() + " já existe");
        }

    }


}
