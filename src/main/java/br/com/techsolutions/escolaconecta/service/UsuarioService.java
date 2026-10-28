package br.com.techsolutions.escolaconecta.service;

import br.com.techsolutions.escolaconecta.exception.RecursoNaoEncontradoException;
import br.com.techsolutions.escolaconecta.model.Chamado;
import br.com.techsolutions.escolaconecta.model.Usuario;
import br.com.techsolutions.escolaconecta.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario){

        if (usuario.getNome() == null || usuario.getNome().isBlank()){
            return null;
        }

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id){
        return usuarioRepository
                .findById(id).orElseThrow(()->new RecursoNaoEncontradoException(
                        "Usuario não encontrado"
                ));
    }

    public boolean excluir(Long id){
        if (!usuarioRepository.existsById(id)){
            return false;
        }
        usuarioRepository.deleteById(id);
        return true;
    }


}
