package com.cursonelioalves.resources;

import com.cursonelioalves.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                     //Informando que essa classe será de um controlador rest, que receberá as requisições dos usuários
@RequestMapping(value = "/users")   //Informando endpoint para que seja possível acessar requisições da rota users
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "999999", "12345");
        return ResponseEntity.ok().body(u);
    }
}
