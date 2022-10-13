package librarysystem;


import javax.swing.JFrame;

import dataaccess.Auth;

public class SecondForm extends JFrame {

	private String auth;

	SecondForm(String auth) {

		this.auth = auth;
		System.out.println("user types is  : " + auth);
		initialize();
	}

	
	public void initialize() {
		setTitle("second Form ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(200, 200);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		setVisible(true);
	}
}
