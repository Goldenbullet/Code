package express.presentation.deliverUI;

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

import express.po.DeliveryType;
import express.presentation.mainUI.MainUIService;

public class deliverOrderUI extends JPanel{
	
	private MainUIService m;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_8;
	private JTextField textField_6;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	
	private JButton button_cancel,button_confirm;
	private String sendername,senderaddress,senderworkplace,sendertelpnum,sendermobilepnm;
	private String recipientname,recipientaddress,recipientworkplace,recipienttelpnum,recipientmobilepnm;
	private int count;
	private double weight,volume;
	private String nameOfGoods,orderID;
	private DeliveryType type;
	
	public deliverOrderUI(MainUIService main){
		setLayout(null);
		this.m=main;
		
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
		
		Font font = new Font("楷体",Font.PLAIN,18);
		Font font0 = new Font("楷体",Font.BOLD,20);
		Font f = new Font("仿宋",Font.PLAIN,14);
		
		JLabel label = new JLabel("寄件人信息：");
		label.setBounds(5, 10, 150, 30);
		label.setFont(font0);
		this.add(label);
		
		JLabel label_1 = new JLabel("寄件人姓名");
		label_1.setBounds(20, 55, 100, 30);
		label_1.setFont(font);
		this.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(120, 55, 100, 30);
		textField.setFont(f);
		this.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("住址");
		label_2.setBounds(300, 55, 100, 30);
		label_2.setFont(font);
		this.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(375, 56, 150, 30);
		textField_1.setFont(f);
		this.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("单位");
		lblNewLabel.setBounds(20, 110, 100, 30);
		lblNewLabel.setFont(font);
		this.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 115, 150, 30);
		textField_2.setFont(f);
		this.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("电话");
		label_3.setBounds(300, 110, 100, 30);
		label_3.setFont(font);
		this.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(375, 115, 150, 30);
		textField_3.setFont(f);
		this.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("手机号");
		lblNewLabel_1.setBounds(550, 115, 100, 30);
		lblNewLabel_1.setFont(font);
		this.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(610, 111, 150, 30);
		textField_4.setFont(f);
		this.add(textField_4);
		
		
		JLabel label_4 = new JLabel("收件人信息：");
		label_4.setBounds(5, 160, 160, 30);
		label_4.setFont(font0);
		this.add(label_4);
		
		JLabel label_5 = new JLabel("收件人姓名");
		label_5.setBounds(20, 205, 100, 30);
		label_5.setFont(font);
		this.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(120, 205, 100, 30);
		textField_5.setFont(f);
		this.add(textField_5);
		
		JLabel label_6 = new JLabel("住址");
		label_6.setBounds(300, 205, 100, 30);
		label_6.setFont(font);
		this.add(label_6);
		
		JLabel label_7 = new JLabel("单位");
		label_7.setBounds(20, 255, 100, 30);
		label_7.setFont(font);
		this.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(100, 255, 150, 30);
		textField_7.setFont(f);
		this.add(textField_7);
		
		JLabel label_8 = new JLabel("电话");
		label_8.setBounds(300, 255, 100, 30);
		label_8.setFont(font);
		this.add(label_8);
		
