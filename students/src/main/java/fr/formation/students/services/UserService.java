package fr.formation.students.services;

import fr.formation.students.dtos.UserCreateDto;
import fr.formation.students.dtos.UserUpdateDto;

public interface UserService {

    void create(UserCreateDto user);

    void update(UserUpdateDto user);

    void delete(Long id);
}
