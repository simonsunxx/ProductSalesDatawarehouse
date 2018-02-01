package entity;

/**
 * @author Sun
 *
 */
public class User {
	int user_id;
	int user_password;
	int user_permission;
	String user_name;
	
	public User(int user_id, int user_password, int user_permission,
			String user_name) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_permission = user_permission;
		this.user_name = user_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_password() {
		return user_password;
	}
	public void setUser_password(int user_password) {
		this.user_password = user_password;
	}
	public int getUser_permission() {
		return user_permission;
	}
	public void setUser_permission(int user_permission) {
		this.user_permission = user_permission;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	

}
