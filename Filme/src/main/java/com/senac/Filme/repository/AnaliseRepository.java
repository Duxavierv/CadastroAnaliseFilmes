
package com.senac.Filme.repository;

import com.senac.Filme.model.Analise;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Integer> {
    
    List<Analise> findByFilmeId(int filmeid); 
}
