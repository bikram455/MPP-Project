package librarysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.LoginException;
import business.SystemController;
import dataaccess.User;

public class Login extends JFrame {

	private JPanel mainPanel, contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordField;
	private JButton btnNewButton;

	Login() {
		initialize();
		userLogin();

	}

	public void initialize() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(200, 200);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		setVisible(true);
	}

	public void formatContentPane() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 1));
		getContentPane().add(mainPanel);
	}

	public void userLogin() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		lblNewLabel.setBounds(250, 6, 973, 93);
		contentPane.add(lblNewLabel);

		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		userNameTextField.setBounds(481, 170, 281, 68);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(481, 286, 281, 68);
		contentPane.add(passwordField);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblUsername.setBounds(250, 166, 193, 52);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPassword.setBounds(250, 286, 143, 52);
		contentPane.add(lblPassword);

		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.setBounds(385, 399, 162, 73);
		btnNewButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userName = userNameTextField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText().toString();

				if (userName.isEmpty()) {
					JOptionPane.showMessageDialog(Login.this, "UserName cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else if (password.isEmpty()) {
					JOptionPane.showMessageDialog(Login.this, "Password cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						String authorization = "";
						User user = new SystemController().login(userName, password);
						if (user != null) {
							authorization += user.getAuthorization();
							new SecondForm(authorization).setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Invalid UserName or Password !!!", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (LoginException exc) {
						JOptionPane.showMessageDialog(null, "Invalid UserName or Password !!!", "Error",
								JOptionPane.ERROR_MESSAGE);
						System.out.println("The exception is: " + exc);
					}
				}

			}

		});

		contentPane.add(btnNewButton);

	}
}
