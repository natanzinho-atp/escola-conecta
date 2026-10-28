package br.com.techsolutions.escolaconecta.controller;

import br.com.techsolutions.escolaconecta.model.Categoria;
import br.com.techsolutions.escolaconecta.service.CategoriaService;
import br.com.techsolutions.escolaconecta.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){

        this.categoriaService = categoriaService;
    }

    @PostMapping("/categorias")
    public Categoria cadastrar(@RequestBody Categoria categoria){

        return categoriaService.cadastrar(categoria);
    }

    @GetMapping("/categorias")
    public List<Categoria> listar(){
        return categoriaService.listar();
    }

    @GetMapping("/categorias/{id}")
    public Categoria buscarPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @DeleteMapping("/categorias/{id}")
    public boolean excluir(@PathVariable Long id){
        return categoriaService.excluir(id);
    }

}
