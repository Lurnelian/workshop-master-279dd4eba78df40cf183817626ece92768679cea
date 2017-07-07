package ru.relex.workshop.dto;

import ru.relex.workshop.domain.User;

public class UserDto {

	private Long id;
	private String email;
	private String password;
	private String description;
	
	public UserDto() {}
	
	public UserDto(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.description = user.getDescription();
	}
	
	public User toDomain() {
		return new User(this.id, this.email, this.password, this.description);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
