package librarysystem;


import javax.swing.JFrame;

import dataaccess.Auth;

public class SecondForm extends JFrame {

	private String auth;

	SecondForm(String auth) {

		this.auth = auth;
		System.out.println("user types is  : " + auth);
	}

	
}
