package com.domain;

public class Mission {
	private int id;
	private Long user_id;
	private Long type_id;
	private Long time;
	private String content;

	public Mission() {
		super();
	}

	public Mission(Long user_id, Long type_id) {
		super();
		this.user_id = user_id;
		this.type_id = type_id;
	}

	public Mission(int id, Long user_id, Long type_id, Long time, String content) {
		this.id = id;
		this.user_id = user_id;
		this.type_id = type_id;
		this.time = time;
		this.content = content;
	}

	public Mission(Long user_id, Long type_id, Long time, String content) {

		this.user_id = user_id;
		this.type_id = type_id;
		this.time = time;
		this.content = content;
	}

	public Mission(int id, Long type_id, String content) {

		this.id = id;
		this.type_id = type_id;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Mission [id=" + id + ", user_id=" + user_id + ", type_id="
				+ type_id + ", time=" + time + ", content=" + content + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
