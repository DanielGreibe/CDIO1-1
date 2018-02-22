package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import dal.IUserDAO.DALException;
import dal.UserStore;

// User Data Object
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 4545864587995944260L;
	private int userId;
	private String userName;
	private String ini;
	private String CPR;
	public passWord password;

	public String getCPR() {
		return CPR;
	}

	public void setCPR(String cPR) {
		CPR = cPR;
	}

	public passWord getPassword() {
		return password;
	}

	public void setPassword(passWord password) {
		this.password = password;
	}

	private List<String> roles;

	public class passWord {

		public passWord() {
			
		}

		public String generatePassWord() {

			String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
			StringBuilder salt = new StringBuilder();
			Random rnd = new Random();
			while (salt.length() < 10) { // length of the random string.
				int index = (int) (rnd.nextFloat() * SALTCHARS.length());
				salt.append(SALTCHARS.charAt(index));
			}
			String saltStr = salt.toString();
			return saltStr;

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

	public boolean removeRole(String role) {
		return this.roles.remove(role);
	}

	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", ini=" + ini + ", roles=" + roles + "]";
	}
	



}
