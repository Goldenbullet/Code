package express.presentation.transSaleUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import express.presentation.mainUI.MainUIService;

public class transSaleShipmentDocUI extends JPanel{
	private JButton button_confirm,button_cancel;
	private MainUIService m;
	
	private JTextField textArea1,textArea2,textArea3,textArea4,textArea5,textArea7;
	private JTextArea textArea6;
	private String transcenterNumber;
	private String arrival;
	private String vin;
	private String checkMan;
	private String transMan;
	private String shipmentID;
	private ArrayList<String> orderID;
	private double money;
	
	public transSaleShipmentDocUI(MainUIService main){
		
		int textlength = 200;
		int textwidth = 40;

		int labellength = 150;
		int labelwidth = 30;
	
		Font font = new Font("楷体",Font.PLAIN,18);
		Font f = new Font("仿宋",Font.PLAIN,16);
		
        setLayout(null);
		this.m=main;
		
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);	
		
		textArea1 = new JTextField("本中转中心汽运编号");
		textArea1.setBounds(360, 100, textlength, textwidth);
		textArea1.setFont(f);
	//	textArea1.setBackground(Color.BLUE);
		// textAreaOutput.setSelectedTextColor(Color.RED);
//		textArea1.setLineWrap(true); // 激活自动换行功能
//		textArea1.setWrapStyleWord(true);// 激活断行不断字功能	
		this.add(textArea1);

		textArea2 = new JTextField("到达地");
		textArea2.setBounds(360, 100 + labelwidth * 2, textlength, textwidth);
		textArea2.setFont(f);
//		textArea2.setBackground(Color.BLUE);
//		textArea2.setLineWrap(true);
//		textArea2.setWrapStyleWord(true);		
		this.add(textArea2);

		textArea3 = new JTextField("车辆代号");
		textArea3.setBounds(360, 100 + labelwidth * 4, textlength, textwidth);
		textArea3.setFont(f);
//		textArea3.setBackground(Color.BLUE);
//		textArea3.setLineWrap(true);
//		textArea3.setWrapStyleWord(true);		
		this.add(textArea3);

		textArea4 = new JTextField("监装员");
		textArea4.setBounds(360, 100 + labelwidth * 6, textlength, textwidth);
		textArea4.setFont(f);
//		textArea4.setBackground(Color.BLUE);
//		textArea4.setLineWrap(true);
//		textArea4.setWrapStyleWord(true);		
		this.add(textArea4);

		textArea5 = new JTextField("押运员");
		textArea5.setBounds(360, 100 + labelwidth * 8, textlength, textwidth);
		textArea5.setFont(f);
//		textArea5.setBackground(Color.BLUE);
//		textArea5.setLineWrap(true);
//		textArea5.setWrapStyleWord(true);		
		this.add(textArea5);

		textArea6 = new JTextArea("本次装箱所有订单条形号码");
		textArea6.setBounds(360, 100 + labelwidth * 10, textlength, textwidth*2);
		textArea6.setFont(f);
		textArea6.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		textArea6.setLineWrap(true);
		textArea6.setWrapStyleWord(true);	
		this.add(textArea6);

		textArea7 = new JTextField("运费");
		textArea7.setBounds(360, 100 + labelwidth * 13, textlength, textwidth);
		textArea7.setFont(f);
//		textArea7.setBackground(Color.BLUE);
//		textArea7.setLineWrap(true);
//		textArea7.setWrapStyleWord(true);
		this.add(textArea7);
		
		

		JLabel label1 = new JLabel("本中转中心汽运编号");
		label1.setBounds(200-50, 105, labellength+50, labelwidth);
		label1.setFont(font);
		this.add(label1);

		JLabel label2 = new JLabel("到达地");
		label2.setBounds(200, 105 + labelwidth * 2, labellength, labelwidth);
		label2.setFont(font);
		this.add(label2);

		JLabel label3 = new JLabel("车辆代号");
		label3.setBounds(200, 105 + labelwidth * 4, labellength, labelwidth);
		label3.setFont(font);
		this.add(label3);

		JLabel label4 = new JLabel("监装员");
		label4.setBounds(200, 105 + labelwidth * 6, labellength, labelwidth);
		label4.setFont(font);
		this.add(label4);

		JLabel label5 = new JLabel("押运员");
		label5.setBounds(200, 105 + labelwidth * 8, labellength, labelwidth);
		label5.setFont(font);
		this.add(label5);

		JLabel label6 = new JLabel("本次装箱所有订单条形号码");
		label6.setBounds(200-70, 105 + labelwidth * 10, labellength+100, labelwidth);
		label6.setFont(font);
		this.add(label6);

		JLabel label7 = new JLabel("运费");
		label7.setBounds(200, 105 + labelwidth * 13, labellength, labelwidth);
		label7.setFont(font);
		this.add(label7);
		
		JListener listener = new JListener();
		
		button_confirm=new JButton("确定");
		button_confirm.setBounds(280, 560, 60, 30);
		button_confirm.addMouseListener(listener);
		this.add(button_confirm);
				
		button_cancel=new JButton("取消");
		button_cancel.setBounds(380, 560, 60, 30);
		button_cancel.addMouseListener(listener);
		this.add(button_cancel);
//		button_return=new JButton("装车单 退出");
//		button_return.setBounds(100, 100, 150, 50);
//		this.add(button_return);
    }
	
	private class JListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource()==button_confirm){
				transcenterNumber = textArea1.getText();
				arrival = textArea2.getText();
				vin = textArea3.getText();
				checkMan = textArea4.getText();
				transMan = textArea5.getText();
				shipmentID = textArea6.getText();
				money = Double.parseDouble(textArea7.getText());
			}else if (e.getSource()==button_cancel){
				textArea1.setText("");
				textArea2.setText("");
				textArea3.setText("");
				textArea4.setText("");
				textArea5.setText("");
				textArea6.setText("");
				textArea7.setText("");
			}
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
