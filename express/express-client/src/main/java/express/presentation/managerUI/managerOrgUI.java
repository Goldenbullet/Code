package express.presentation.managerUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import express.presentation.mainUI.MainUIService;
import express.vo.OrganizationVO;

public class managerOrgUI extends JPanel{

	private MainUIService m;
	private JButton ok,exit;
	private JTextField nametf,addresstf,city1tf,city2tf,distancetf,pricetf;
	private String name,address,city1,city2,distance,price;
	private OrganizationVO orginfo;
	
	public managerOrgUI(MainUIService main){
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
		
		int leftside1 = 170;
		int leftside2 = 270;
		Font font = new Font("楷体",Font.PLAIN,18);
		Font font0 = new Font("楷体",Font.BOLD,20);
		Font f = new Font("仿宋",Font.PLAIN,16);
		
		JLabel namel = new JLabel("机构名称");
		namel.setBounds(leftside1, 90, 100, 50);
		namel.setFont(font);
		this.add(namel);
		
		nametf = new JTextField();
//		nametf.setText("机构名称");
		nametf.setBounds(leftside2, 100, 200, 40);
		nametf.setFont(f);
		this.add(nametf);
		
		JLabel addressl = new JLabel("机构地址");
		addressl.setFont(font);
		addressl.setBounds(leftside1, 160, 100, 50);
		this.add(addressl);
		
		addresstf = new JTextField();
//		addresstf.setText("机构地址");
		addresstf.setBounds(leftside2, 170, 200, 40);
		addresstf.setFont(f);
		this.add(addresstf);
		
		JLabel cityl = new JLabel("城市距离");
		cityl.setFont(font0);
		cityl.setBounds(leftside1, 235, 100, 50);
		this.add(cityl);
		
		JLabel city1l = new JLabel("城市1");
		city1l.setFont(font);
		city1l.setBounds(leftside1, 300, 100, 50);
		this.add(city1l);
		
		city1tf = new JTextField();
//		city1tf.setText("城市1");
		city1tf.setBounds(leftside2, 310, 100, 40);
		city1tf.setFont(f);
		this.add(city1tf);
		
		JLabel city2l = new JLabel("城市2");
		city2l.setFont(font);
		city2l.setBounds(430, 300, 100, 50);
		this.add(city2l);
		
		city2tf = new JTextField();
//		city2tf.setText("城市2");
		city2tf.setBounds(530, 310, 100, 40);
		city2tf.setFont(f);
		this.add(city2tf);
		
		JLabel distancel = new JLabel("距离");
		distancel.setFont(font);
		distancel.setBounds(leftside1, 370, 100, 50);
		this.add(distancel);
		
		distancetf = new JTextField();
//		distancetf.setText("城市距离");
		distancetf.setBounds(leftside2, 380, 100, 40);
		distancetf.setFont(f);
		this.add(distancetf);
		
		JLabel pricel = new JLabel("价格");
		pricel.setFont(font);
		pricel.setBounds(leftside1, 440, 100, 50);
		this.add(pricel);
		
		pricetf = new JTextField();
//		pricetf.setText("价格");
		pricetf.setBounds(leftside2, 450, 100, 40);
		pricetf.setFont(f);
		this.add(pricetf);
		
		ok = new JButton("确认");
		ok.setBounds(leftside1, 530, 110, 40);
		this.add(ok);	
		
		exit = new JButton("取消");
		exit.setBounds(400, 530, 110, 40);
		this.add(exit);
		
		nametf.addFocusListener(new Foclistener());
		addresstf.addFocusListener(new Foclistener());
		city1tf.addFocusListener(new Foclistener());
		city2tf.addFocusListener(new Foclistener());
		distancetf.addFocusListener(new Foclistener());
		pricetf.addFocusListener(new Foclistener());
		
		ok.addMouseListener(new Listener());
		exit.addMouseListener(new Listener());
		this.addMouseListener(new Listener());
	}
	
	private class Listener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			requestFocus();
			if(e.getSource()==exit){
				m.jumpTomanagerMenuUI();			
			}else if(e.getSource()==ok){
				name = nametf.getText();
				address = addresstf.getText();
				city1 =city1tf.getText();
				city2 = city2tf.getText();
				distance = distancetf.getText();
				price = pricetf.getText();
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
	
	private class Foclistener implements FocusListener{

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == nametf&&nametf.getText().equals("机构名称")){
				nametf.setText("");
			}else if(e.getSource() == addresstf&&addresstf.getText().equals("机构地址")){
				addresstf.setText("");
			}else if(e.getSource() == city1tf&&city1tf.getText().equals("城市1")){
				city1tf.setText("");
			}else if(e.getSource() == city2tf&&city2tf.getText().equals("城市2")){
				city2tf.setText("");
			}else if(e.getSource() == distancetf&&distancetf.getText().equals("距离")){
				distancetf.setText("");
			}else if(e.getSource() == pricetf&&pricetf.getText().equals("距离")){
				pricetf.setText("");
			}
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == nametf&&nametf.getText().isEmpty()){
				nametf.setText("机构名称");
			}else if(e.getSource() == addresstf&&addresstf.getText().isEmpty()){
				addresstf.setText("机构地址");
			}else if(e.getSource() == city1tf&&city1tf.getText().isEmpty()){
				city1tf.setText("城市1");
			}else if(e.getSource() == city2tf&&city2tf.getText().isEmpty()){
				city2tf.setText("城市2");
			}else if(e.getSource() == distancetf&&distancetf.getText().isEmpty()){
				distancetf.setText("距离");
			}else if(e.getSource() == pricetf&&pricetf.getText().isEmpty()){
				pricetf.setText("价格");
			}
		}		
	}
}
