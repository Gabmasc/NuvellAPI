package com.project.nuvell.controller;

import com.project.nuvell.entity.UserEscort;
import com.project.nuvell.service.UserEscortService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/nuvell-api/v1")
public class UserEscortController {

    private UserEscortService service;

    public UserEscortController(UserEscortService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserEscort>> getAll(){
        List<UserEscort> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEscort> getById(@PathVariable("id") Long id){
        UserEscort user = service.findById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserEscort> post(@RequestBody UserEscort user){
        service.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).body(user);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id,
                                       @RequestBody UserEscort userToUpdate){
        var user = service.update(userToUpdate);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
