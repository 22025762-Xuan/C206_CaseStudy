//Achi
public class Admin {
	private String name;
	private String userid;
	private String password;
	
	public Admin(String name, String  userid, String password) {
		this.name = name;
		this.userid = userid;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getUserID() {
		return userid;
	}
	public String getPassword() {
		return password; 
	}
	
}
