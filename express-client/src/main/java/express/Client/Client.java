package express.Client;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import express.presentation.mainUI.MainUI;
import express.presentation.mainUI.MainUIService;
import express.presentation.userUI.SignInUI;
import express.rmi.ClientException;
import express.rmi.RMIClient;


public class Client extends JFrame{
	private SignInUI signin;
	private CardLayout card;
	private JPanel container;
	private MainUIService main;
	
	public Client(){

		this.setLayout(null);
		container = new JPanel();
		container.setBounds(0,0,1000,700);
//		this.setContentPane(container);
		card= new CardLayout();		
		container.setLayout(card);
		
		main = new MainUI(card,container);
		signin = new SignInUI(main);
		this.add(container);
		container.add("signin", signin);
		card.show(container, "signin");
	
//		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setUndecorated(true);
//		this.setLocation(screenSize.width/2-1200/2,screenSize.height/2-900/2);
		this.setSize(1000,700);
		 this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		try {
	        RMIClient.init();
	        new Client();
	    } catch (ClientException e) {
	        e.printStackTrace(); 
	    }
	}
}
