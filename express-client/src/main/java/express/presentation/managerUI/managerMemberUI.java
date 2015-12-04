package express.presentation.managerUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import express.presentation.mainUI.MainUIService;
import express.vo.UserInfoVO;

public class managerMemberUI extends JPanel{

	private MainUIService m;
	private JButton ok,exit;
	private JRadioButton male,female;
	private JTextField nametf,idtf,citytf,positiontf,phonetf,datetf;
	private String name,id,city,position,phone,date;
	private boolean sex;
	private UserInfoVO userinfo;
	
	public managerMemberUI(MainUIService main){
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
		
		int leftside1 = 200;
		int leftside2 = 300;
		Font font = new Font("楷体",Font.PLAIN,18);
		Font f = new Font("仿宋",Font.PLAIN,16);
		
		JLabel namel = new JLabel("姓名");
		namel.setFont(font);
		namel.setBounds(leftside1, 90, 100, 50);
		this.add(namel);
		
		nametf = new JTextField();
//		nametf.setText("姓名");
		nametf.setBounds(leftside2, 100, 100, 40);
		nametf.setFont(f);
		this.add(nametf);
		
		JLabel genderl = new JLabel("性别");
		genderl.setFont(font);
		genderl.setBounds(leftside1, 150, 100, 50);
		this.add(genderl);
		
		ButtonGroup gender = new ButtonGroup();
		male = new JRadioButton("男");
		male.setBounds(leftside2, 150, 50, 40);
		male.setFont(font);
		female = new JRadioButton("女");
		female.setBounds(leftside2, 190, 50, 40);
		female.setFont(font);
		gender.add(male);
		gender.add(female);
		this.add(male);
		this.add(female);
		
		JLabel idl = new JLabel("工号");
		idl.setBounds(leftside1, 240, 100, 50);
		idl.setFont(font);
		this.add(idl);
		
		idtf = new JTextField();
//		idtf.setText("工号");
		idtf.setBounds(leftside2, 250, 160, 40);
		idtf.setFont(f);
		this.add(idtf);
		
		JLabel positionl = new JLabel("职位");
		positionl.setBounds(leftside1, 300, 100, 50);
		positionl.setFont(font);
		this.add(positionl);
		
		positiontf = new JTextField();
//		positiontf.setText("职位");
		positiontf.setBounds(leftside2, 310, 100, 40);
		positiontf.setFont(f);
		this.add(positiontf);
		
		JLabel cityl = new JLabel("所在城市");
		cityl.setBounds(leftside1, 360, 100, 50);
		cityl.setFont(font);
		this.add(cityl);
		
		citytf = new JTextField();
//		phonetf.setText("所在城市");
		citytf.setBounds(leftside2, 370, 100, 40);
		citytf.setFont(f);
		this.add(citytf);
		
		JLabel phonel = new JLabel("联系方式");
		phonel.setBounds(leftside1, 420, 100, 50);
		phonel.setFont(font);
		this.add(phonel);
		
		phonetf = new JTextField();
//		phonetf.setText("联系方式");
		phonetf.setBounds(leftside2, 430, 160, 40);
		phonetf.setFont(f);
		this.add(phonetf);
		
		JLabel datel = new JLabel("入职日期");
		datel.setBounds(leftside1, 480, 100, 50);
		datel.setFont(font);
		this.add(datel);
		
		datetf = new JTextField();
//		phonetf.setText("入职日期");
		datetf.setBounds(leftside2, 490, 160, 40);
		datetf.setFont(f);
		this.add(datetf);
		
		
		ok = new JButton("确认");
		ok.setBounds(220, 580, 110, 40);
		this.add(ok);
		
		exit = new JButton("取消");
		exit.setBounds(420, 580, 110, 40);
		this.add(exit);
		
		ok.addMouseListener(new Listener());
		exit.addMouseListener(new Listener());
	}
	
	private class Listener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==exit){
//				m.jumpTomanagerMenuUI();
				nametf.setText("");
				idtf.setText("");
				positiontf.setText("");
				citytf.setText("");
				phonetf.setText("");
				datetf.setText("");
			}else if(e.getSource()==ok){
				name = nametf.getText();
				id = idtf.getText();
				position = positiontf.getText();
				city = citytf.getText();
				phone = phonetf.getText();
				date = datetf.getText();
				if(male.isSelected())
					sex = true;
				else if(female.isSelected())
					sex = false;			
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
