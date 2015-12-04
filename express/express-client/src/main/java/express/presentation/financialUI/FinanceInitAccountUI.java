package express.presentation.financialUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import express.presentation.mainUI.MainUIService;

public class FinanceInitAccountUI extends JPanel{

	private MainUIService m;
	private JPanel staff,org,vehicle,repo,bankaccount,showprevious;
	private JTabbedPane tabpane;
	private JButton ok,exit;
	
	public FinanceInitAccountUI(MainUIService main){
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
		
//		int leftside1 = 200;
		int leftside = 300;
		int base = 80;
		int bwidth = 200;
		int bheight = 40;
		Font font = new Font("楷体",Font.PLAIN,20);
//		Font f = new Font("仿宋",Font.PLAIN,16);
		
		staff = new JPanel();
		org = new JPanel();
		vehicle = new JPanel();
		repo = new JPanel();
		bankaccount = new JPanel();
		showprevious = new JPanel();
		
		tabpane = new JTabbedPane();
		tabpane.add("人员信息",staff);
		tabpane.add("机构信息",org);
		tabpane.add("车辆信息",vehicle);
		tabpane.add("库存信息",repo);
		tabpane.add("银行账户信息",bankaccount);
		tabpane.add("查看之前期初信息",showprevious);
		tabpane.setFont(font);
		tabpane.setBounds(20, 30, 780, 550);
		this.add(tabpane);
//		staff.setBounds(leftside, base, bwidth, bheight);
//		staff.setFont(font);
//		this.add(staff);
//		动态表格
//		姓名，性别，手机号，入职日期，职位（可选择），所在机构（可选择），工号（选择机构后自动显示一半），
		
//		org.setBounds(leftside, base+2*bheight, bwidth, bheight);
//		org.setFont(font);
//		this.add(org);
//		所属城市，机构全称，性质（选择营业厅、中转中心），机构代号
		
//		vehicle.setBounds(leftside, base+4*bheight, bwidth, bheight);
//		vehicle.setFont(font);
//		this.add(vehicle);
//		车牌号，车辆所属机构，车辆代号，服役时间
		
//		repo.setBounds(leftside, base+6*bheight, bwidth, bheight);
//		repo.setFont(font);
//		this.add(repo);
//		仓库地址，仓库（航运区、铁运区、汽运区、机动区）排数
		
//		bankaccount.setBounds(leftside, base+8*bheight, bwidth, bheight);
//		bankaccount.setFont(font);
//		this.add(bankaccount);
//		账户名，收入金额，支出金额，余额（自动生成）
    	
//		showprevious.setBounds(leftside, base+10*bheight, bwidth, bheight);
//		showprevious.setFont(font);
//		this.add(showprevious);
    	
		ok = new JButton("确认");
		ok.setBounds(240, 600, 110, 30);
		this.add(ok);
		
		exit = new JButton("取消");
		exit.setBounds(440, 600, 110, 30);
		this.add(exit);
		
		Listener listener = new Listener();
		staff.addMouseListener(listener);
		org.addMouseListener(listener);
		vehicle.addMouseListener(listener);
		repo.addMouseListener(listener);
		bankaccount.addMouseListener(listener);
		showprevious.addMouseListener(listener);
		ok.addMouseListener(listener);
		exit.addMouseListener(listener);
	}
	
	private class Listener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==exit){
				m.jumpToFinanceMenuUI();
			}else if(e.getSource()==ok){		
				
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
