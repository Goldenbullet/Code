package express.presentation.transSaleUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import express.businessLogic.IDKeeper;
import express.businesslogicService.transcenterSaleBLService.TransCenterTransferDocblService;
import express.businessLogic.documentBL.TransferDoc;
import express.po.TransWay;
import express.presentation.mainUI.DateChooser;
import express.presentation.mainUI.MainUIService;
import express.vo.TransferDocVO;

public class transSaleTransferDocUI extends JPanel {
	private MainUIService m;
	private JButton button_confirm, button_cancel;
	private JTextField textArea1, textArea2, textArea3, textArea4, textArea5,
			textArea6, textArea8, textArea9;
	private JTextArea textArea7;
	private JLabel label2;
	private DateChooser datechooser;
	private JComboBox tranway;
	private String transmode, date, transcenterNumber, flightNumber, begin,
			arrival, containerNumber, checkMan;
	private TransWay transWay;
	private ArrayList<String> orderlist;
	private double money;

	public transSaleTransferDocUI(MainUIService main) {

		int base = 40;
		int textlength = 200;
		int textwidth = 40;

		int labellength = 100;
		int labelwidth = 30;

		Font font = new Font("楷体", Font.PLAIN, 18);
		Font f = new Font("仿宋", Font.PLAIN, 16);

		setLayout(null);
		this.m = main;

		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);

		JListener listener = new JListener();
		FocListener foclis = new FocListener();

		transcenterNumber = IDKeeper.getOrgID();
		textArea1 = new JTextField("本中转中心编号");
		textArea1.setBounds(300, base, textlength, textwidth);// 字太长了，所以放宽了50
		textArea1.setFont(f);
		textArea1.setText(transcenterNumber);
		this.add(textArea1);

		textArea9 = new JTextField();
		textArea9.setBounds(300, base + labelwidth * 2, textlength, textwidth);
		textArea9.setFont(f);
		textArea9
				.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		textArea9.setEditable(false);
		this.add(textArea9);

		datechooser = new DateChooser("yyyy-MM-dd", textArea9);
		datechooser.setBounds(510, base + labelwidth * 2 - 5, 40, 40);
		this.add(datechooser);

		String[] tranways = { "汽车", "火车", "飞机" };
		tranway = new JComboBox(tranways);
		tranway.setFont(f);
		tranway.setBounds(300, base + labelwidth * 4, labellength, textwidth);
		tranway.addFocusListener(foclis);
		this.add(tranway);

		textArea2 = new JTextField();
		textArea2.setBounds(520, base + labelwidth * 4, textlength, textwidth);
		textArea2.setFont(f);
		// this.add(textArea2);

		textArea3 = new JTextField("出发地");
		textArea3.setBounds(300, base + labelwidth * 6, textlength, textwidth);
		textArea3.setFont(f);
		this.add(textArea3);

		textArea4 = new JTextField("到达地");
		textArea4.setBounds(300, base + labelwidth * 8, textlength, textwidth);
		textArea4.setFont(f);
		this.add(textArea4);

		textArea5 = new JTextField("货柜号");
		textArea5.setBounds(300, base + labelwidth * 10, textlength, textwidth);
		textArea5.setFont(f);
		this.add(textArea5);

		textArea6 = new JTextField("监装员");
		textArea6.setBounds(300, base + labelwidth * 12, textlength, textwidth);
		textArea6.setFont(f);
		// textArea6.setBackground(Color.BLUE);
		// textArea6.setLineWrap(true);
		// textArea6.setWrapStyleWord(true);
		this.add(textArea6);

		textArea7 = new JTextArea("本次装箱所有订单条形号码");
		textArea7.setBounds(300, base + labelwidth * 14, textlength + 50,
				textwidth * 2);// 字太长了，所以放宽了70
		textArea7.setFont(f);
		textArea7.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		textArea7.setLineWrap(true);
		textArea7.setWrapStyleWord(true);
		this.add(textArea7);

		JScrollPane scrollPane = new JScrollPane(textArea7);
		scrollPane.setFont(font);
		scrollPane.setBounds(300, base + labelwidth * 14, textlength + 50,
				textwidth * 2);
		this.add(scrollPane);

		textArea8 = new JTextField("运费");
		textArea8.setBounds(300, base + labelwidth * 17, textlength, textwidth);
		textArea8.setFont(f);
		textArea8.setEditable(false);
		this.add(textArea8);

		JLabel label1 = new JLabel("本中转中心编号");
		label1.setBounds(200 - 70, base + 5, labellength + 70, labelwidth);
		label1.setFont(font);
		this.add(label1);

