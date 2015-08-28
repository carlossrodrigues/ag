package ag.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class PanelCromossomo extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelCromossomo() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblResult = new JLabel("result");
		add(lblResult, BorderLayout.EAST);

	}

}
