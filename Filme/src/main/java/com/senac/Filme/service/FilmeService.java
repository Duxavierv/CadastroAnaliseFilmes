
package com.senac.Filme.service;

import com.senac.Filme.model.Filme;
import com.senac.Filme.repository.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository FilmeRepository;
    
    public Filme salvar(Filme filme){
        return FilmeRepository.save(filme);   
    }
    
    public List<Filme> listarTodos(){
        return FilmeRepository.findAll(); 
    }
    public Filme buscarPorId(int id){
       return FilmeRepository.findById(id).orElse(null);
    }
    public void excluir(int id){
        FilmeRepository.deleteById(id);
    }
    
    
    
    
    }
