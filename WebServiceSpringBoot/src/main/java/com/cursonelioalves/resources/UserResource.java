package com.cursonelioalves.resources;

import com.cursonelioalves.entities.User;
import com.cursonelioalves.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController                     //Informando que essa classe será de um controlador rest, que receberá as requisições dos usuários
@RequestMapping(value = "/users")   //Informando endpoint para que seja possível acessar requisições da rota users
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
