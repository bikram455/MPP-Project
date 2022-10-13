package librarysystem.panels;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import librarysystem.SecondForm;

public class MenuList extends JPanel {
	public JList menuList;
	public SecondForm lib;
	public HashMap<String, String> options;
	/**
	 * Create the panel.
	 */
	public MenuList(SecondForm lib, String access) {
		this.lib = lib;
		setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65)));
		setBackground(new Color(254, 255, 255));
		
		options = new HashMap<>();
		options.put("Checkout Book", "LIBRARIAN");
		options.put("Search Member", "LIBRARIAN");
		options.put("Add Member", "ADMIN");
		options.put("Add Book", "ADMIN");
//		options.put("ADMIN", "Add Book");
//		options.put("ADMIN", "Add Book");
		String[] items = getMenuList(access);

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

	public String[] getMenuList(String access) {
		List<String> itemList = new ArrayList<>();
		if(access.equals("BOTH")) {
			for(String k: options.keySet()) itemList.add(k);
		} else {
			for(String k: options.keySet()) {
				if(access.equals(options.get(k))) {
					itemList.add(k);
				}
			}	
		}
		itemList.add("Logout");
		String[] items = itemList.toArray(String[]:: new);
		return items;
	}
}
