package cn.soa.entity;

import java.io.Serializable;

public class zhansan extends Person implements Serializable{
	Integer age;
	String address;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public zhansan(Integer age, String address) {
		super();
		this.age = age;
		this.address = address;
	}
	
}
