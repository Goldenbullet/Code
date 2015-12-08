package express.presentation.managerUI;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class Reminder extends JDialog{

	private JButton ok;
	private String str;
	
	public Reminder(String s){
		str = s;
		this.setTitle("提示");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 200);
		
		ok = new JButton("确认");
		ok.setFont(new Font("隶书",Font.PLAIN,18));
		ok.setBounds(100, 150, 100, 30);
		ok.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				dispose();
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
			
		});
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		g.setFont(new Font("方正启体",Font.PLAIN,18));
		g.drawString(str, 50, 30);
	}
}
