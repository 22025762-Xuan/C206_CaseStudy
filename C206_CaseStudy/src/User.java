//Isaac
//SuperClass for all 
public class User {
	private String username;
	private String password;
	
	public User(String username, String password) {		
	this.username = username;
	this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void showInfo( ) {
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}

	


}
