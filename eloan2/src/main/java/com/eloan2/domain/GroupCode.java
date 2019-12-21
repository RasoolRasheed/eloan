package com.eloan2.domain;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usergroup")
public class GroupCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="groupCode")
	private String groupCode;
	
	@Column(name="Description")
	private String Description;
	
	@Column(name="Active")
	private int Active;
	
	@Column(name="crUser")
	private String crUser;
	
	@Column(name="crTimeStamp")
	private Timestamp crTimeStamp;

	 @OneToMany(mappedBy="gcode") 
	 private Set<Users> Users;
	 
	public Set<Users> getUsers() {
		return Users;
	}
	public void setUsers(Set<Users> users) {
		Users = users;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
	}

	public String getCrUser() {
		return crUser;
	}

	public void setCrUser(String crUser) {
		this.crUser = crUser;
	}

	public Timestamp getCrTimeStamp() {
		return crTimeStamp;
	}

	public void setCrTimeStamp(Timestamp crTimeStamp) {
		this.crTimeStamp = crTimeStamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
