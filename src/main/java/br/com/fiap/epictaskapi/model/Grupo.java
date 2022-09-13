package br.com.fiap.epictaskapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rm;
    private String name;
    
    public Grupo(Long id, String rm, String name) {
        this.id = id;
        this.rm = rm;
        this.name = name;
    }

    public Grupo(String rm, String name) {
        this.rm = rm;
        this.name = name;
    }

    public Grupo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Grupo [id=" + id + ", name=" + name + ", rm=" + rm + "]";
    }

}
