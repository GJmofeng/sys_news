package com.news.entity;

public class User {
	private Integer id;
	private String stno;
	private String pwd;
	private String name;
	private String email;
	private String time;
	private double sums;
	private String img;

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getSums() {
		return sums;
	}
	public void setSums(double sums) {
		this.sums = sums;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStno() {
		return stno;
	}
	public void setStno(String stno) {
		this.stno = stno;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	

}
