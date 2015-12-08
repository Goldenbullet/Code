package express.presentation.deliverUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import express.businessLogic.documentBL.OrderController;
import express.businesslogicService.delivermanBLService.DeliverCreateOrderBLService;
import express.po.DeliveryType;
import express.po.PackageType;
import express.presentation.mainUI.MainUIService;
import express.vo.OrderVO;

public class deliverOrderUI extends JPanel {

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
	private JTextField textField_15, textField_16, textField_17;
	private JLabel tip1, tip2;
	private JButton button_cancel, button_confirm;
	private ButtonGroup bg1, bg2;
	private JRadioButton radioButton, radioButton_1, radioButton_2,
			radioButton_3, radioButton_4, radioButton_5, radioButton_6;
	private String sendername, senderaddress, senderworkplace, sendertelpnum,
			sendermobilepnm;
	private String recipientname, recipientaddress, recipientworkplace,
			recipienttelpnum, recipientmobilepnm;
	private int count;
	private double weight, volume, money;
	private String nameOfGoods, orderID, startCity, endCity, predictTime;
	private DeliveryType type;
	private PackageType packagetype;
	private Border border;
	private boolean complete = true;

	public deliverOrderUI(MainUIService main) {
		setLayout(null);
		this.m = main;

		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);

		Font font = new Font("楷体", Font.PLAIN, 18);
		Font font0 = new Font("楷体", Font.BOLD, 20);
		Font f = new Font("仿宋", Font.PLAIN, 14);

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

		border = textField.getBorder();

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

		JLabel label_20 = new JLabel("地址信息:");
		label_20.setBounds(5, 305, 100, 30);
		label_20.setFont(font0);
		this.add(label_20);

		JLabel label_18 = new JLabel("出发地");
		label_18.setBounds(125, 305, 100, 30);
		label_18.setFont(font);
		this.add(label_18);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(220, 305, 150, 30);
		textField_16.setFont(f);
		this.add(textField_16);

		JLabel label_19 = new JLabel("到达地");
		label_19.setBounds(410, 305, 100, 30);
		label_19.setFont(font);
		this.add(label_19);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(510, 305, 150, 30);
		textField_17.setFont(f);
		this.add(textField_17);

		JLabel lblNewLabel_2 = new JLabel("托运货物信息：");
		lblNewLabel_2.setBounds(5, 355, 160, 30);
		lblNewLabel_2.setFont(font0);
		this.add(lblNewLabel_2);

		JLabel label_10 = new JLabel("原件数");
		label_10.setBounds(20, 395, 100, 30);
		label_10.setFont(font);
		this.add(label_10);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(100, 395, 70, 30);
		textField_10.setFont(f);
		this.add(textField_10);

		JLabel label_11 = new JLabel("实际重量");
		label_11.setBounds(224, 395, 100, 30);
		label_11.setFont(font);
		this.add(label_11);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(300, 395, 70, 30);
		textField_11.setFont(f);
		this.add(textField_11);

		JLabel label_12 = new JLabel("体积");
		label_12.setBounds(425, 395, 100, 30);
		label_12.setFont(font);
		this.add(label_12);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(497, 395, 70, 30);
		textField_12.setFont(f);
		this.add(textField_12);

		JLabel label_13 = new JLabel("内件品名");
		label_13.setBounds(605, 395, 100, 30);
		label_13.setFont(font);
		this.add(label_13);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(680, 395, 150, 30);
		textField_13.setFont(f);
		this.add(textField_13);

		JLabel label_14 = new JLabel("快递种类");
		label_14.setBounds(5, 450, 100, 30);
		label_14.setFont(font);
		this.add(label_14);

		bg1 = new ButtonGroup();

		radioButton = new JRadioButton("经济快递");
		radioButton.setBounds(100, 450, 100, 30);
		radioButton.setFont(font);
		bg1.add(radioButton);
		this.add(radioButton);

		radioButton_1 = new JRadioButton("标准快递");
		radioButton_1.setBounds(270, 450, 100, 30);
		radioButton_1.setFont(font);
		bg1.add(radioButton_1);
		this.add(radioButton_1);

		radioButton_2 = new JRadioButton("特快快递");
		radioButton_2.setBounds(440, 450, 100, 30);
		radioButton_2.setFont(font);
		bg1.add(radioButton_2);
		this.add(radioButton_2);

