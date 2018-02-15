package funktion;

import java.util.List;

import data.UserDTO;

public class DataManager implements IUserDAO {
	
	private List<UserDTO> users;

	@Override
	public UserDTO getUser(int userId) throws DALException {
	
		return users.get(userId);
	}

	@Override
	public List<UserDTO> getUserList() throws DALException {
		
		return users;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {
		
		users.add(user);
		
	}

	@Override
	public void updateUser(UserDTO user) throws DALException {
		
		int i = user.getUserId();
		
		users.set(i-11, user);
		
		
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		
		users.remove(userId);
		
	}

}
