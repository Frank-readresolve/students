package fr.formation.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.students.entities.Person;

public interface PersonJpaRepository extends JpaRepository<Person, Long> {

    Person findByUserAccountUsername(String username);
}