		tip1 = new JLabel(" * 未选择");
		tip1.setBounds(550, 450, 100, 30);
		tip1.setForeground(Color.RED);
		tip1.setFont(font);

		JLabel label_15 = new JLabel("包装类型");
		label_15.setBounds(5, 500, 100, 30);
		label_15.setFont(font);
		this.add(label_15);

		bg2 = new ButtonGroup();

		radioButton_3 = new JRadioButton("纸箱");
		radioButton_3.setBounds(100, 500, 100, 30);
		radioButton_3.setFont(font);
		bg2.add(radioButton_3);
		this.add(radioButton_3);

		radioButton_4 = new JRadioButton("木箱");
		radioButton_4.setBounds(270, 500, 100, 30);
		radioButton_4.setFont(font);
		bg2.add(radioButton_4);
		this.add(radioButton_4);

		radioButton_5 = new JRadioButton("快递袋");
		radioButton_5.setBounds(440, 500, 100, 30);
		radioButton_5.setFont(font);
		bg2.add(radioButton_5);
		this.add(radioButton_5);

		// radioButton_6 = new JRadioButton("其它");
		// radioButton_6.setBounds(610, 500, 100, 30);
		// radioButton_6.setFont(font);
		// bg2.add(radioButton_6);
		// this.add(radioButton_6);

		tip2 = new JLabel(" * 未选择");
		tip2.setBounds(550, 500, 100, 30);
		tip2.setForeground(Color.RED);
		tip2.setFont(font);

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
		textField_15.setEditable(false);
		textField_15.setFont(f);
		this.add(textField_15);

		Listener lis = new Listener();

		button_confirm = new JButton("确定");
		button_confirm.setBounds(250, 615, 100, 30);
		button_confirm.setFont(font);
		button_confirm.addMouseListener(lis);
		this.add(button_confirm);

