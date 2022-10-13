package librarysystem.panels;

import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class MenuList extends JPanel {
	JList menuList;
	/**
	 * Create the panel.
	 */
	public MenuList() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65)));
		setBackground(new Color(254, 255, 255));
		
		String[] items = getMenuList();
		menuList = new JList(items);
		add(menuList);
	}
	public String[] getMenuList() {
		String[] items = {"Logout", "Add Book"};
		return items;
	}
}
