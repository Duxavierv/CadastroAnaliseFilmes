
package com.senac.Filme.controller;

import com.senac.Filme.model.Filme;
import com.senac.Filme.service.AnaliseService;
import com.senac.Filme.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Filme")
public class FilmeController {
    @Autowired
    private FilmeService FilmeService;
    
    @Autowired
    private AnaliseService analiseService;
    
    @GetMapping("/cadastro")
    public String exibirFomulario(@CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
         model.addAttribute("css", tema);
        model.addAttribute("Filme", new Filme());
        return "FilmeCadastro";
    }
    @PostMapping("/gravar")
    public String processarFormulario(@ModelAttribute Filme filme){
        FilmeService.salvar(filme);
        return "redirect:/Filme/lista";
    } 
    @GetMapping("/lista")
    public String lista(@CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
        model.addAttribute("css", tema);
        model.addAttribute("Filmes", FilmeService.listarTodos());
        return "FilmeListagem";
    }
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable int id, @CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
        model.addAttribute("css", tema);
        model.addAttribute("Filme", FilmeService.buscarPorId(id));
        return "FilmeCadastro";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        FilmeService.excluir(id);
        return "FilmeListagem";
    }
    @GetMapping("/detalhes/{id}")
    public String exibirDetalhes(@PathVariable int id, @CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
      Filme filme = FilmeService.buscarPorId(id);
      model.addAttribute("css", tema);
      model.addAttribute("filme", filme);
      model.addAttribute("analises", analiseService.ListarPorFilme(id));
      return "detalhes";
    }
}
