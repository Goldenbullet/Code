package express.presentation.userUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop.Action;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import express.Client.Client;

public class TestLogin {
	
	public void start(){
		final JFrame loginFrame=new JFrame();
		JButton exitbutton= new JButton(new ImageIcon("picture/quitlogin.png"));
		JButton yesbutton= new JButton(new ImageIcon("picture/yesbutton.png"));
		MyDrawPanel1 pane=new MyDrawPanel1();
		loginFrame.getContentPane().add(pane);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pane.add(exitbutton);
		
		pane.setLayout(null);
		
		loginFrame.setSize(300, 350);
		
		JTextField usertext=new JTextField("[用 户 名]");
		usertext.setSize(190, 46);
		usertext.setLocation(77, 97);
		pane.add(usertext);
		

		
		JPasswordField passtext=new JPasswordField();
		passtext.setSize(190, 46);
		passtext.setLocation(77, 157);
		pane.add(passtext);
		
		exitbutton.setSize(28,28);
		exitbutton.setBorderPainted(false);
		exitbutton.setLocation(270,0);
		pane.add(exitbutton);
		
		yesbutton.setSize(252, 46);
		yesbutton.setBorderPainted(false);
		yesbutton.setLocation(25, 260);
		pane.add(yesbutton);
	
		
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setUndecorated(true);
		loginFrame.setVisible(true);
		
		yesbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginFrame.dispose();
				new Client();
			}
		});
		
		
		exitbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
	}

	
	
	
	
	
	
	

}

class MyDrawPanel1 extends JPanel{
		public void paintComponent(Graphics g){
			Image image=new ImageIcon("picture/login22.png").getImage();
			g.drawImage(image,-7,0,this);
	}
	}

