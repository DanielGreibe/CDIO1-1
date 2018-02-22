package funktion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dal.IUserDAO.DALException;
import dal.UserStore;
import data.UserDTO;

public class DataManager implements IUserDAO {

	private List<UserDTO> users;
	private UserStore StoreObject;

	public DataManager() {
		users = new ArrayList<UserDTO>(89);
		StoreObject = new UserStore();
	}

	@Override
	public UserDTO getUser(int userId) throws DALException {

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
		int ID = user.getUserId();
		for (int j = 0; j < users.size(); j++) {
			if (users.get(j).getUserId() == ID)
				users.set(j, user);
		}



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
	
	private UserStore loadUsers() throws DALException {
		UserStore a = new UserStore();
		UserStore userStore = new UserStore();
		ObjectInputStream oIS = null;
		try {
			FileInputStream fIS = new FileInputStream("Data.txt");
			oIS = new ObjectInputStream(fIS);
			Object inObj = oIS.readObject();
			if (inObj instanceof UserStore){
				userStore = (UserStore) inObj;
			} else {
				throw new DALException("Wrong object in file");
			}
		} catch (FileNotFoundException e) {
			//No problem - just returning empty userstore
		} catch (IOException e) {
			throw new DALException("Error while reading disk!", e);
		} catch (ClassNotFoundException e) {
			throw new DALException("Error while reading file - Class not found!", e);
		} finally {
			if (oIS!=null){
				try {
					oIS.close();
				} catch (IOException e) {
					throw new DALException("Error closing pObjectStream!", e);
				}
			}
		}
		return userStore;
	}
	
	private void StoreInUserStore(UserDTO user)
	{
//		this.StoreObject.addUser(user);
	}
	

	private void saveUsers(UserStore users) throws DALException {
		ObjectOutputStream oOS =null;
		try {
			FileOutputStream fOS = new FileOutputStream("Data.txt");
			oOS = new ObjectOutputStream(fOS);
			oOS.writeObject(users);
		} catch (FileNotFoundException e) {
			throw new DALException("Error locating file", e);
		} catch (IOException e) {
			throw new DALException("Error writing to disk", e);
		} finally {
			if (oOS!=null) {
				try {
					oOS.close();
				} catch (IOException e) {
					throw new DALException("Unable to close ObjectStream", e);
				}
			}
		}	
	}

}
