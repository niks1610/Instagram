package com.craterzone.demo.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class ContactNo {
	
	@Id
	private int id;
	@NotNull
	private String cc;
	@NotNull
	private String number;
	
	public ContactNo(String cc,String mobileno)
	{
		this.cc = cc;
		this.number = mobileno;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getMobileno() {
		return number;
	}

	public void setMobileno(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Mobile [cc=" + cc + ", mobileno=" + number + "]";
	}
	
	

}
