package librarysystem.panels;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.CardLayout;

public class Content extends JPanel {
	private JPanel prev;
	private AddBook addBook;
	private AddMember addMember;
	private SearchBook searchBook;
	/**
	 * Create the panel.
	 */
	public Content() {
		addBook = new AddBook();
		addMember = new AddMember();
		searchBook = new SearchBook();

		setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65)));
		setLayout(new CardLayout(0, 0));
		addBook.setVisible(false);
		add(addBook);
		addMember.setVisible(false);
		add(addMember);
		searchBook.setVisible(false);
		add(searchBook);

		this.addLayout("'Add Book");
	}
	public void addLayout(String page) {
		if(prev != null) prev.setVisible(false);
		switch(page) {
			case "Add Book":
				prev = addBook;
				addBook.setVisible(true);
				break;
			case "Add Member":
				prev = addMember;
				addMember.setVisible(true);
				break;
			case "Search Book":
				prev = searchBook;
				searchBook.setVisible(true);
				break;
		}
	}

}