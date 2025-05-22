
package com.senac.Filme.controller;

import com.senac.Filme.model.Analise;
import com.senac.Filme.model.Filme;
import com.senac.Filme.service.AnaliseService;
import com.senac.Filme.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/analise")
public class AnaliseController {
    @Autowired
    private FilmeService filmeService;
     
    @Autowired
    private AnaliseService analiseService;
    
    @PostMapping("/gravar/{filmeId}")
    public String adicionarAnalise(@PathVariable int filmeId, @ModelAttribute Analise novaAnalise){
       Filme filme = filmeService.buscarPorId(filmeId);
       if(filme != null){
           filme.adicionarAnalise(novaAnalise);
           filmeService.salvar(filme);
       }
       return "redirect:/Filme/detalhes/" + filmeId;
    }
     @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        analiseService.excluir(id);
        return "FilmeListagem";
    }
    }
