package librarysystem.panels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import business.LibraryMember;
import dataaccess.DataAccessFacade;

public class AllMemberId extends JPanel {
	HashMap<String, LibraryMember> members;
	JTable jt;
	/**
	 * Create the panel.
	 */
	public AllMemberId() {
		String[] columns = {"Member Id", "First Name", "Last Name"};
		members = new DataAccessFacade().readMemberMap();
		List<String[]> table = new ArrayList<>();
		
		for(String k: members.keySet()) {
			String[] row= {members.get(k).getMemberId(), members.get(k).getFirstName(), members.get(k).getLastName()};
			table.add(row);
		}
		String[][] tableData= table.toArray(String[][]::new);
		jt = new JTable(tableData, columns);
		
		jt.getColumnModel().getColumn(0).setPreferredWidth(100);
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(100);
		add(new JScrollPane(jt));
	}

}
