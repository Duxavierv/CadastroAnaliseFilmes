
package com.senac.Filme.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Table(name="Filmes")
@Component
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    private String titulo;
    private String sinopse;
    private String genero;
    private int ano;
    private String capa;
    
    @OneToMany(mappedBy="filme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Analise> analises = new ArrayList<>();
    
    public void adicionarAnalise(Analise analise){
        analise.setFilme(this);
        this.analises.add(analise);
    } 
}
