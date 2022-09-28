package com.cdio.dermatologroomsystem.entity;

import javax.persistence.*;

@Entity
@Table
public class AccountRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int account_role_id;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private Account account_id;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Role role_id;

	public AccountRole() {
	}

	public int getAccount_role_id() {
		return account_role_id;
	}

	public void setAccount_role_id(int account_role_id) {
		this.account_role_id = account_role_id;
	}

	public Account getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Account account_id) {
		this.account_id = account_id;
	}

	public Role getRole_id() {
		return role_id;
	}

	public void setRole_id(Role role_id) {
		this.role_id = role_id;
	}
}
