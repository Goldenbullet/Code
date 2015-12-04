package express.presentation.transSaleUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import express.presentation.mainUI.MainUIService;

public class transSaleTransferDocUI extends JPanel{
	private MainUIService m;
	private JButton button_confirm,button_cancel;
	private JTextField textArea1,textArea2,textArea3,textArea4,textArea5,textArea6,textArea8;
	private JTextArea textArea7;	
	private String transcenterNumber;
	private String flightNumber;
	private String begin;
	private String arrival;
	private String containerNumber;
	private String checkMan;
	private String transferID;
	private double money;
	
	public transSaleTransferDocUI(MainUIService main){

		int base = 80;
		int textlength = 200;
		int textwidth = 40;

		int labellength = 100;
		int labelwidth = 30;
		
		Font font = new Font("楷体",Font.PLAIN,18);
		Font f = new Font("仿宋",Font.PLAIN,16);
		
        setLayout(null);
		this.m=main;
		
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
		
		textArea1 = new JTextField("本中转中心汽运编号");
		textArea1.setBounds(300, base, textlength, textwidth);//字太长了，所以放宽了50
		textArea1.setFont(f);
//		textArea1.setBackground(Color.BLUE);
//		// textAreaOutput.setSelectedTextColor(Color.RED);
//		textArea1.setLineWrap(true); // 激活自动换行功能
//		textArea1.setWrapStyleWord(true);// 激活断行不断字功能	
		this.add(textArea1);

		textArea2 = new JTextField("航班号");
		textArea2.setBounds(300, base + labelwidth * 2, textlength, textwidth);
		textArea2.setFont(f);
//		textArea2.setBackground(Color.BLUE);
//		textArea2.setLineWrap(true);
//		textArea2.setWrapStyleWord(true);		
		this.add(textArea2);

		textArea3 = new JTextField("出发地");
		textArea3.setBounds(300, base + labelwidth * 4, textlength, textwidth);
		textArea3.setFont(f);
//		textArea3.setBackground(Color.BLUE);
//		textArea3.setLineWrap(true);
//		textArea3.setWrapStyleWord(true);		
		this.add(textArea3);

		textArea4 = new JTextField("到达地");
		textArea4.setBounds(300, base + labelwidth * 6, textlength, textwidth);
		textArea4.setFont(f);
//		textArea4.setBackground(Color.BLUE);
//		textArea4.setLineWrap(true);
//		textArea4.setWrapStyleWord(true);		
		this.add(textArea4);

		textArea5 = new JTextField("货柜号");
		textArea5.setBounds(300, base + labelwidth * 8, textlength, textwidth);
		textArea5.setFont(f);
//		textArea5.setBackground(Color.BLUE);
//		textArea5.setLineWrap(true);
//		textArea5.setWrapStyleWord(true);		
		this.add(textArea5);

		textArea6 = new JTextField("监装员");
		textArea6.setBounds(300, base + labelwidth * 10, textlength, textwidth);
		textArea6.setFont(f);
//		textArea6.setBackground(Color.BLUE);
//		textArea6.setLineWrap(true);
//		textArea6.setWrapStyleWord(true);	
		this.add(textArea6);

		textArea7 = new JTextArea("本次装箱所有订单条形号码");
		textArea7.setBounds(300, base + labelwidth * 12, textlength+50, textwidth*2);//字太长了，所以放宽了70
		textArea7.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		textArea7.setFont(f);
//		textArea7.setBackground(Color.BLUE);
		textArea7.setLineWrap(true);
		textArea7.setWrapStyleWord(true);		
		this.add(textArea7);
		
		textArea8 = new JTextField("运费");
		textArea8.setBounds(300, base + labelwidth * 15, textlength, textwidth);
		textArea8.setFont(f);
//		textArea8.setBackground(Color.BLUE);
//		textArea8.setLineWrap(true);
//		textArea8.setWrapStyleWord(true);
		this.add(textArea8);

		JLabel label1 = new JLabel("本中转中心汽运编号");
		label1.setBounds(200-100, base+5, labellength+100, labelwidth);
		label1.setFont(font);
		this.add(label1);

		JLabel label2 = new JLabel("航班号");
		label2.setBounds(200, base+5 + labelwidth * 2, labellength, labelwidth);
		label2.setFont(font);
		this.add(label2);

		JLabel label3 = new JLabel("出发地");
		label3.setBounds(200, base+5 + labelwidth * 4, labellength, labelwidth);
		label3.setFont(font);
		this.add(label3);

		JLabel label4 = new JLabel("到达地");
		label4.setBounds(200, base+5 + labelwidth * 6, labellength, labelwidth);
		label4.setFont(font);
		this.add(label4);

		JLabel label5 = new JLabel("货柜号");
		label5.setBounds(200, base+5 + labelwidth * 8, labellength, labelwidth);
		label5.setFont(font);
		this.add(label5);

		JLabel label6 = new JLabel("监装员");
		label6.setBounds(200, base+5 + labelwidth * 10, labellength+100, labelwidth);
		label6.setFont(font);
		this.add(label6);

		JLabel label7 = new JLabel("本次装箱所有订单条形号码");
		label7.setBounds(200-130, base+5 + labelwidth * 12, labellength+170, labelwidth);
		label7.setFont(font);
		this.add(label7);
		
		
		JLabel label8 = new JLabel("运费");
		label8.setBounds(200, base+5 + labelwidth * 15, labellength, labelwidth);
		label8.setFont(font);
		this.add(label8);
		
		JListener listener = new JListener();
		
		button_confirm=new JButton("确定");
		button_confirm.setBounds(250, 600, 60, 30);
		button_confirm.addMouseListener(listener);
		this.add(button_confirm);
				
		button_cancel=new JButton("取消");
		button_cancel.setBounds(380, 600, 60, 30);
		button_cancel.addMouseListener(listener);
		this.add(button_cancel);
		
//		button_return=new JButton("中转单 退出");
//		button_return.setBounds(100, 100, 150, 50);
//		this.add(button_return);
    }

	private class JListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource()==button_confirm){
				transcenterNumber = textArea1.getText();
				flightNumber = textArea2.getText();
				begin = textArea3.getText();
				arrival = textArea4.getText();
				containerNumber = textArea5.getText();
				checkMan = textArea6.getText();
				transferID = textArea7.getText();
				money = Double.parseDouble(textArea8.getText());
			}else if (e.getSource()==button_cancel){
				textArea1.setText("");
				textArea2.setText("");
				textArea3.setText("");
				textArea4.setText("");
				textArea5.setText("");
				textArea6.setText("");
				textArea7.setText("");
				textArea8.setText("");
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
