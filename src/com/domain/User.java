package com.domain;

public class User {

	private Long id;
	private String userinfo;
	private int password;

	public User() {
		super();
	}

	public User(String userinfo, int password) {
		this.userinfo = userinfo;
		this.password = password;
	}

	public User(Long id, String userinfo, int password) {
		this.id = id;
		this.userinfo = userinfo;
		this.password = password;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userinfo=" + userinfo + ", password="
				+ password + "]";
	}

}
