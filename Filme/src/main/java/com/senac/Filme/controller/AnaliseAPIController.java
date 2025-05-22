
package com.senac.Filme.controller;

import com.senac.Filme.model.Analise;
import com.senac.Filme.service.AnaliseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analise")
@CrossOrigin(origins= "*")
public class AnaliseAPIController {
    @Autowired
    private AnaliseService analiseService;
    
    @GetMapping("/filme/{filmeid}")
    public List<Analise> ListarTodos(@PathVariable int filmeid){
        return analiseService.ListarPorFilme(filmeid);
    }
    
    @GetMapping("/{id}")
    public Analise buscarPotId(@PathVariable int id) {
        return analiseService.buscarPorId(id);
    }
    @PostMapping
    public Analise criarAnalise(@RequestBody Analise analise) {
      return analiseService.salvar(analise);
    }
    @PutMapping("/{id}")
    public Analise atualizarAnalise(@PathVariable int id, @RequestBody Analise analiseAtualizado){
     return analiseService.salvar(analiseAtualizado);
    }
    @DeleteMapping("/{id}")
    public void deletarAnalise(@PathVariable int id){
        analiseService.excluir(id);
    }
}
