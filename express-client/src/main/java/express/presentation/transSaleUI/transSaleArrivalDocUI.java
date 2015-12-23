package express.presentation.transSaleUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import express.businessLogic.IDKeeper;
import express.businesslogicService.transcenterSaleBLService.TransCenterArrivalDocblService;
import express.businessLogic.documentBL.ArrivalDocTransCenter;
import express.po.GoodsArrivalStatus;
import express.presentation.mainUI.DateChooser;
import express.presentation.mainUI.MainUIService;
import express.vo.ArrivalDocTransCenterVO;

public class transSaleArrivalDocUI extends JPanel {
	private JButton button_confirm, button_cancel;
	private ButtonGroup bg1, bg2;
	private JRadioButton radioButton, radioButton_1, radioButton_2,
			radioButton_3, radioButton_4;
	private JLabel tip;
	private JTextField ordertf, startplacetf, datetf, tranNumtf, transDocNumtf;
	private DateChooser datechooser;
	private String date, transDocNum, tranNum, order, startplace;
	private GoodsArrivalStatus arrivalStatus;
	private Border border;

	public transSaleArrivalDocUI() {

		int textlength = 150;
		int textwidth = 30;

		int labellength = 100;
		int labelwidth = 30;

		int base = 80;

		Font font = new Font("楷体", Font.PLAIN, 18);
		Font f = new Font("仿宋", Font.PLAIN, 16);
		Foclistener foclis = new Foclistener();

		setLayout(null);
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);

		JLabel label1 = new JLabel("到达日期");
		label1.setBounds(200, base, labellength, labelwidth);
		label1.setFont(font);
		this.add(label1);

		datetf = new JTextField();
		datetf.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		datetf.setBounds(300, base, textlength, textwidth);
		datetf.setFont(f);
		datetf.setEditable(false);
		this.add(datetf);

		datechooser = new DateChooser("yyyy-MM-dd", datetf);
		datechooser.setBounds(460, base - 5, 40, 40);
		this.add(datechooser);

		JLabel label2 = new JLabel("订单号");
		label2.setBounds(200 + 10, base + labelwidth * 2, labellength,
				labelwidth);
		label2.setFont(font);
		this.add(label2);

		ordertf = new JTextField();
		ordertf.setBounds(300, base + textwidth * 2, textlength, textwidth);
		ordertf.setFont(f);
		this.add(ordertf);
		border = ordertf.getBorder();

		JLabel label3 = new JLabel("中转中心编号");
		label3.setBounds(200 - 30, base + labelwidth * 4, labellength + 50,
				labelwidth);
		label3.setFont(font);
		this.add(label3);

		tranNum = IDKeeper.getOrgID();
		tranNumtf = new JTextField();
		tranNumtf.setEditable(false);
		tranNumtf.setText(tranNum);
		tranNumtf.setBounds(300, base + textwidth * 4, textlength, textwidth);
		tranNumtf.setFont(f);
		this.add(tranNumtf);

		JLabel label4 = new JLabel("中转单编号");
		label4.setBounds(200 - 10, base + labelwidth * 6, labellength,
				labelwidth);
		label4.setFont(font);
		this.add(label4);

		transDocNumtf = new JTextField();
		transDocNumtf.setBounds(300, base + textwidth * 6, textlength,
				textwidth);
		transDocNumtf.setFont(f);
		this.add(transDocNumtf);

		bg2 = new ButtonGroup();

		radioButton_3 = new JRadioButton("寄件人中转中心");
		radioButton_3.setBounds(300 + textlength + 10, base + labelwidth * 6,
				textlength, labelwidth);
		radioButton_3.setFont(font);
		bg2.add(radioButton_3);
		radioButton_3.addFocusListener(foclis);
		this.add(radioButton_3);

		radioButton_4 = new JRadioButton("收件人中转中心");
		radioButton_4.setBounds(300 + 2 * textlength + 10, base + labelwidth
				* 6, textlength, labelwidth);
		radioButton_4.setFont(font);
		bg2.add(radioButton_4);
		this.add(radioButton_4);

		JLabel label5 = new JLabel("出发地");
		label5.setBounds(200 + 10, base + labelwidth * 8, labellength,
				labelwidth);
		label5.setFont(font);
		this.add(label5);

		startplacetf = new JTextField();
		startplacetf
				.setBounds(300, base + textwidth * 8, textlength, textwidth);
		startplacetf.setFont(f);
		this.add(startplacetf);

