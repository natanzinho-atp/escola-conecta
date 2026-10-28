package br.com.techsolutions.escolaconecta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "E-mail é Obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, message = "Senha deve possuir no mínimo 8 caractéres")
    private String senha;

    private Boolean ativo;


    public Usuario() {
    }


    public Usuario(Long id, String nome, String email, String senha, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
