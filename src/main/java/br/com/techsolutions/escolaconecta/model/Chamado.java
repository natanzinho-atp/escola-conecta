package br.com.techsolutions.escolaconecta.model;

import br.com.techsolutions.escolaconecta.model.enums.Prioridade;
import br.com.techsolutions.escolaconecta.model.enums.StatusChamado;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Solicitante é obrigatório")
    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Usuario solicitante;

    @NotNull(message = "Categoria é obigatória")
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    @Enumerated(EnumType.STRING)
    private StatusChamado status;


    public Chamado() {
    }

    public Chamado(Long id, String titulo, String descricao, Usuario solicitante, Categoria categoria, Prioridade prioridade, StatusChamado status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.solicitante = solicitante;
        this.categoria = categoria;
        this.prioridade = prioridade;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }
}
