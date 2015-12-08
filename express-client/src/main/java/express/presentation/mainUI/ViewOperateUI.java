package express.presentation.mainUI;

import java.awt.Color;

import javax.swing.JPanel;

public class ViewOperateUI extends JPanel {

	private MainUIService m;
	
	public ViewOperateUI(MainUIService main){
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
	}
}
