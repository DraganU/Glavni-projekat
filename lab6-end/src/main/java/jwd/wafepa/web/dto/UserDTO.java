package jwd.wafepa.web.dto;

import jwd.wafepa.model.User;

public class UserDTO {

	private Long id;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private Integer logCount;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String email) {
		this.id = id;
		this.email = email;
	}

	public UserDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		if (user.getLogs() != null) {
			this.logCount = user.getLogs().size();
		}
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getLogCount() {
		return logCount;
	}

	public void setLogCount(Integer logCount) {
		this.logCount = logCount;
	}

}