		JLabel label9 = new JLabel("装运日期");
		label9.setBounds(200, base + 5 + labelwidth * 2, labellength,
				labelwidth);
		label9.setFont(font);
		this.add(label9);

		JLabel label2_0 = new JLabel("运输方式");
		label2_0.setBounds(200, base + 5 + labelwidth * 4, labellength,
				labelwidth);
		label2_0.setFont(font);
		this.add(label2_0);

		label2 = new JLabel();
		label2.setBounds(440, base + 5 + labelwidth * 4, labellength,
				labelwidth);
		label2.setFont(font);
		// this.add(label2);

		JLabel label3 = new JLabel("出发地");
		label3.setBounds(200, base + 5 + labelwidth * 6, labellength,
				labelwidth);
		label3.setFont(font);
		this.add(label3);

		JLabel label4 = new JLabel("到达地");
		label4.setBounds(200, base + 5 + labelwidth * 8, labellength,
				labelwidth);
		label4.setFont(font);
		this.add(label4);

		JLabel label5 = new JLabel("货柜号");
		label5.setBounds(200, base + 5 + labelwidth * 10, labellength,
				labelwidth);
		label5.setFont(font);
		this.add(label5);

		JLabel label6 = new JLabel("监装员");
		label6.setBounds(200, base + 5 + labelwidth * 12, labellength + 100,
				labelwidth);
		label6.setFont(font);
		this.add(label6);

		JLabel label7 = new JLabel("本次装箱所有订单条形号码");
		label7.setBounds(200 - 130, base + 5 + labelwidth * 14,
				labellength + 170, labelwidth);
		label7.setFont(font);
		this.add(label7);

		JLabel label8 = new JLabel("运费");
		label8.setBounds(200, base + 5 + labelwidth * 17, labellength,
				labelwidth);
		label8.setFont(font);
		this.add(label8);

		button_confirm = new JButton("确定");
		button_confirm.setBounds(230, 610, 80, 30);
		button_confirm.addMouseListener(listener);
		this.add(button_confirm);

		button_cancel = new JButton("取消");
		button_cancel.setBounds(400, 610, 80, 30);
		button_cancel.addMouseListener(listener);
		this.add(button_cancel);

		// button_return=new JButton("中转单 退出");
		// button_return.setBounds(100, 100, 150, 50);
		// this.add(button_return);
	}

	private class JListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == button_confirm) {
				date = textArea9.getText();
				flightNumber = textArea2.getText();
				begin = textArea3.getText();
				arrival = textArea4.getText();
				containerNumber = textArea5.getText();
				checkMan = textArea6.getText();
				transWay = TransWay.values()[tranway.getSelectedIndex()];
				String[] temp = textArea7.getText().split("\n");
				orderlist = new ArrayList<String>();
				for (int i = 0; i < temp.length; i++) {
					orderlist.add(temp[i]);
				}

				if (flightNumber.isEmpty() || begin.isEmpty()
						|| arrival.isEmpty() || checkMan.isEmpty()
						|| containerNumber.isEmpty() || orderlist.isEmpty()) {
					JOptionPane.showMessageDialog(null, "信息未填写完整", "提示",
							JOptionPane.ERROR_MESSAGE);
				} else {
					TransferDocVO vo = new TransferDocVO(date,
							transcenterNumber, flightNumber, begin, arrival,
							containerNumber, checkMan, money, transWay,
							orderlist);
					TransCenterTransferDocblService ttd = new TransferDoc();
					
					money = ttd.getTransferFee(vo);
					vo.setmoney(money);
					textArea8.setText(money+"");
					
					if(ttd.addTransferDoc(vo)){
						JOptionPane.showMessageDialog(null, "生成中转单成功", "提示",
								JOptionPane.INFORMATION_MESSAGE);
						ttd.endTransferDoc();
					}else{
						JOptionPane.showMessageDialog(null, "信息填写错误", "提示",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (e.getSource() == button_cancel) {
				textArea2.setText("");
				textArea3.setText("");
				textArea4.setText("");
				textArea5.setText("");
				textArea6.setText("");
				textArea7.setText("");
				textArea8.setText("");
				textArea9.setText(new SimpleDateFormat("yyyy-MM-dd")
						.format(new Date()));
			}
			repaint();
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

	private class FocListener implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == tranway) {
				if (tranway.getSelectedIndex() == 2) {
					transmode = "航班号";
				} else {
					transmode = "车次号";
				}
			}
			label2.setText(transmode);
			add(label2);
			add(textArea2);
			updateUI();
		}
	}
}
