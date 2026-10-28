package br.com.techsolutions.escolaconecta.controller;

import br.com.techsolutions.escolaconecta.model.Categoria;
import br.com.techsolutions.escolaconecta.model.Chamado;
import br.com.techsolutions.escolaconecta.model.Usuario;
import br.com.techsolutions.escolaconecta.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService){
        this.chamadoService = chamadoService;

    }

    @PostMapping("/chamados")
    public ResponseEntity<Chamado> cadastrar(@Valid @RequestBody Chamado chamado){
        Chamado chamadoSalvo = chamadoService.cadastrar(chamado);

        return ResponseEntity.status(HttpStatus.CREATED).body(chamadoSalvo);
    }


    @GetMapping("/chamados")
    public List<Chamado> listar(){
        return chamadoService.listar();
    }


    @GetMapping("/chamados/{id}")
    public Chamado buscarPorId(@PathVariable Long id){
        return chamadoService.buscarPorId(id);
    }

    @PutMapping("/chamados/{id}")
    public Chamado atualizar
            (@PathVariable Long id,@Valid @RequestBody Chamado chamado){
        return chamadoService.atualizar(id, chamado);
    }

    @DeleteMapping("/chamados/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){chamadoService
            .excluir(id);
        return ResponseEntity.noContent().build();
    }


}
