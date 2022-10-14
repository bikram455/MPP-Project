package business;

import java.util.ArrayList;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.TestData;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	
//	public void login(String id, String password) throws LoginException {
//		DataAccess da = new DataAccessFacade();
//		HashMap<String, User> map = da.readUserMap();
//		if(!map.containsKey(id)) {
//			throw new LoginException("ID " + id + " not found");
//		}
//		String passwordFound = map.get(id).getPassword();
//		if(!passwordFound.equals(password)) {
//			throw new LoginException("Password incorrect");
//		}
//		currentAuth = map.get(id).getAuthorization();
//		
//	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}

	@Override
	public User login(String userName, String password) throws LoginException {
		TestData test = new TestData();
		List<User> users = test.allUsers;

		
		
		User u = null;
		for (User user : users) {
			if (userName.contains(user.getId()) && password.contains(user.getPassword())) {
				u = user;
				
				break;
			}
		}
		if(u == null) throw new LoginException("Username or password incorrect!");
		return u;
	}
	
}