		button_cancel = new JButton("取消");
		button_cancel.setBounds(380, 615, 100, 30);
		button_cancel.setFont(font);
		button_cancel.addMouseListener(lis);
		this.add(button_cancel);
	}

	private class Listener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == button_cancel) {
				textField.setText("");
				textField.setBorder(border);
				textField_1.setText("");
				textField_1.setBorder(border);
				textField_2.setText("");
				textField_2.setBorder(border);
				textField_3.setText("");
				textField_3.setBorder(border);
				textField_4.setText("");
				textField_4.setBorder(border);
				textField_5.setText("");
				textField_5.setBorder(border);
				textField_6.setText("");
				textField_6.setBorder(border);
				textField_7.setText("");
				textField_7.setBorder(border);
				textField_8.setText("");
				textField_8.setBorder(border);
				textField_9.setText("");
				textField_9.setBorder(border);
				textField_10.setText("");
				textField_10.setBorder(border);
				textField_11.setText("");
				textField_11.setBorder(border);
				textField_12.setText("");
				textField_12.setBorder(border);
				textField_13.setText("");
				textField_13.setBorder(border);
				textField_14.setText("");
				textField_14.setBorder(border);
				textField_15.setText("");
				textField_16.setText("");
				textField_16.setBorder(border);
				textField_17.setText("");
				textField_17.setBorder(border);
				tip1.setVisible(false);
				tip2.setVisible(false);
				bg1.clearSelection();
				bg2.clearSelection();
			} else if (e.getSource() == button_confirm) {
				sendername = textField.getText();
				if (sendername.isEmpty()) {
					complete = false;
					textField.setBorder(new LineBorder(new Color(200, 80, 80)));
				}
				senderaddress = textField_1.getText();
				if (senderaddress.isEmpty()) {
					complete = false;
					textField_1
							.setBorder(new LineBorder(new Color(200, 80, 80)));
				}
				senderworkplace = textField_2.getText();
				if (senderworkplace.isEmpty()) {
					complete = false;
					textField_2
							.setBorder(new LineBorder(new Color(200, 80, 80)));
				}
				sendertelpnum = textField_3.getText();
				if (sendertelpnum.isEmpty()) {
					complete = false;
					textField_3
							.setBorder(new LineBorder(new Color(200, 80, 80)));
				}
				sendermobilepnm = textField_4.getText();
				if (sendermobilepnm.isEmpty()) {
					complete = false;
					textField_4
							.setBorder(new LineBorder(new Color(200, 80, 80)));
				}

				recipientname = textField_5.getText();
				if (recipientname.isEmpty()) {
					complete = false;
					textField_5
							.setBorder(new LineBorder(new Color(200, 80, 80)));
				}
				recipientaddress = textField_6.getText();
				if (recipientaddress.isEmpty()) {
					complete = false;
					textField_6
							.setBorder(new LineBorder(new Color(200, 80, 80)));
				}
				recipientworkplace = textField_7.getText();
				if (recipientworkplace.isEmpty()) {
					complete = false;
					textField_7
							.setBorder(new LineBorder(new Color(200, 80, 80)));
				}
				recipienttelpnum = textField_8.getText();
				if (recipienttelpnum.isEmpty()) {
					complete = false;
					textField_8
							.setBorder(new LineBorder(new Color(200, 80, 80)));
				}
				recipientmobilepnm = textField_9.getText();
				if (recipientmobilepnm.isEmpty()) {
					complete = false;
					textField_9
							.setBorder(new LineBorder(new Color(200, 80, 80)));
				}

				if (textField_10.getText().isEmpty()) {
					complete = false;
					textField_10.setBorder(new LineBorder(
							new Color(200, 80, 80)));
				} else {
					count = Integer.parseInt(textField_10.getText());
				}
				if (textField_11.getText().isEmpty()) {
					complete = false;
					textField_11.setBorder(new LineBorder(
							new Color(200, 80, 80)));
				} else {
					weight = Double.parseDouble(textField_11.getText());
				}
				if (textField_12.getText().isEmpty()) {
					complete = false;
					textField_12.setBorder(new LineBorder(
							new Color(200, 80, 80)));
				} else {
					volume = Double.parseDouble(textField_12.getText());
				}

				nameOfGoods = textField_13.getText();
				if (nameOfGoods.isEmpty()) {
					complete = false;
					textField_13.setBorder(new LineBorder(
							new Color(200, 80, 80)));
				}
				orderID = textField_14.getText();
				if (orderID.isEmpty()) {
					complete = false;
					textField_14.setBorder(new LineBorder(
							new Color(200, 80, 80)));
				}
				startCity = textField_16.getText();
				if (startCity.isEmpty()) {
					complete = false;
					textField_16.setBorder(new LineBorder(
							new Color(200, 80, 80)));
				}
				endCity = textField_17.getText();
				if (endCity.isEmpty()) {
					complete = false;
					textField_17.setBorder(new LineBorder(
							new Color(200, 80, 80)));
				}

				if (radioButton.isSelected()) {
					type = DeliveryType.Slow;
				} else if (radioButton_1.isSelected()) {
					type = DeliveryType.Standard;
				} else if (radioButton_2.isSelected()) {
					type = DeliveryType.Fast;
				} else {
					add(tip1);
				}

				if (radioButton_3.isSelected()) {
					packagetype = packagetype.CardBox;
				} else if (radioButton_4.isSelected()) {
					packagetype = packagetype.WoodBox;
				} else if (radioButton_5.isSelected()) {
					packagetype = packagetype.DeliverBag;
				} else {
					add(tip2);
				}

				if (complete) {
					OrderVO vo = new OrderVO();
					vo.setSenderInfo(sendername, senderaddress,
							senderworkplace, sendermobilepnm, sendertelpnum,
							startCity);
					vo.setReceiverInfo(recipientname, recipientaddress,
							recipientworkplace, recipientmobilepnm,
							recipienttelpnum, endCity);
					vo.setGoodsInfo(count, weight, volume, nameOfGoods, type,
							packagetype);
					vo.setOrderID(orderID);
					DeliverCreateOrderBLService dcob = new OrderController();
					money = dcob.getTotal(vo);
					predictTime = dcob
							.getPredictArrivalTime(startCity, endCity)
							.getTime();
					vo.setFee(money);
					vo.setPredictTime(predictTime);
					textField_15.setText(money + "");
					String result = dcob.addOrder(vo);
					if (result.equals(orderID)) {
						JOptionPane.showMessageDialog(null, "生成订单成功" + "\n"
								+ "预计到达时间：" + predictTime, "提示",
								JOptionPane.INFORMATION_MESSAGE);
						dcob.endOrder();
					} else {
						JOptionPane.showMessageDialog(null, result, "提示",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			complete = true;
			updateUI();
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
