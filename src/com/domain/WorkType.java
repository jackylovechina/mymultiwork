package com.domain;

public class WorkType {
	private Long id;
	private String type;

	public WorkType() {
		// TODO Auto-generated constructor stub
		super();
	}

	public WorkType(String type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}

	public WorkType(Long id, String type) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.type = type;
	}

	@Override
	public String toString() {
		return "WorkType [id=" + id + ", type=" + type + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
