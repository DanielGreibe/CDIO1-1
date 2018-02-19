package funktion;

import java.util.ArrayList;
import java.util.List;

import data.UserDTO;

public class DataManager implements IUserDAO {

	private List<UserDTO> users;

	public DataManager() {
		users = new ArrayList<UserDTO>(89);
	}

	@Override
	public UserDTO getUser(int userId) throws DALException {

		int j = 0;
		for (UserDTO i : users) {
			if (i.getUserId() == userId) {

				return i;
			}
		}
		return null;
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

		int i = users.indexOf(user);

		users.set(i, user);

	}

	@Override
	public void deleteUser(int userId) throws DALException {

		int j = 0;
		for (UserDTO i : users) {
			if (i.getUserId() == userId) {
				j = users.indexOf(i);
				break;
			}
		}

		users.remove(j);

	}

}
