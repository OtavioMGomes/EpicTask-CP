package br.com.fiap.epictaskapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.epictaskapi.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
