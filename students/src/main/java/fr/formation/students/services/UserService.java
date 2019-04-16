package fr.formation.students.services;

import fr.formation.students.dtos.UserCreateDto;

public interface UserService {

    void create(UserCreateDto user);

    void delete(Long id);
}
