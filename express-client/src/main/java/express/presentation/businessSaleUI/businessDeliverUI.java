package express.presentation.businessSaleUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import express.businessLogic.documentBL.DeliverDoc;
import express.businesslogicService.businessSaleBLService.BusinessSaleDeliverDocumentblService;
import express.presentation.mainUI.DateChooser;
import express.presentation.mainUI.MainUIService;
import express.vo.DeliverDocVO;

public class businessDeliverUI extends JPanel {
	private MainUIService m;
	private JTextField textArea1;
	private JTextField textArea2;
	private JTextField textArea3;
	private DateChooser datechooser;
	private JButton button_confirm;
	private JButton button_cancel;
	private String arriveDate, orderID, deliverManID;
	private DeliverDocVO vo;

	public businessDeliverUI(MainUIService main) {
		int textlength = 150;
		int textwidth = 30;

		int labellength = 100;
		int labelwidth = 30;
		Font font = new Font("楷体", Font.PLAIN, 18);
		Font f = new Font("仿宋", Font.PLAIN, 16);

		setLayout(null);
		this.m = main;

		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);

		JListener listener = new JListener();

		textArea1 = new JTextField();
		textArea1.setBounds(300, 200, textlength, textwidth);
		textArea1.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		textArea1.setFont(f);
		textArea1.setEditable(false);
		// textArea1.setBackground(Color.BLUE);
		// textAreaOutput.setSelectedTextColor(Color.RED);
		// textArea1.setLineWrap(true); // 激活自动换行功能
		// textArea1.setWrapStyleWord(true);// 激活断行不断字功能
		this.add(textArea1);

		datechooser = new DateChooser("yyyy-MM-dd", textArea1);
		datechooser.setBounds(460, 195, 40, 40);
		this.add(datechooser);

		textArea2 = new JTextField();
		textArea2.setBounds(300, 200 + textwidth * 2, textlength, textwidth);
		textArea2.setFont(f);
		// textArea2.setBackground(Color.BLUE);
		// textArea2.setLineWrap(true);
		// textArea2.setWrapStyleWord(true);
		this.add(textArea2);

		textArea3 = new JTextField();
		textArea3.setBounds(300, 200 + textwidth * 4, textlength, textwidth);
		textArea3.setFont(f);
		// textArea3.setBackground(Color.BLUE);
		// textArea3.setLineWrap(true);
		// textArea3.setWrapStyleWord(true);
		this.add(textArea3);

		JLabel label1 = new JLabel("到达日期");
		label1.setBounds(200, 200, labellength, labelwidth);
		label1.setFont(font);
		this.add(label1);

		JLabel label2 = new JLabel("派送员");
		label2.setBounds(200, 200 + labelwidth * 2, labellength, labelwidth);
		label2.setFont(font);
		this.add(label2);

		JLabel label3 = new JLabel("订单条形码号");
		label3.setBounds(200 - 30, 200 + labelwidth * 4, labellength + 30,
				labelwidth);// 字数太多，只能把label拉长一些
		label3.setFont(font);
		this.add(label3);

		button_confirm = new JButton("确定");
		button_confirm.setBounds(230, 490, 120, 30);
		button_confirm.addMouseListener(listener);
		this.add(button_confirm);

		button_cancel = new JButton("取消");
		button_cancel.setBounds(400, 490, 120, 30);
		button_cancel.addMouseListener(listener);
		this.add(button_cancel);

	}

	private class JListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == button_cancel) {
				textArea1.setText("");
				textArea2.setText("");
				textArea3.setText("");
			} else if (e.getSource() == button_confirm) {
				arriveDate = textArea1.getText();
				deliverManID = textArea1.getText();
				orderID = textArea3.getText();
				if (arriveDate.isEmpty() || deliverManID.isEmpty()
						|| orderID.isEmpty()) {
					JOptionPane.showMessageDialog(null, "信息未填写完整", "提示",
							JOptionPane.ERROR_MESSAGE);
				} else {
					vo = new DeliverDocVO(arriveDate, orderID, deliverManID);
					BusinessSaleDeliverDocumentblService bsd = new DeliverDoc();
					if (!bsd.addDeliverDoc(vo)) {
						JOptionPane.showMessageDialog(null, "订单号错误", "提示",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "生成派件单成功", "提示",
								JOptionPane.INFORMATION_MESSAGE);
						bsd.endDeliverDoc();
					}
				}
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
