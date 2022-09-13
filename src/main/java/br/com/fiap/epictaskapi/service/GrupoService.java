package br.com.fiap.epictaskapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.epictaskapi.model.Grupo;
import br.com.fiap.epictaskapi.repository.GrupoRepository;

@Service
public class GrupoService {
    
    @Autowired
    GrupoRepository repository;

    public List<Grupo> listAll(){
        return repository.findAll();
     }

}
