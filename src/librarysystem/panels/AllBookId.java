package librarysystem.panels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import business.Book;
import dataaccess.DataAccessFacade;

public class AllBookId extends JPanel {

	/**
	 * Create the panel.
	 */
	public AllBookId() {
//		TestData td = new TestData();
//		List<Book> books = td.allBooks;
		display();
	}
	
	public void display(){
		HashMap<String, Book> books = new DataAccessFacade().readBooksMap();
		String[] columns = {"Book Id", "Book Title"};
		
		List<String[]> table = new ArrayList<>();
		for(String k: books.keySet()) {
//			System.out.println("test"+books.get(k));
			String[] row = {books.get(k).getIsbn(), books.get(k).getTitle()};
			table.add(row);
		}
		String[][] tableData= table.toArray(String[][]::new);
		JTable jt = new JTable(tableData, columns);
		JScrollPane jp = new JScrollPane();
		jt.getColumnModel().getColumn(0).setPreferredWidth(100);
		jt.getColumnModel().getColumn(1).setPreferredWidth(200);
		add(new JScrollPane(jt));
	}

}