		JLabel label_9 = new JLabel("手机号");
		label_9.setBounds(550, 255, 100, 30);
		label_9.setFont(font);
		this.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(610, 255, 150, 30);
		textField_9.setFont(f);
		this.add(textField_9);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(375, 255, 150, 30);
		textField_8.setFont(f);
		this.add(textField_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(375, 205, 150, 30);
		textField_6.setFont(f);
		this.add(textField_6);
		
		JLabel lblNewLabel_2 = new JLabel("托运货物信息：");
		lblNewLabel_2.setBounds(5, 330, 160, 30);
		lblNewLabel_2.setFont(font0);
		this.add(lblNewLabel_2);
		
		JLabel label_10 = new JLabel("原件数");
		label_10.setBounds(20, 375, 100, 30);
		label_10.setFont(font);
		this.add(label_10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(100, 375, 70, 30);
		textField_10.setFont(f);
		this.add(textField_10);
		
		JLabel label_11 = new JLabel("实际重量");
		label_11.setBounds(224, 375, 100, 30);
		label_11.setFont(font);
		this.add(label_11);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(300, 375, 70, 30);
		textField_11.setFont(f);
		this.add(textField_11);
		
		JLabel label_12 = new JLabel("体积");
		label_12.setBounds(425, 375, 100, 30);
		label_12.setFont(font);
		this.add(label_12);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(497, 375, 70, 30);
		textField_12.setFont(f);
		this.add(textField_12);
		
		JLabel label_13 = new JLabel("内件品名");
		label_13.setBounds(612, 375, 100, 30);
		label_13.setFont(font);
		this.add(label_13);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(684, 375, 150, 30);
		textField_13.setFont(f);
		this.add(textField_13);
		
		JLabel label_14 = new JLabel("快递种类");
		label_14.setBounds(5, 440, 100, 30);
		label_14.setFont(font);
		this.add(label_14);
		
		ButtonGroup bg1 = new ButtonGroup();
		
		JRadioButton radioButton = new JRadioButton("经济快递");
		radioButton.setBounds(100, 440, 100, 30);
		radioButton.setFont(font);
		bg1.add(radioButton);
		this.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("标准快递");
		radioButton_1.setBounds(270, 440, 100, 30);
		radioButton_1.setFont(font);
		bg1.add(radioButton_1);
		this.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("特快快递");
		radioButton_2.setBounds(440, 440, 100, 30);
		radioButton_2.setFont(font);
		bg1.add(radioButton_2);
		this.add(radioButton_2);
	
		JLabel label_15 = new JLabel("包装类型");
		label_15.setBounds(5, 500, 100, 30);
		label_15.setFont(font);
		this.add(label_15);
		
		ButtonGroup bg2 = new ButtonGroup();
		
		JRadioButton radioButton_3 = new JRadioButton("纸箱");
		radioButton_3.setBounds(100, 500, 100, 30);
		radioButton_3.setFont(font);
		bg2.add(radioButton_3);
		this.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("木箱");
		radioButton_4.setBounds(270, 500, 100, 30);
		radioButton_4.setFont(font);
		bg2.add(radioButton_4);
		this.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("快递袋");
		radioButton_5.setBounds(440, 500, 100, 30);
		radioButton_5.setFont(font);
		bg2.add(radioButton_5);
		this.add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("其它");
		radioButton_6.setBounds(610, 500, 100, 30);
		radioButton_6.setFont(font);
		bg2.add(radioButton_6);
		this.add(radioButton_6);
		
		JLabel label_16 = new JLabel("订单条形码");
		label_16.setBounds(5, 566, 100, 30);
		label_16.setFont(font);
		this.add(label_16);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(100, 566, 150, 30);
		textField_14.setFont(f);
		this.add(textField_14);
		
		JLabel label_17 = new JLabel("费用合计");
		label_17.setBounds(300, 566, 100, 30);
		label_17.setFont(font);
		this.add(label_17);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(375, 566, 100, 30);
		textField_15.setFont(f);
		this.add(textField_15);
		
		Listener lis = new Listener();
		
		button_confirm=new JButton("确定");
		button_confirm.setBounds(250, 615, 100, 30);
		button_confirm.setFont(font);
		button_confirm.addMouseListener(lis);
		this.add(button_confirm);
				
		button_cancel=new JButton("取消");
		button_cancel.setBounds(380, 615, 100, 30);
		button_cancel.setFont(font);
		button_cancel.addMouseListener(lis);
		this.add(button_cancel);		
	}
	
	private class Listener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==button_cancel){
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
			}else if(e.getSource()==button_confirm){
				sendername = textField.getText();
				senderaddress = textField_1.getText();
				senderworkplace = textField_2.getText();
				sendertelpnum = textField_3.getText();
				sendermobilepnm = textField_4.getText();
				recipientname = textField_5.getText();
				recipientaddress = textField_6.getText();
				recipientworkplace = textField_7.getText();
				recipienttelpnum = textField_8.getText();
				recipientmobilepnm = textField_9.getText();
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

