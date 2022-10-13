package librarysystem;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import dataaccess.Auth;
import librarysystem.panels.*;
//import librarysystem.uipanels.AddBookCopyPanel;
//import librarysystem.uipanels.AddBookPanel;
//import librarysystem.uipanels.AllBookIDs;
//import librarysystem.uipanels.CheckoutBookPanel;
//import librarysystem.uipanels.CheckoutRecordPanel;
//import librarysystem.uipanels.LandingPanel;
//import librarysystem.uipanels.LoginPanel;
//import librarysystem.uipanels.NewMemberPanel;
//import librarysystem.uipanels.OverDueBooksPanel;
//import librarysystem.uipanels.Util;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import business.ListItem;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

public class SecondForm extends JFrame {

	private String auth;
	private JPanel mainPanel;
	//JList<ListItem> linkList;
	//public static JTextArea statusBar = new JTextArea("Welcome to the Library System!");



	SecondForm(String auth) {

		this.auth = auth;
		initialize();
		createMainPanels();

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
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

		JPanel menuPanel = new MenuList();
		mainPanel.add(menuPanel, BorderLayout.WEST);

		JPanel contentPanel = new Content();
		mainPanel.add(contentPanel, BorderLayout.CENTER);

		JPanel messagePanel = new Message();
		mainPanel.add(messagePanel, BorderLayout.SOUTH);
	}

	
}
