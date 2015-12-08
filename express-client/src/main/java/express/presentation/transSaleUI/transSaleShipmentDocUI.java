package express.presentation.transSaleUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import express.businessLogic.IDKeeper;
import express.businessLogic.documentBL.ShipmentDocController;
import express.businesslogicService.transcenterSaleBLService.TransCenterSaleShipmentDocblService;
import express.presentation.mainUI.DateChooser;
import express.presentation.mainUI.MainUIService;
import express.vo.ShipmentDocTransCenterVO;

public class transSaleShipmentDocUI extends JPanel {

	private JButton button_confirm, button_cancel;
	private MainUIService m;
	private DateChooser datechooser;
	private JTextField textArea1, textArea2, textArea2_1, textArea3, textArea4, textArea5,
			textArea7, textArea8, textArea9;
	private JTextArea textArea6;
	private String date, transcenterNumber, arrivalplace, startplace, vanID,
			checkMan, transMan, shipmentID;
	private ArrayList<String> orderID;
	private double money;

	public transSaleShipmentDocUI(MainUIService main) {

		int base = 20;
		int textlength = 200;
		int textwidth = 40;

		int labellength = 150;
		int labelwidth = 30;

		Font font = new Font("楷体", Font.PLAIN, 18);
		Font f = new Font("仿宋", Font.PLAIN, 16);

		setLayout(null);
		this.m = main;

		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);

		textArea9 = new JTextField();
		textArea9.setBounds(360, base, textlength, textwidth);
		textArea9.setFont(f);
		this.add(textArea9);

		textArea8 = new JTextField();
		textArea8.setBounds(360, base + labelwidth * 2, textlength, textwidth);
		textArea8.setFont(f);
		textArea8
				.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		textArea8.setEditable(false);
		this.add(textArea8);

		datechooser = new DateChooser("yyyy-MM-dd", textArea8);
		datechooser.setBounds(570, base + labelwidth * 2 - 5, 40, 40);
		this.add(datechooser);

		transcenterNumber = IDKeeper.getOrgID();
		textArea1 = new JTextField();
		textArea1.setText(transcenterNumber);
		textArea1.setBounds(360, base + labelwidth * 4, textlength, textwidth);
		textArea1.setFont(f);
		// textArea1.setBackground(Color.BLUE);
		// textAreaOutput.setSelectedTextColor(Color.RED);
		// textArea1.setLineWrap(true); // 激活自动换行功能
		// textArea1.setWrapStyleWord(true);// 激活断行不断字功能
		this.add(textArea1);

		textArea2 = new JTextField();
		textArea2.setBounds(190, base + labelwidth * 6, textlength, textwidth);
		textArea2.setFont(f);
		this.add(textArea2);

		textArea2_1 = new JTextField();
		textArea2_1.setBounds(530, base + labelwidth * 6, textlength, textwidth);
		textArea2_1.setFont(f);
		this.add(textArea2_1);
		
		textArea3 = new JTextField();
		textArea3.setBounds(360, base + labelwidth * 8, textlength, textwidth);
		textArea3.setFont(f);
		this.add(textArea3);

		textArea4 = new JTextField();
		textArea4.setBounds(360, base + labelwidth * 10, textlength, textwidth);
		textArea4.setFont(f);
		this.add(textArea4);

		textArea5 = new JTextField();
		textArea5.setBounds(360, base + labelwidth * 12, textlength, textwidth);
		textArea5.setFont(f);
		this.add(textArea5);

		textArea6 = new JTextArea();
		textArea6.setBounds(360, base + labelwidth * 14, textlength,
				textwidth * 2);
		textArea6.setFont(f);
		textArea6.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		textArea6.setLineWrap(true);
		textArea6.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(textArea6);
		scrollPane.setFont(font);
		scrollPane.setBounds(360, base + labelwidth * 14, textlength,
				textwidth * 2);
		this.add(scrollPane);

		textArea7 = new JTextField();
		textArea7.setBounds(360, base + labelwidth * 17 + 10, textlength,
				textwidth);
		textArea7.setFont(f);
		this.add(textArea7);

		JLabel label8 = new JLabel("装车单编号");
		label8.setBounds(200, base + 5, labellength + 50, labelwidth);
		label8.setFont(font);
		this.add(label8);

