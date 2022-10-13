package librarysystem.panels;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.CardLayout;

public class Content extends JPanel {

	/**
	 * Create the panel.
	 */
	public Content() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65), new Color(170, 121, 65)));
		setLayout(new CardLayout(0, 0));

	}

}