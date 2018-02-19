package funktion;

import java.util.List;

import data.UserDTO;

public class DataManager implements IUserDAO {

	private List<UserDTO> users;

	@Override
	public UserDTO getUser(int userId) throws DALException {

		int j = 0;
		for (UserDTO i : users) {
			if (i.getUserId() == userId) {
				j = users.indexOf(userId);
			}
		}

		return users.get(j);

	}

	@Override
	public List<UserDTO> getUserList() throws DALException {

		return users;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {

		user = new UserDTO();

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
				j = users.indexOf(userId);
			}
		}

		users.remove(j);

	}

}
