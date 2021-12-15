package com.trabalhopw.trabalhopw.model;

import com.trabalhopw.trabalhopw.enuns.Perfil;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    @Column(unique = true)
    private String login;
    @JsonIgnore
    private String senha;

    private Perfil oerfil = Perfil.ROLE_ADMIN;

}
