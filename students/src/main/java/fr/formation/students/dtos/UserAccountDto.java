package fr.formation.students.dtos;

import javax.validation.constraints.NotBlank;

public class UserAccountDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public UserAccountDto() {
	// TODO Auto-generated constructor stub
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}
