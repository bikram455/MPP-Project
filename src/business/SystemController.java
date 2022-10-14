package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	
	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
		
	}
	@Override
	public List<String[]> allMemberIds() {
		HashMap<String, LibraryMember> members;
		members = new DataAccessFacade().readMemberMap();
		List<String[]> table = new ArrayList<>();

		for (String k : members.keySet()) {
			String[] row = { members.get(k).getMemberId(), members.get(k).getFirstName(),
					members.get(k).getLastName() };
			table.add(row);
		}
		return table;
//		DataAccess da = new DataAccessFacade();
//		List<String> retval = new ArrayList<>();
//		retval.addAll(da.readMemberMap().keySet());
//		return retval;
	}
	
	@Override
	public List<String[]> allBookIds() {
		HashMap<String, Book> books = new DataAccessFacade().readBooksMap();
		List<String[]> table = new ArrayList<>();
		for(String k: books.keySet()) {
//			System.out.println("test"+books.get(k));
			String[] row = {books.get(k).getIsbn(), books.get(k).getTitle()};
			table.add(row);
		}
		return table;
//		DataAccess da = new DataAccessFacade();
//		List<String> retval = new ArrayList<>();
//		retval.addAll(da.readBooksMap().keySet());
//		return retval;
	}
	
	
}
