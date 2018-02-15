package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// User Data Object
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 4545864587995944260L;
	private int userId;
	private String userName;
	private String ini;
	private List<String> roles;

	// TODO Add relevant fields

	class passWord {
		
		public passWord() {
			
		}
		
		private String generatePassWord() {
			
			return null;
			
		}

	}

	public UserDTO() {
		this.roles = new ArrayList<>();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIni() {
		return ini;
	}

	public void setIni(String ini) {
		this.ini = ini;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public void addRole(String role) {
		this.roles.add(role);
	}

	public boolean roleExists(String role) {
		return this.roles.contains(role);
	}
	
	public boolean removeRole(String role){
		return this.roles.remove(role);
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", ini=" + ini + ", roles=" + roles + "]";
	}

}
