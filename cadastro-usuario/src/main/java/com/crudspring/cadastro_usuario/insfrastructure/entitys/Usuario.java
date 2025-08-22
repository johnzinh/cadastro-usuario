package com.crudspring.cadastro_usuario.insfrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter                          //getters e setters
@Setter
@AllArgsConstructor             //construtores
@NoArgsConstructor
@Builder                        //pra fazer update
@Table(name = "usuario")        //indicar que é uma tabela
@Entity
public class Usuario {
    @Id                                                           //indicar que é o id unico
    @GeneratedValue(strategy = GenerationType.AUTO)               //gera id automaticamente
    private Integer id;

    @Column(name = "email", unique = true)                        //coluna de email UNICO
    private String email;

    @Column(name = "nome")                                        //coluna de nome
    private String nome;


}
