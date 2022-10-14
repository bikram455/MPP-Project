package business;

import java.util.ArrayList;
import java.util.HashMap;
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

	public static final SystemController INSTANCE = new SystemController();
	
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
		for (String k : books.keySet()) {
//			System.out.println("test"+books.get(k));
			String[] row = { books.get(k).getIsbn(), books.get(k).getTitle() };
			table.add(row);
		}
		return table;
//		DataAccess da = new DataAccessFacade();
//		List<String> retval = new ArrayList<>();
//		retval.addAll(da.readBooksMap().keySet());
//		return retval;
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
		if (u == null)
			throw new LoginException("Username or password incorrect!");
		return u;
	}

	@Override
	public void addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors)
			throws LibrarySystemException {
		// TODO Auto-generated method stub
		DataAccessFacade da = new DataAccessFacade();
		Book storedBook = da.searchBook(isbn);
		if (storedBook != null) {
			throw new LibrarySystemException("Book with ISBN " + isbn + " already exists");
		}
		Book book = new Book(isbn, title, maxCheckoutLength, authors);
		da.saveNewBook(book);
	}


	@Override
	public LibraryMember searchMember(String memberId) {
		// TODO Auto-generated method stub

		DataAccessFacade da = new DataAccessFacade();
		da.searchMember(memberId);
//		System.out.println("The member: " + da.searchMember(membId).getFirstName() + " " +da.searchMember(membId).getLastName());
		LibraryMember memeber = da.searchMember(memberId);
		if (memeber == null) {
			memberId = null;
		} else {
			List<Checkout> checkouts = memeber.getCheckouts();
			if (checkouts==null) {
				System.out.println("Checkout is empty");
			} else {
				for (int i = 0; i < checkouts.size(); i++)
					System.out.println(checkouts.get(i));
//			JOptionPane.showMessageDialog(SearchMember.this, da.searchMember(membId), "SUCESS",
//					JOptionPane.PLAIN_MESSAGE);
			}
		}
		return memeber;
	}
	
	@Override
    public void addMember(String id, String firstName, String lastName, String cell, String street, String city, String state, String zip) throws LibrarySystemException {
        if (id.length() == 0 || firstName.length() == 0 || lastName.length() == 0
                || cell.length() == 0 || street.length() == 0 || city.length() == 0
                || state.length() == 0 || zip.length() == 0) {
            throw new LibrarySystemException("All fields must be non-empty");
        }
        Address address = new Address(street, city, state, zip);
//        if (searchMember(id) != null) {
//            throw new LibrarySystemException("Library Member with ID " + id + " already exists");
//        }
        DataAccess da = new DataAccessFacade();
        LibraryMember member = new LibraryMember(id, firstName, lastName, cell, address);
        da.saveNewMember(member);
    }
	
	public Book searchBook(String isbn) {
		DataAccessFacade daf = new DataAccessFacade();
		Book book = daf.searchBook(isbn);
		return book;
	}
	
	@Override
	public void updateBook(Book book) {
		DataAccessFacade daf = new DataAccessFacade();
		daf.updateBook(book);
	}
	
}
