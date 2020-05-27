package com.example.JavaReack.jugtours.controller;


import com.example.JavaReack.jugtours.model.Group;
import com.example.JavaReack.jugtours.model.GroupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GroupController {
    private final GroupRepository repository;

    public GroupController(GroupRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/groups")
    Collection<Group> groups() {
        return repository.findAll();
    }

    @GetMapping("/group/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id) {
        Optional<Group> groupOpt = repository.findById(id);
        return groupOpt.map(group -> ResponseEntity.ok().body(group)).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/group")
    ResponseEntity<Group> createGroup(@Validated @RequestBody Group group) throws URISyntaxException {
        Group result = repository.save(group);
        return ResponseEntity.created(new URI("/api/group/" + result.getId())).body(result);
    }

    @PutMapping("/group/{id}")
    ResponseEntity<Group> updateGroup(@Validated @RequestBody Group group) {
        Group result = repository.save(group);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/group/{id}")
    ResponseEntity<Group> deleteGroup(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
