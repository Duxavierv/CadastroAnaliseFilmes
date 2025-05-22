
package com.senac.Filme.service;

import com.senac.Filme.model.Analise;
import com.senac.Filme.repository.AnaliseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {
    @Autowired
    private AnaliseRepository analiseRepository;
    
    public List<Analise> ListarPorFilme(int filmeId){
        return analiseRepository.findByFilmeId(filmeId);
    }
    
    public Analise salvar(Analise analise){
        return analiseRepository.save(analise);
    }
    public void excluir(int id){
        analiseRepository.deleteById(id);
    }
    public Analise buscarPorId(int id) {
        return analiseRepository.findById(id).orElse(null);
    }
}