		JLabel label9 = new JLabel("装车日期");
		label9.setBounds(200, base + 5 + labelwidth * 2, labellength + 50,
				labelwidth);
		label9.setFont(font);
		this.add(label9);

		JLabel label1 = new JLabel("本中转中心汽运编号");
		label1.setBounds(200 - 50, base + 5 + labelwidth * 4, labellength + 50,
				labelwidth);
		label1.setFont(font);
		this.add(label1);

		JLabel label2 = new JLabel("到达地");
		label2.setBounds(100, base + 5 + labelwidth * 6, labellength,
				labelwidth);
		label2.setFont(font);
		this.add(label2);
		
		JLabel label2_1 = new JLabel("出发地");
		label2_1.setBounds(440, base + 5 + labelwidth * 6, labellength,
				labelwidth);
		label2_1.setFont(font);
		this.add(label2_1);

		JLabel label3 = new JLabel("车辆代号");
		label3.setBounds(200, base + 5 + labelwidth * 8, labellength,
				labelwidth);
		label3.setFont(font);
		this.add(label3);

		JLabel label4 = new JLabel("监装员");
		label4.setBounds(200, base + 5 + labelwidth * 10, labellength,
				labelwidth);
		label4.setFont(font);
		this.add(label4);

		JLabel label5 = new JLabel("押运员");
		label5.setBounds(200, base + 5 + labelwidth * 12, labellength,
				labelwidth);
		label5.setFont(font);
		this.add(label5);

		JLabel label6 = new JLabel("本次装箱所有订单条形号码");
		label6.setBounds(200 - 70, base + 5 + labelwidth * 14,
				labellength + 100, labelwidth);
		label6.setFont(font);
		this.add(label6);

		JLabel label7 = new JLabel("运费");
		label7.setBounds(200, base + 15 + labelwidth * 17, labellength,
				labelwidth);
		label7.setFont(font);
		this.add(label7);

		JListener listener = new JListener();

		button_confirm = new JButton("确定");
		button_confirm.setBounds(250, 605, 100, 30);
		button_confirm.setFont(font);
		button_confirm.addMouseListener(listener);
		this.add(button_confirm);

		button_cancel = new JButton("取消");
		button_cancel.setBounds(400, 605, 100, 30);
		button_cancel.addMouseListener(listener);
		button_cancel.setFont(font);
		this.add(button_cancel);
	}

	private class JListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == button_confirm) {

				shipmentID = textArea9.getText();
				date = textArea8.getText();
				arrivalplace = textArea2.getText();
				startplace = textArea2_1.getText();
				vanID = textArea3.getText();
				checkMan = textArea4.getText();
				transMan = textArea5.getText();
				String[] temp = textArea6.getText().split("\n");
				orderID = new ArrayList<String>();
				for (int i = 0; i < temp.length; i++) {
					orderID.add(temp[i]);
				}

				if (shipmentID.isEmpty() || arrivalplace.isEmpty()
						|| vanID.isEmpty() || checkMan.isEmpty()
						|| transMan.isEmpty() || orderID.isEmpty()) {
					JOptionPane.showMessageDialog(null, "信息未填写完整", "提示",
							JOptionPane.ERROR_MESSAGE);
				} else {
					ShipmentDocTransCenterVO vo = new ShipmentDocTransCenterVO(
							date, transcenterNumber, arrivalplace, vanID,
							checkMan, transMan, orderID, money, shipmentID,
							startplace);
					TransCenterSaleShipmentDocblService tsd = new ShipmentDocController();
					
					money = tsd.getShipmentfee(vo);
					vo.setMoney(money);
					textArea7.setText(money+"");
					
					if (tsd.addShipmentDoc(vo)) {
						JOptionPane.showMessageDialog(null, "生成装车单成功", "提示",
								JOptionPane.INFORMATION_MESSAGE);
						tsd.endShipmentDoc();
					} else {
						JOptionPane.showMessageDialog(null, "装车单编号不存在", "提示",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (e.getSource() == button_cancel) {
				textArea9.setText("");
				textArea8.setText(new SimpleDateFormat("yyyy-MM-dd")
						.format(new Date()));
				textArea2.setText("");
				textArea2_1.setText("");
				textArea3.setText("");
				textArea4.setText("");
				textArea5.setText("");
				textArea6.setText("");
				textArea7.setText("");
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

}
