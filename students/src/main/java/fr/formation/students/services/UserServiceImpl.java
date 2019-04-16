package fr.formation.students.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.students.dtos.UserCreateDto;
import fr.formation.students.entities.Person;
import fr.formation.students.entities.UserAccount;
import fr.formation.students.repositories.PersonJpaRepository;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;

    private final PersonJpaRepository repo;

    public UserServiceImpl(PersonJpaRepository repo, PasswordEncoder encoder) {
	this.repo = repo;
	this.encoder = encoder;
    }

    @Override
    public void create(UserCreateDto dto) {
	Person person = new Person();
	person.setFirstname(dto.getFirstname());
	person.setLastname(dto.getLastname());
	person.setBirthdate(dto.getBirthdate());
	UserAccount account = new UserAccount();
	account.setUsername(dto.getUserAccount().getUsername());
	String decoded = dto.getUserAccount().getPassword();
	String encoded = encoder.encode(decoded);
	account.setPassword(encoded);
	person.setUserAccount(account);
	repo.save(person);
    }

    @Override
    public void delete(Long id) {
	repo.deleteById(id);
    }
}
