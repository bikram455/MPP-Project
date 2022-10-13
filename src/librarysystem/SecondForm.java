package librarysystem;

import javax.swing.JFrame;

import librarysystem.panels.*;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import business.ListItem;
import java.awt.BorderLayout;
import java.awt.CardLayout;


public class SecondForm extends JFrame {

	private String auth;
	private JPanel mainPanel;
	private JPanel contentPanel;

	// public static JTextArea statusBar = new JTextArea("Welcome to the Library
	// System!");

	// listItem
	ListItem addBookItem = new ListItem("Add Book", false);
	ListItem addBookCopyItem = new ListItem("Add Book Copy", false);

	ListItem[] librarianItems = { addBookItem };
	ListItem[] adminItems = { addBookCopyItem, addBookItem };
	ListItem[] allItems = { addBookCopyItem, addBookItem };

	public ListItem[] getAdminItems() {
		return adminItems;
	}

	public ListItem[] getAllItems() {
		return allItems;
	}

	public ListItem[] getLibrarianItems() {
		return librarianItems;
	}

	public void getItemsForUser(String auth) {
		if (auth == "LIBRARIAN")
			getLibrarianItems();
		if (auth == "ADMIN")
			getAdminItems();
		else
			getAllItems();

	}

	SecondForm(String auth) {

		this.auth = auth;
		getItemsForUser(this.auth);
		initialize();

		
		createMainPanels();

//		JPanel panel = new JPanel();
//		getContentPane().add(panel, BorderLayout.SOUTH);
//
//		JLabel lblNewLabel = new JLabel("New label");
//		panel.add(lblNewLabel);
		System.out.println("user types is  : " + auth);

	}

	public void initialize() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(200, 200);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		setVisible(true);
	}

	public void createMainPanels() {
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JPanel menuPanel = new MenuList(this);
		mainPanel.add(menuPanel, BorderLayout.WEST);

		 contentPanel = new Content();
		mainPanel.add(contentPanel, BorderLayout.CENTER);

		JPanel messagePanel = new Message();
		mainPanel.add(messagePanel, BorderLayout.SOUTH);
	}

	public void test(String page) {

		((Content) contentPanel).addLayout(page);
	}

}
