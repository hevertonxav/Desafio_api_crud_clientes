package com.heverton.client_management_api.dto;

import com.heverton.client_management_api.entities.Client;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;


public class ClientDTO {

    private Long id;

    @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;

    @CPF(message = "O campo cpf precisa ser válido.")
    @NotBlank(message = "Campo requerido")
    private String cpf;

    @Positive(message = "O valor da renda precisa ser positivo")
    private Double income;

    @PastOrPresent(message =  "Não pode ser data futura")
    private LocalDate birthDate;

    @PositiveOrZero(message = "A quantidade de filhos não pode ser menor que zero")
    private Integer children;

    public ClientDTO(){

    }

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
