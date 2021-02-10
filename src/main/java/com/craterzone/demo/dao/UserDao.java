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
@Table(name = "users")
public class UserDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	@Column
	private String name;
	@Column(name = "username",unique = true)
	private String username;
	@Column
	private String password;
	@OneToOne(mappedBy = "user")
	private AddressDao address;
	@OneToOne(mappedBy = "user")
	private ContactDao contact;
	@Column(unique = true)
	private String email;
	
	
	
	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDao(String name, String username, String password, AddressDao address, ContactDao contact,
			String email) {
		super();
		//this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.contact = contact;
		this.email = email;
	}
	public int getId() {
		return user_id;
	}
	public void setId(int id) {
		this.user_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AddressDao getAddress() {
		return address;
	}
	public void setAddress(AddressDao address) {
		this.address = address;
	}
	public ContactDao getContact() {
		return contact;
	}
	public void setContact(ContactDao contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UserDao [id=" + user_id + ", name=" + name + ", userName=" + username + ", password=" + password
				+ ", address=" + address + ", contact=" + contact + ", email=" + email + "]";
	}
	
	
	
	
	
	
}
