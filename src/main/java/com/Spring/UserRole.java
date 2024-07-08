package com.Spring;

import javax.persistence.*;

@Table(name="user_role")
@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int role_id;

	@Column
	private String role;

	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User user;

	

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
