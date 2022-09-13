package br.com.fiap.epictaskapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.epictaskapi.model.Grupo;
import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.GrupoRepository;
import br.com.fiap.epictaskapi.repository.RoleRepository;
import br.com.fiap.epictaskapi.repository.TaskRepository;
import br.com.fiap.epictaskapi.repository.UserRepository;

@Configuration
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    GrupoRepository grupoRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        
        taskRepository.saveAll(List.of(
            new Task("Modelar o BD", "Modelar as tabelas do banco de dados"),
            new Task("Protipar telas", "Modelar as tabelas do banco de dados"),
            new Task("Bug", "Modelar as tabelas do banco de dados"),
            new Task("Deploy", "Modelar as tabelas do banco de dados"),
            new Task("Login", "Modelar as tabelas do banco de dados"),
            new Task("Outro Bug", "Modelar as tabelas do banco de dados"),
            new Task("Logout", "Modelar as tabelas do banco de dados"),
            new Task("Cadastro de cliente", "Modelar as tabelas do banco de dados"),
            new Task("Consulta de cliente", "Modelar as tabelas do banco de dados")
        ));

        // userRepository.save(List.of(
        //     new User()
        //         .name("João")
        //         .email("joao@fiap.com.br")
        //         .password(passwordEncoder.encode("123"))
        // ));

        userRepository.saveAll(List.of(
            new User("Joao", "joao@fiap.com.br", passwordEncoder.encode("123")),
            new User("Marcos", "marcos@fiap.com.br", passwordEncoder.encode("456")),
            new User("Julia", "julia@fiap.com.br", passwordEncoder.encode("789")),
            new User("Admin", "admin@fiap.com.br", passwordEncoder.encode("administrador"))
        ));


        grupoRepository.saveAll(List.of(
            new Grupo("89171", "Bianca Man Tchuin Chang Lee"),
            new Grupo("89045", "Danilo Zequim de Moura"),
            new Grupo("87087", "Eric Brianez Giannetti"),
            new Grupo("86931", "Matheus Pismel de Jeronymo"),
            new Grupo("87680", "Otavio de Magalhães Gomes"),
            new Grupo("87149", "Zack Lorenzzo Corrêa")
        ));
        
    }
    
}
