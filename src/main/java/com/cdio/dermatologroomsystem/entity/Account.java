package com.cdio.dermatologroomsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Account {
	@Id
	private String username;
	private String password;
}
