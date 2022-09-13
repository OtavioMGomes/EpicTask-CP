package br.com.fiap.epictaskapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.epictaskapi.model.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    
}
