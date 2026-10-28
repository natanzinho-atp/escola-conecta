package br.com.techsolutions.escolaconecta.service;

import br.com.techsolutions.escolaconecta.exception.RecursoNaoEncontradoException;
import br.com.techsolutions.escolaconecta.model.Categoria;
import br.com.techsolutions.escolaconecta.model.Chamado;
import br.com.techsolutions.escolaconecta.model.Usuario;
import br.com.techsolutions.escolaconecta.model.enums.Prioridade;
import br.com.techsolutions.escolaconecta.model.enums.StatusChamado;
import br.com.techsolutions.escolaconecta.repository.CategoriaRepository;
import br.com.techsolutions.escolaconecta.repository.ChamadoRepository;
import br.com.techsolutions.escolaconecta.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;

    public ChamadoService(
            ChamadoRepository chamadoRepository,
            UsuarioRepository usuarioRepository,
            CategoriaRepository categoriaRepository
            ){
        this.chamadoRepository = chamadoRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Chamado cadastrar(Chamado chamado){

        if (chamado.getSolicitante() == null ||
                chamado.getSolicitante().getId() == null){
            return null;
        }

        if (chamado.getCategoria() == null || chamado.getCategoria().getId() == null){
            return null;
        }

        Usuario usuario = usuarioRepository.findById(chamado.getSolicitante().getId())
                .orElseThrow(()->new RecursoNaoEncontradoException(
                        "Usuario não encontrado"
                ));


        Categoria categoria = categoriaRepository.findById(chamado.getCategoria().getId())
                .orElseThrow(()->new RecursoNaoEncontradoException(
                        "Categoria não encontrada"
                ));


        chamado.setSolicitante(usuario);
        chamado.setCategoria(categoria);
        chamado.setStatus(StatusChamado.ABERTO);

        if (chamado.getPrioridade() == null){
            chamado.setPrioridade(Prioridade.MEDIA);
        }

        return chamadoRepository.save(chamado);
    }

    public List<Chamado> listar(){
        return chamadoRepository.findAll();
    }

    public Chamado buscarPorId(Long id){
        return
                chamadoRepository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException(
                        "chamado não encontrado"
                )
        );
    }

    public Chamado atualizar(Long id, Chamado chamado){

        Chamado chamadoExistente = chamadoRepository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException(
                "chamado não encontrado"
        ));


        if(chamado.getTitulo() == null
                || chamado.getTitulo().isBlank()){
            return null;
        }

        if(chamado.getDescricao() == null
                || chamado.getDescricao().isBlank()){
            return null;
        }

        if (chamado.getSolicitante() == null
                || chamado.getSolicitante().getId() == null) {
            return null;
        }

        if (chamado.getCategoria() == null
                || chamado.getCategoria().getId() == null){
                return null;
        }

        Usuario usuario = usuarioRepository
                .findById(chamado.getSolicitante()
                .getId()).orElse(null);

        if (usuario == null){
            return null;
        }

        Categoria categoria = categoriaRepository
                .findById(chamado.getCategoria()
                        .getId()).orElse(null);

        if (categoria == null){
            return null;
        }

        chamadoExistente.setTitulo(chamado.getTitulo());
        chamadoExistente.setDescricao(chamado.getDescricao());
        chamadoExistente.setSolicitante(usuario);
        chamadoExistente.setCategoria(categoria);
        chamadoExistente.setPrioridade(chamado.getPrioridade());
        chamadoExistente.setStatus(chamado.getStatus());

        return chamadoRepository.save(chamadoExistente);

    }

    public void excluir(Long id){
        if (!chamadoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException(
                    "Chamado não encontrado"
            );
        }
        chamadoRepository.deleteById(id);
    }



}
