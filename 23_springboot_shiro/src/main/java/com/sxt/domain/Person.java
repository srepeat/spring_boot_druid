package com.sxt.domain;

public class Person {

	private Integer id;
	private String name;
	private String address;
	private Integer sex;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(Integer id, String name, String address, Integer sex) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	
}