		JLabel label6 = new JLabel("货物到达状态");
		label6.setBounds(200 - 30, base + labelwidth * 10, labellength + 50,
				labelwidth);
		label6.setFont(font);
		this.add(label6);

		bg1 = new ButtonGroup();

		radioButton = new JRadioButton("完整");
		radioButton.setBounds(300, base + labelwidth * 10, labellength,
				labelwidth);
		radioButton.setFont(font);
		bg1.add(radioButton);
		this.add(radioButton);

		radioButton_1 = new JRadioButton("损坏");
		radioButton_1.setBounds(300, base + labelwidth * 11, labellength,
				labelwidth);
		radioButton_1.setFont(font);
		bg1.add(radioButton_1);
		this.add(radioButton_1);

		radioButton_2 = new JRadioButton("丢失");
		radioButton_2.setBounds(300, base + labelwidth * 12, labellength,
				labelwidth);
		radioButton_2.setFont(font);
		bg1.add(radioButton_2);
		this.add(radioButton_2);

		tip = new JLabel("*未选择");
		tip.setBounds(420, base + labelwidth * 12, 100, 30);
		tip.setFont(font);
		tip.setForeground(Color.RED);
		
		JListener listener = new JListener();

		button_confirm = new JButton("确定");
		button_confirm.setBounds(210, 520, 110, 40);
		button_confirm.addMouseListener(listener);
		this.add(button_confirm);

		button_cancel = new JButton("取消");
		button_cancel.setBounds(400, 520, 110, 40);
		button_cancel.addMouseListener(listener);
		this.add(button_cancel);

	}

	private class Foclistener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == radioButton_3) {
				if (radioButton_3.isSelected()) {
					transDocNum = "-1";
					transDocNumtf.setEditable(false);
				}
			}else if(e.getSource() == ordertf){
				ordertf.setBorder(border);
			}else if(e.getSource() == transDocNumtf){
				transDocNumtf.setBorder(border);
			}else if(e.getSource() == startplacetf){
				startplacetf.setBorder(border);
			}
			if (radioButton.isSelected()||radioButton_1.isSelected()||radioButton_2.isSelected()) {
				tip.setVisible(false);
			}
			updateUI();
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	private class JListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			requestFocus();
			if (e.getSource() == button_confirm) {
				boolean complete = true;

				date = datetf.getText();
				startplace = startplacetf.getText();
				order = ordertf.getText();
				
				if (!transDocNum.equals("-1")) {
					transDocNum = transDocNumtf.getText();
					if (transDocNum.isEmpty()) {
						complete = false;
						transDocNumtf.setBorder(new LineBorder(Color.RED));
					}
				}

				if (startplace.isEmpty()) {
					complete = false;
					startplacetf.setBorder(new LineBorder(Color.RED));
				}
				
				if (order.isEmpty()) {
					complete = false;
					ordertf.setBorder(new LineBorder(Color.RED));
				}
				
				if(bg1.getSelection() == null){
					complete = false;
					add(tip);
				}
				
				if (radioButton.isSelected()) {
					arrivalStatus = GoodsArrivalStatus.Complete;
				} else if (radioButton_1.isSelected()) {
					arrivalStatus = GoodsArrivalStatus.Damage;
				} else if (radioButton_2.isSelected()) {
					arrivalStatus = GoodsArrivalStatus.Missing;
				}
				if (!complete) {
					JOptionPane.showMessageDialog(null, "信息未填写完整", "提示",
							JOptionPane.ERROR_MESSAGE);
				} else {
					ArrivalDocTransCenterVO vo = new ArrivalDocTransCenterVO(
							order, date, tranNum, transDocNum, startplace,
							arrivalStatus);
					TransCenterArrivalDocblService tadb = new ArrivalDocTransCenter();
					if (tadb.addArrivalDoc(vo)) {
						JOptionPane.showMessageDialog(null, "生成到达单成功", "提示",
								JOptionPane.INFORMATION_MESSAGE);
						tadb.endArrivalDoc();
					} else {
						JOptionPane.showMessageDialog(null, "生成到达单失败", "提示",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			} else if (e.getSource() == button_cancel) {
				tip.setVisible(false);
				ordertf.setText("");
				ordertf.setBorder(border);
				datetf.setText(new SimpleDateFormat("yyyy-MM-dd")
						.format(new Date()));
				startplacetf.setText("");
				startplacetf.setBorder(border);
				bg1.clearSelection();
				bg2.clearSelection();
				transDocNumtf.setText("");
				transDocNumtf.setBorder(border);
				transDocNumtf.setEditable(true);
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
