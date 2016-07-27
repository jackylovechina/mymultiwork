package com.domain;

import java.util.List;

public class UserType {
	private Long user_id;
	private Long type_id;
	private List<WorkType> worktype;

	public List<WorkType> getWorktype() {
		return worktype;
	}

	public void setWorktype(List<WorkType> worktype) {
		this.worktype = worktype;
	}

	public UserType() {
		super();
	}

 
	public UserType(Long user_id, Long type_id) {

		this.user_id = user_id;
		this.type_id = type_id;

	}

	@Override
	public String toString() {
		return "UserType [user_id=" + user_id + ", type_id=" + type_id
				+ ", worktype=" + worktype + "]";
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}
}
