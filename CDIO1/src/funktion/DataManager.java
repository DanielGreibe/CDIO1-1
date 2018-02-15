package funktion;

import java.util.List;
import data.UserDTO;

public class DataManager implements IUserDAO {
	
	private List<UserDTO> users;

	@Override
	public UserDTO getUser(int userId) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> getUserList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDTO user) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
