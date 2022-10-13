package librarysystem.panels;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Address;
import business.LibraryMember;
import dataaccess.DataAccessFacade;
import librarysystem.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AddMember extends JPanel {
	private JTextField memberId;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField phoneNumber;

	private JTextField street;
	private JTextField city;
	private JTextField state;
	private JTextField zip;

	/**
	 * Launch the application.
	 */
//		public static void main(String[] args) {
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						AddLibraryMember frame = new AddLibraryMember();
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}

	/**
	 * Create the frame.
	 */
	public AddMember() {
		init();
		System.out.println("insite add member page");
	}

	// @Override
	public void init() {
		setBounds(100, 100, 589, 450);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add Library Member");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 232, 26);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Member Id\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(40, 46, 123, 26);
		this.add(lblNewLabel_1);

		memberId = new JTextField();
		memberId.setBounds(163, 46, 237, 25);
		this.add(memberId);
		memberId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(40, 87, 95, 13);
		this.add(lblNewLabel_2);

		firstName = new JTextField();
		firstName.setBounds(163, 82, 237, 26);
		this.add(firstName);
		firstName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Last Name\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(40, 122, 83, 13);
		this.add(lblNewLabel_3);

		lastName = new JTextField();
		lastName.setBounds(163, 118, 237, 26);
		this.add(lastName);
		lastName.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Phone Number\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(40, 158, 122, 13);
		this.add(lblNewLabel_4);

		phoneNumber = new JTextField();
		phoneNumber.setBounds(163, 154, 237, 26);
		this.add(phoneNumber);
		phoneNumber.setColumns(10);

		JButton addMember = new JButton("ADD MEMBER");
		addMember.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addMember.setBounds(163, 338, 149, 26);
		addMember.addActionListener(addLibraryMemberListener());
		this.add(addMember);

		JLabel lblNewLabel_5 = new JLabel("Street");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(40, 196, 111, 13);
		this.add(lblNewLabel_5);

		street = new JTextField();
		street.setBounds(163, 190, 237, 24);
		this.add(street);
		street.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(40, 227, 83, 24);
		this.add(lblNewLabel_6);

		city = new JTextField();
		city.setBounds(163, 224, 237, 27);
		this.add(city);
		city.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("State");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(40, 264, 45, 13);
		this.add(lblNewLabel_7);

		state = new JTextField();
		state.setBounds(163, 260, 237, 26);
		this.add(state);
		state.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Zip");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(40, 296, 45, 24);
		this.add(lblNewLabel_8);

		zip = new JTextField();
		zip.setBounds(163, 296, 237, 26);
		this.add(zip);
		zip.setColumns(10);

	}

	public ActionListener addLibraryMemberListener() {
		ActionListener addMemberListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String membId = memberId.getText();
				String memberFirstName = firstName.getText();
				String memberLastName = lastName.getText();
				String telephone = phoneNumber.getText();
				String memberStreet = street.getText();
				String memberCity = city.getText();
				String memberState = state.getText();
				String memberZip = zip.getText();
				if (membId.isEmpty()) {
					JOptionPane.showMessageDialog(AddMember.this, "Id cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (memberFirstName.isEmpty()) {
					JOptionPane.showMessageDialog(AddMember.this, "First Name cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (memberLastName.isEmpty()) {
					JOptionPane.showMessageDialog(AddMember.this, "Last Name cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (telephone.isEmpty()) {
					JOptionPane.showMessageDialog(AddMember.this, "Phone Number cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (memberStreet.isEmpty()) {
					JOptionPane.showMessageDialog(AddMember.this, "Street cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (memberCity.isEmpty()) {
					JOptionPane.showMessageDialog(AddMember.this, "City cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (memberState.isEmpty()) {
					JOptionPane.showMessageDialog(AddMember.this, "State cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (memberZip.isEmpty()) {
					JOptionPane.showMessageDialog(AddMember.this, "Zip cannot be empty!!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Address address = new Address(memberStreet, memberCity, memberState, memberZip);
					LibraryMember libraryMember = new LibraryMember(memberFirstName, memberFirstName, memberLastName,
							telephone, address);
					DataAccessFacade daf = new DataAccessFacade();
					daf.saveNewMember(libraryMember);

					System.out.println(membId + " " + memberFirstName + " " + memberLastName + " " + telephone + " "
							+ address.toString());

				}
			}
		};
		return addMemberListener;
	}

}
