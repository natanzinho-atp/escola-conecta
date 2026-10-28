package br.com.techsolutions.escolaconecta.service;

import br.com.techsolutions.escolaconecta.exception.RecursoNaoEncontradoException;
import br.com.techsolutions.escolaconecta.model.Categoria;
import br.com.techsolutions.escolaconecta.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService (CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria cadastrar(Categoria categoria){

        if (categoria.getNome() == null || categoria.getNome().isBlank()){
            return null;
        }

        if (categoria.getDescricao() == null || categoria.getDescricao().isBlank()){
            return null;
        }


        return categoriaRepository.save(categoria);
    }


    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id){
       return categoriaRepository.findById(id)
               .orElseThrow(()->new RecursoNaoEncontradoException(
                       "Categoria não encontrada"
               ));
    }

    public boolean excluir(Long id){
        if (!categoriaRepository.existsById(id)){
            return false;
        }
        categoriaRepository.deleteById(id);
        return true;
    }

}
