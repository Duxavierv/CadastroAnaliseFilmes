package com.senac.Filme.controller;

import com.senac.Filme.model.Filme;
import com.senac.Filme.service.AnaliseService;
import com.senac.Filme.service.FilmeService;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FilmeControllerIT {

    private FilmeController controller;
    private FilmeService filmeService;
    private AnaliseService analiseService;

    @Before
    public void setUp() {
        
    }

    @Test
    public void testExibirFormulario() {
        Model model = new ExtendedModelMap();
        String resultado = controller.exibirFormulario("escuro", model);
        
        assertEquals("FilmeCadastro", resultado);
        assertTrue(model.containsAttribute("Filme"));
        assertEquals("escuro", model.asMap().get("css"));
    }

    @Test
    public void testProcessarFormulario() {
        Filme filme = new Filme();
        String resultado = controller.processarFormulario(filme);
        
        verify(filmeService).salvar(filme);  
        assertEquals("redirect:/Filme/lista", resultado);
    }

    @Test
    public void testLista() {
        when(filmeService.listarTodos()).thenReturn(List.of(new Filme()));
        Model model = new ExtendedModelMap();
        
        String resultado = controller.lista("claro", model);
        
        assertEquals("FilmeListagem", resultado);
        assertTrue(model.containsAttribute("Filmes"));
        assertEquals("claro", model.asMap().get("css"));
    }

    @Test
    public void testAlterar() {
        Filme filme = new Filme();
        when(filmeService.buscarPorId(1)).thenReturn(filme);
        Model model = new ExtendedModelMap();
        
        String resultado = controller.alterar(1, "escuro", model);
        
        assertEquals("FilmeCadastro", resultado);
        assertEquals("escuro", model.asMap().get("css"));
        assertEquals(filme, model.asMap().get("Filme"));
    }

    @Test
    public void testExcluir() {
        String resultado = controller.excluir(1);
        verify(filmeService).excluir(1);
        assertEquals("FilmeListagem", resultado); 
    }

    @Test
    public void testExibirDetalhes() {
        Filme filme = new Filme();
        when(filmeService.buscarPorId(1)).thenReturn(filme);
        when(analiseService.ListarPorFilme(1)).thenReturn(List.of());

        Model model = new ExtendedModelMap();
        String resultado = controller.exibirDetalhes(1, "claro", model);

        assertEquals("detalhes", resultado);
        assertEquals("claro", model.asMap().get("css"));
        assertEquals(filme, model.asMap().get("filme"));
        assertTrue(model.containsAttribute("analises"));
    }
}
