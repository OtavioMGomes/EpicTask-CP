package br.com.fiap.epictaskapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.epictaskapi.model.Grupo;
import br.com.fiap.epictaskapi.service.GrupoService;

@RestController
@RequestMapping("/api/grupo")
public class GrupoController {

    @Autowired
    GrupoService service;

    @GetMapping
    @Cacheable("grupo")
    public List<Grupo> index(){
        return service.listAll();
    }
    
}
