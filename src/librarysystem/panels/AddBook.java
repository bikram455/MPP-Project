package librarysystem.panels;

//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class AddBook extends JPanel {
//
//	/**
//	 * Create the panel.
//	 */
//	public AddBook() {
//		JLabel label = new JLabel("this is add book.");
//		add(label);
//	}
//
//}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import business.Address;
import business.Author;
import business.Book;
import business.ControllerInterface;
import business.LibraryMember;
import business.LibrarySystemException;
import business.SystemController;
import dataaccess.DataAccessFacade;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddBook extends JPanel {

	private final ControllerInterface sc = SystemController.INSTANCE;
	private JTextField isbn;
	private JTextField authorFirstName;
	private JTextField title;
	private JTextField checkoutLength;
	private JTextField textLastName;
	private JTextField authorPhone;

	public AddBook() {
		init();
	}

	/**
	 * Create the frame.
	 */
	public void init() {
		setBounds(100, 100, 538, 472);
		this.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADD BOOK");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 191, 24);
		this.add(lblNewLabel);

		JLabel txtIsbn = new JLabel("ISBN\r\n");
		txtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIsbn.setBounds(54, 63, 95, 13);
		this.add(txtIsbn);

		isbn = new JTextField();
		isbn.setBounds(202, 62, 247, 26);
		this.add(isbn);
		isbn.setColumns(10);

		JLabel txtAuthorFN = new JLabel("Author First Name");
		txtAuthorFN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAuthorFN.setBounds(54, 140, 137, 13);
		this.add(txtAuthorFN);

		authorFirstName = new JTextField();
		authorFirstName.setBounds(202, 135, 247, 28);
		this.add(authorFirstName);
		authorFirstName.setColumns(10);

		JLabel txtTitle = new JLabel("Title");
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTitle.setBounds(54, 102, 95, 13);
		this.add(txtTitle);

		title = new JTextField();
		title.setBounds(202, 98, 247, 26);
		this.add(title);
		title.setColumns(10);

		JLabel txtCheckLength = new JLabel("Checkout Length");
		txtCheckLength.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCheckLength.setBounds(54, 267, 137, 24);
		this.add(txtCheckLength);

		checkoutLength = new JTextField();
		checkoutLength.setBounds(202, 259, 247, 32);
		this.add(checkoutLength);
		checkoutLength.setColumns(10);

		JButton addBookBtn = new JButton("ADD BOOK");
		addBookBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addBookBtn.setBounds(202, 308, 209, 29);
		addBookBtn.addActionListener(addBookListener());
		this.add(addBookBtn);

		JLabel txtAuthorLN = new JLabel("Author Last Name");
		txtAuthorLN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAuthorLN.setBounds(54, 178, 137, 24);
		this.add(txtAuthorLN);

		textLastName = new JTextField();
		textLastName.setBounds(202, 173, 247, 29);
		this.add(textLastName);
		textLastName.setColumns(10);

		JLabel txtAuthorPhone = new JLabel("Author Phone\r\n");
		txtAuthorPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAuthorPhone.setBounds(54, 216, 128, 26);
		this.add(txtAuthorPhone);

		authorPhone = new JTextField();
		authorPhone.setBounds(202, 212, 247, 34);
		this.add(authorPhone);
		authorPhone.setColumns(10);

	}

	public ActionListener addBookListener() {
		ActionListener addBookListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookIsbn = isbn.getText();
				String bookAuthorFirstName = authorFirstName.getText();
				String bookAuthorLastName = textLastName.getText();
				String authorPhoneNumber = authorPhone.getText();
				String bookTitle = title.getText();
				String checkoutLengthData = checkoutLength.getText();

				if (bookIsbn.isEmpty()) {
					JOptionPane.showMessageDialog(AddBook.this, "ISBN cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (bookAuthorFirstName.isEmpty()) {
					JOptionPane.showMessageDialog(AddBook.this, "Title cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (bookAuthorLastName.isEmpty()) {
					JOptionPane.showMessageDialog(AddBook.this, "Last Name cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (authorPhoneNumber.isEmpty()) {
					JOptionPane.showMessageDialog(AddBook.this, "Phone Number cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (bookTitle.isEmpty()) {
					JOptionPane.showMessageDialog(AddBook.this, "Title cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (checkoutLengthData.isEmpty()) {
					JOptionPane.showMessageDialog(AddBook.this, "Checkout Length cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int bookCheckoutLength = 0;

					try {
						bookCheckoutLength = Integer.parseInt(checkoutLengthData);

						Address address = new Address("101 S. Main", "Fairfield", "IA", "52556");
						Author author = new Author(bookAuthorFirstName, bookAuthorLastName, authorPhoneNumber, address,
								"He is Good.");
						Book book = new Book(bookIsbn, bookTitle, bookCheckoutLength, List.of(author));
						sc.addBook(bookIsbn, bookTitle, bookCheckoutLength, List.of(author));

						isbn.setText("");
						authorFirstName.setText("");
						textLastName.setText("");
						authorPhone.setText("");
						title.setText("");
						checkoutLength.setText("");
						JOptionPane.showMessageDialog(AddBook.this, "Book Added", "SUCESS", JOptionPane.PLAIN_MESSAGE);
					} catch (NumberFormatException err) {
						JOptionPane.showMessageDialog(AddBook.this, "Checkout Length must be number!!!", "Error",
								JOptionPane.ERROR_MESSAGE);

					} catch (LibrarySystemException e1) {
						JOptionPane.showMessageDialog(AddBook.this, "Isbn Already Exist!!!", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		};
		return addBookListener;
	}

}
