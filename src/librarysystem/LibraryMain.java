package librarysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import librarysystem.panels.*;

import java.awt.BorderLayout;

public class LibraryMain extends JFrame {
	public static JTextArea statusBar = new JTextArea("Welcome to our Library System!");

	private JPanel mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryMain frame = new LibraryMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LibraryMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		createMainPanels();

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
