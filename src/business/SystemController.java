package business;

import java.time.LocalDate;
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

	public static final SystemController INSTANCE = new SystemController();

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
	}

	@Override
	public List<String[]> allBookIds() {
		HashMap<String, Book> books = new DataAccessFacade().readBooksMap();
		List<String[]> table = new ArrayList<>();
		for (String k : books.keySet()) {
			String[] row = { books.get(k).getIsbn(), books.get(k).getTitle(), String.valueOf(books.get(k).getCopies().length) };
			table.add(row);
		}
		return table;
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
		DataAccessFacade da = new DataAccessFacade();
		da.searchMember(memberId);
		LibraryMember memeber = da.searchMember(memberId);
		if (memeber == null) {
			memberId = null;
		} else {
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
        if (searchMember(id) != null) {
            throw new LibrarySystemException("Library Member with ID " + id + " already exists");
        }
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

	@Override
	public boolean checkoutBook(Book checkBook, LibraryMember member, HashMap<String, LibraryMember> libMembers, DataAccessFacade da, HashMap<String, Book> books) {
		boolean flag = false;
		BookCopy[] bc = checkBook.getCopies();
		for(int i = 0; i < bc.length; i++) {
			if(bc[i].isAvailable()) {
				flag = true;
				LocalDate checkDate = LocalDate.now();
				LocalDate dueDate = checkDate.plusDays(checkBook.getMaxCheckoutLength());
				member.addCheckout(new CheckoutRecordEntry(checkBook, bc[i].getCopyNum(),  checkDate, dueDate));
				bc[i].changeAvailability();
				da.saveMembersMap(libMembers);
				da.saveBooksMap(books);
				return true;
			}
		}
		return false;
	}
}
