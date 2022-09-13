package br.com.fiap.epictaskapi.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService service;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    @Cacheable("user")
    public Page<User> index( @PageableDefault(size = 10, sort = "id") Pageable pageable){
        return service.listAll(pageable);
    }

    @GetMapping("{id}")
    @Cacheable("User")
    public ResponseEntity<User> show(@PathVariable Long id){
        return ResponseEntity.of( service.getById(id) );   
    }

    @PostMapping
    @CacheEvict(value="user", allEntries = true)
    public ResponseEntity<User> create(@RequestBody @Valid User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("{id}")
    @CacheEvict(value="user", allEntries = true)
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid User newUser){

        if(newUser.getPassword() != null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha não pode ser alterada.");

        Optional<User> optional = service.getById(id);

        if (optional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        var user = optional.get();
        String[] fildsIgnored = { "id", "password"};
        BeanUtils.copyProperties(newUser, user, fildsIgnored);
        // user.setId(id);

        service.save(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("{id}")
    @CacheEvict(value="user", allEntries = true)
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        Optional<User> optional = service.getById(id);

        if (optional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
