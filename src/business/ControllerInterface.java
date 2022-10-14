package business;

import java.util.List;

import dataaccess.User;

public interface ControllerInterface {
	public User login(String id, String password) throws LoginException;
	public List<String[]> allMemberIds();
	public List<String[]> allBookIds();
	public void addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors) throws LibrarySystemException;
	public Book searchBook(String isbn);
	public void updateBook(Book book);
	 public void addMember(String id, String firstName, String lastName, String cell,
             String street, String city, String state, String zip)
throws LibrarySystemException;
}
