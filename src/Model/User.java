package Model;

public class User {
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(){
		
	}
	public User(String uname, String upass, String telphone) {
		super();
		this.uname = uname;
		this.upass = upass;
		this.telphone = telphone;
		
	}
	public User(String uname, String upass){
		this.uname = uname;
		this.upass = upass;
		
	}
	private  String uname;
	private String upass;
	private  String telphone;
	private  String email;
	
	
	

}
