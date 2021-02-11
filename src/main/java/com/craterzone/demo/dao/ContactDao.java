package com.craterzone.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "contact")
public class ContactDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String cc;
	@Column
	private String number;
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserDao user;
	
	public UserDao getUser() {
		return user;
	}
	public void setUser(UserDao user) {
		this.user = user;
	}
	public ContactDao(int id, String cc, String number) {
		super();
		this.id = id;
		this.cc = cc;
		this.number = number;
	}
	public ContactDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "ContactDao [id=" + id + ", cc=" + cc + ", number=" + number + "]";
	}
	
	
}
