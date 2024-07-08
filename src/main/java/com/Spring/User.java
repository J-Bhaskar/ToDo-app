package com.Spring;



import java.util.*;


import javax.persistence.*;


@Table(name="user")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	@Column(name="userName")
	private String userName;

	@Column(name="userPass")
	private String userPass;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserRole> userRoles = new ArrayList<>();

	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;

		for (UserRole r : userRoles) {
			r.setUser(this);
		}
	}

}
