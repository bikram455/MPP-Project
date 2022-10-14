package business;

import java.util.List;

import dataaccess.User;

public interface ControllerInterface {
	public User login(String id, String password) throws LoginException;
	public List<String[]> allMemberIds();
	public List<String[]> allBookIds();
	public Book searchBook(String isbn);
	public void updateBook(Book book);
}
