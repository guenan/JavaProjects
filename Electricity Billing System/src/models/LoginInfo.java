package models;

public class LoginInfo {
	private String meter;
	private String userType;
	private String userName;
	private String userLoginName;
	private String userPassword;
	
	public LoginInfo() {		
	}

	public LoginInfo(String meter, String userType, String userName, String userLoginName, String userPassword) {
		super();
		this.meter = meter;
		this.userType = userType;
		this.userName = userName;
		this.userLoginName = userLoginName;
		this.userPassword = userPassword;
	}

	public String getMeter() {
		return meter;
	}

	public void setMeter(String meter) {
		this.meter = meter;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	

}
