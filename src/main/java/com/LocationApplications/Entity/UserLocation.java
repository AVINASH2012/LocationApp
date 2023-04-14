package com.LocationApplications.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserLocation implements Serializable  { 
	
	@Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name")
	private User user;
	
	
	@Column
	private int cordinate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCordinate() {
		return cordinate;
	}

	public void setCordinate(int cordinate) {
		this.cordinate = cordinate;
	} 
}
