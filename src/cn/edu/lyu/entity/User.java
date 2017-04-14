package cn.edu.lyu.entity;

public class User {
	private int id;
	private String name;
	private String passwd;
	private String phone;
	private String email;
	
	public User(){
		super();
	}
	public User(String name,int id,String passwd){
		super();
		this.name = name;
		this.id = id;
		this.passwd = passwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof User){
			User other = (User)obj;
			return this.id == other.id;
		}
		return false;
	}
	
	
	

}
