package librarysystem.panels;

import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import librarysystem.SecondForm;

public class MenuList extends JPanel {
	public JList menuList;
	public SecondForm lib;
	/**
	 * Create the panel.
	 */
	public MenuList(SecondForm lib) {
		this.lib = lib;
		setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65)));
		setBackground(new Color(254, 255, 255));

		String[] items = getMenuList();

		menuList = new JList(items);
//		menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		menuList.setModel(new AbstractListModel() {		
//			public int getSize() {
//				return items.length;
//			}
//			public Object getElementAt(int index) {
//				return items[index];
//			}
//		});
		menuList.addListSelectionListener(event->{
			lib.test(menuList.getSelectedValue().toString());
		});
		add(menuList);

	}

	public String[] getMenuList() {
		String[] items = {"Logout", "Add Book", "Add Member", "Search Book"};
		return items;
	}
}
