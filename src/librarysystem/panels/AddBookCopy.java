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
import business.SystemController;

public class AddBookCopy extends JPanel {
	private JTextField isbn;
	/**
	 * Create the panel.
	 */
	public AddBookCopy() {
		init();
//		JLabel label = new JLabel("this is add book copy.");
//		add(label);
	}
	public void init() {
		setBounds(100, 100, 589, 450);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Book Copy");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 232, 26);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ISBN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(40, 46, 123, 26);
		this.add(lblNewLabel_1);
		
		isbn = new JTextField();
		isbn.setBounds(163, 46, 237, 25);
		this.add(isbn);
		isbn.setColumns(10);
		
		JButton addBookCopy = new JButton("ADD BOOK COPY");
		addBookCopy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addBookCopy.setBounds(500, 46, 223, 26);
		addBookCopy.addActionListener(addBookCopyListener());
		this.add(addBookCopy);
	}
	
	public ActionListener addBookCopyListener() {
		ActionListener addBookCopyListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String iSbn = isbn.getText();
                
                if (iSbn.isEmpty()) {
					JOptionPane.showMessageDialog(AddBookCopy.this, "ISBN cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					SystemController sc = new SystemController();
					Book book = sc.searchBook(iSbn);
					if (book == null) {
						System.out.println("Book not found");
					} else {
						book.addCopy();
						sc.updateBook(book);
						JOptionPane.showMessageDialog(AddBookCopy.this, "Book Copy Added", "SUCESS",
								JOptionPane.PLAIN_MESSAGE);
						System.out.println("Book Copy Added");
						isbn.setText("");
					}
				}}
        };
		return addBookCopyListener;
	}
	public void addBookCopy(String isbn) {
		
	}
}
