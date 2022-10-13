package librarysystem.panels;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Content extends JPanel {
	private JPanel prev;
	private AddBook addBook;
	private AddMember addMember;
	private SearchBook searchBook;
	private SearchMember searchMember;
	private AddBookCopy addBookCopy;
	private AllBookId allBookId;
	private AllMemberId allMemberId;
	private CheckoutBook checkoutBook;
	/**
	 * Create the panel.
	 */
	public Content(String auth) {
		addBook = new AddBook();
		addMember = new AddMember();
		searchBook = new SearchBook();
		searchMember = new SearchMember();
		addBookCopy = new AddBookCopy();
		allBookId = new AllBookId();
		allMemberId = new AllMemberId();
		checkoutBook = new CheckoutBook();

		
		setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65)));
		setLayout(new CardLayout(0, 0));
		addBook.setVisible(false);
		add(addBook);
		addMember.setVisible(false);
		add(addMember);
		searchBook.setVisible(false);
		add(searchBook);
		searchMember.setVisible(false);
		add(searchMember);
		addBookCopy.setVisible(false);
		add(addBookCopy);
		checkoutBook.setVisible(false);
		add(checkoutBook);
		allBookId.setVisible(false);
		add(allBookId);
		allMemberId.setVisible(false);
		add(allMemberId);

		if(auth.equals("ADMIN")) this.addLayout("Add Member");
		else this.addLayout("Checkout Book");
	}
	public void addLayout(String page) {
		System.out.println("this is page:"+page);
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
			case "Search Member":
				prev = searchMember;
				searchMember.setVisible(true);
				break;
			case "Add Book Copy":
				prev = addBookCopy;
				addBookCopy.setVisible(true);
				break;
			case "All Book Id":
				prev = allBookId;
				allBookId.setVisible(true);
				break;
			case "All Member Id":
				prev = allMemberId;
				allMemberId.setVisible(true);
				break;
			case "Checkout Book":
				prev = checkoutBook;
				checkoutBook.setVisible(true);
				break;
		}
	}

}