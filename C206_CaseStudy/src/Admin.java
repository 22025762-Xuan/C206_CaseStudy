//Achi
public class Admin extends User{
	private String name;
	private String userid;
	
	
	public Admin(String name, String  userid, String username, String password) {
		super(username,password);
		this.name = name;
		this.userid = userid;
		
		
	}
	public String getName() {
		return name;
	}
	public String getUserID() {
		return userid;
	}
	public String getPassword() {
		return super.getPassword();
	}
	
}
