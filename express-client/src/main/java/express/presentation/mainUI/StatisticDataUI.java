package express.presentation.mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StatisticDataUI extends JPanel {

	private JButton exit;
	private MainUIService m;
	private String str;

	public StatisticDataUI(MainUIService main, int index,String s) {
		setLayout(null);
		m = main;
		str = s;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.BLACK);
		Font font = new Font("楷体", Font.PLAIN, 20);
		Font f = new Font("仿宋", Font.PLAIN, 18);

		exit = new JButton("取消");
		exit.setBounds(360, 590, 110, 40);
		exit.setFont(new Font("隶书", Font.PLAIN, 20));
		this.add(exit);

		Listener listener = new Listener();

		exit.addMouseListener(listener);
	}

	private class Listener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exit) {
				m.jumpToViewStatisticUI(str);
			}
			repaint();
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
