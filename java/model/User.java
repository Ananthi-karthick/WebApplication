package model;

public class User {
	private int userId;
	private String name;
	private String email;
	private String gender;
	private String userName;
	private String password;
	private long contactNo;
	
	public User(String name, String email,String gender, long contactNo,String userName, String password) {
	
		this.name = name;
		this.email = email;
		this.gender=gender;
		this.userName=userName;
		this.password = password;
		this.contactNo = contactNo;
	}

	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public User() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	
	
}
