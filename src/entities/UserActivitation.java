package entities;

import core.abstracts.Entity;

public class UserActivitation implements Entity{

	private int id;
	private int userId;
	private String activationCode;
	
	public UserActivitation() {}

	public UserActivitation(int id, int userId, String activationCode) {
		super();
		this.id = id;
		this.userId = userId;
		this.activationCode = activationCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getActivationCode() {
		return this.activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
}
