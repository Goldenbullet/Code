package express.presentation.userUI;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import express.presentation.mainUI.MainUI;
import express.presentation.mainUI.MainUIService;
import express.presentation.managerUI.managerMenuUI;

public class SignInUI extends JPanel{
	
	private MainUIService m;
	private JButton manager_login;
	private JButton repo_login;
	private JButton admin_login;
	private JButton deliver_login; 
	private JButton transsale_login; 
	private JButton businesssale_login; 
	private JButton finance_login; 
	
	public SignInUI(MainUIService main){
		setLayout(null);
		this.setBounds(0, 0, 1000, 700);
		m = main;
		
		JListener listener=new JListener();
		
		
		manager_login = new JButton(" manager log in");
		manager_login.setBounds(100, 100, 150, 50);
		manager_login.addMouseListener(listener);
		this.add(manager_login);
		
		finance_login = new JButton(" finance log in");
		finance_login.setBounds(400, 100, 150, 50);
		finance_login.addMouseListener(listener);
		this.add(finance_login);
		
		repo_login=new JButton("repo log in");
		repo_login.setBounds(100,200,150,50);
		repo_login.addMouseListener(listener);
		this.add(repo_login);
		
		admin_login=new JButton("admin log in");
		admin_login.setBounds(100,300,150,50);
		admin_login.addMouseListener(listener);
		this.add(admin_login);
		
		deliver_login=new JButton("deliver log in");
		deliver_login.setBounds(100, 400, 150, 50);
		deliver_login.addMouseListener(listener);
		this.add(deliver_login);
		
		
		transsale_login=new JButton("transsale log in");
		transsale_login.setBounds(100, 500, 150, 50);
		transsale_login.addMouseListener(listener);
		this.add(transsale_login);
		
		businesssale_login=new JButton("businesssale log in");
		businesssale_login.setBounds(100, 600, 150, 50);
		businesssale_login.addMouseListener(listener);
		this.add(businesssale_login);
		
		
	}
	class JListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			 if (e.getSource()==manager_login){
				 m.jumpTomanagerMenuUI();
				 System.out.println("总经理登录");
			 }
			 
			 else if (e.getSource()==repo_login){
				 m.jumpTotranscenterRepoMenuUI();
				 System.out.println("仓库管理员登录");
			 }
			 else if (e.getSource()==admin_login){
				 m.jumpToadminStartUI();
				 System.out.println("管理员登录");
				 
			 }
			 else if (e.getSource()==deliver_login){
				 m.jumpTodeliverMenuUI();
				 System.out.println("快递员登录");
				 
			 }
			 else if (e.getSource()==transsale_login){
				 m.jumpTotransSaleMenuUI();
				 System.out.println("中转中心业务员登录");
				 
			 }
			 else if (e.getSource()==businesssale_login){
				 m.jumpTobusinessMenuUI();
				 System.out.println("营业厅业务员登录"); 
			 } else if (e.getSource()==finance_login){
				 m.jumpToFinanceMenuUI();
				 System.out.println("财务人员登录"); 
			 }
			 updateUI();
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	 
}
