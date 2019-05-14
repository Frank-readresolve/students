package fr.formation.students.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.students.dtos.UserCreateDto;
import fr.formation.students.dtos.UserUpdateDto;
import fr.formation.students.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    protected void create(@Valid @RequestBody UserCreateDto user) {
	service.create(user);
    }

    @PutMapping
    protected void update(@Valid @RequestBody UserUpdateDto user) {
	service.update(user);
    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    protected void delete(@PathVariable("id") Long id) {
	service.delete(id);
    }
}
