package librarysystem.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.Book;
import dataaccess.DataAccessFacade;

public class SearchBook extends JPanel{
	private JTextField isbn;
	public SearchBook() {
		init();
//		JLabel label = new JLabel("this is search book.");
//		add(label);
	}
	public void init() {
		setBounds(100, 100, 589, 450);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 232, 26);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search Book By ISBN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(40, 46, 223, 26);
		this.add(lblNewLabel_1);
		
		isbn = new JTextField();
		isbn.setBounds(263, 46, 237, 25);
		this.add(isbn);
		isbn.setColumns(10);
		
		JButton addBookCopy = new JButton("SEARCH");
		addBookCopy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addBookCopy.setBounds(500, 46, 223, 26);
		addBookCopy.addActionListener(searchBookListener());
		this.add(addBookCopy);
	}
	public ActionListener searchBookListener() {
		ActionListener searchBookListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String iSbn = isbn.getText();
                
                if (iSbn.isEmpty()) {
					JOptionPane.showMessageDialog(SearchBook.this, "ISBN cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					DataAccessFacade daf = new DataAccessFacade();
					Book book = daf.searchBook(iSbn);
					if (book == null) {
						System.out.println("Book not found");
					} else {
						System.out.println("Book found"+ book.toString());
						isbn.setText("");;

					}
				}}
        };
		return searchBookListener;
	}
	
}
