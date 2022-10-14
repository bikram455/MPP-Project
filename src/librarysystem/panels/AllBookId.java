package librarysystem.panels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import business.Book;
import business.SystemController;
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
		SystemController sc = new SystemController();
		List<String[]> table = sc.allBookIds();
		String[] columns = {"Book Id", "Book Title"};
	
		String[][] tableData= table.toArray(String[][]::new);
		JTable jt = new JTable(tableData, columns);
		JScrollPane jp = new JScrollPane();
		jt.getColumnModel().getColumn(0).setPreferredWidth(100);
		jt.getColumnModel().getColumn(1).setPreferredWidth(200);
		add(new JScrollPane(jt));
	}
	

}
