
package com.senac.Filme.controller;

import com.senac.Filme.model.Filme;
import com.senac.Filme.service.FilmeService;
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
@RequestMapping("/api/filme")
@CrossOrigin(origins= "*")
public class FilmeAPIController {
    @Autowired
    private FilmeService filmeService;
    
    @GetMapping
    public List<Filme> ListarTodos(){
        return filmeService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Filme buscarFilme(@PathVariable int id) {
        return filmeService.buscarPorId(id);
    }
    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme) {
      return filmeService.salvar(filme);
    }
    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable int id, @RequestBody Filme filmeAtualizado){
     return filmeService.salvar(filmeAtualizado);
    }
    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable int id){
        filmeService.excluir(id);
    }
}
