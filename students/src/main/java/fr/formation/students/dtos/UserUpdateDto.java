package fr.formation.students.dtos;

import javax.validation.constraints.NotNull;

public class UserUpdateDto extends UserDto {

    @NotNull
    private Long id;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
}
