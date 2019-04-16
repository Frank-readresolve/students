package fr.formation.students.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.students.entities.Person;
import fr.formation.students.entities.Role;
import fr.formation.students.entities.UserAccount;
import fr.formation.students.repositories.PersonJpaRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PersonJpaRepository repo;

    protected UserDetailsServiceImpl(PersonJpaRepository repo) {
	this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
	    throws UsernameNotFoundException {
	Person person = repo.findByUserAccountUsername(username);
	if (person == null) {
	    throw new UsernameNotFoundException("with username: " + username);
	}
	UserAccount account = person.getUserAccount();
	return buildUser(account);
    }

    private User buildUser(UserAccount account) {
	String username = account.getUsername();
	String password = account.getPassword();
	boolean enabled = account.isEnabled();
	boolean accountNonExpired = account.isAccountNonExpired();
	boolean credentialsNonExpired = account.isCredentialsNonExpired();
	boolean accountNonLocked = account.isAccountNonLocked();
	Role role = account.getRole();
	Collection<? extends GrantedAuthority> authorities = buildAuthorities(
		role);
	return new User(username, password, enabled, accountNonExpired,
		credentialsNonExpired, accountNonLocked, authorities);
    }

    private Collection<? extends GrantedAuthority> buildAuthorities(Role role) {
	Set<GrantedAuthority> authorities = new HashSet<>();
	GrantedAuthority authority = new SimpleGrantedAuthority(role.name());
	authorities.add(authority);
	return authorities;
    }
}
