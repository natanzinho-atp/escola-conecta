package br.com.techsolutions.escolaconecta.controller;

import br.com.techsolutions.escolaconecta.model.Chamado;
import br.com.techsolutions.escolaconecta.model.Usuario;
import br.com.techsolutions.escolaconecta.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }



@PostMapping("/usuarios")
 public Usuario cadastrar(@Valid @RequestBody Usuario usuario){

        return usuarioService.cadastrar(usuario);

 }

@GetMapping("/usuarios")
public List<Usuario> listar(){
        return usuarioService.listar();
}

@GetMapping("/usuarios/{id}")
public Usuario buscarPorId(@PathVariable Long id){return usuarioService.buscarPorId(id);
    }

    @DeleteMapping("/usuarios/{id}")
    public boolean excluir(@PathVariable Long id){
        return usuarioService.excluir(id);
    }

}
