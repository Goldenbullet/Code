package express.presentation.financialUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import express.businessLogic.statisticBL.ProfitStatistic;
import express.businesslogicService.financialBLService.ProfitFinanceBLService;
import express.presentation.mainUI.MainUIService;

public class FinanceCreateProfitUI extends JPanel {

	private MainUIService m;
	private JButton ok, exit;
	private JTable profittable;
	private JScrollPane scrollPane;
	String[] tableheader = { "时间", "收入", "支出", "利润" };
	String[][] data = { { " ", " ", " ", " " } };
	private DefaultTableModel tableModel;

	public FinanceCreateProfitUI(MainUIService main) {
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);

		Font font = new Font("楷体", Font.PLAIN, 18);
		Font f = new Font("仿宋", Font.PLAIN, 16);

		tableModel = new DefaultTableModel(data, tableheader);
		profittable = new JTable(tableModel);
		profittable.setRowHeight(40);

		TableColumnModel columns = profittable.getColumnModel();
		TableColumn column1 = columns.getColumn(0);
		column1.setPreferredWidth(200);
		TableColumn column2 = columns.getColumn(1);
		column2.setPreferredWidth(160);
		TableColumn column3 = columns.getColumn(2);
		column2.setPreferredWidth(160);
		TableColumn column4 = columns.getColumn(3);
		column2.setPreferredWidth(160);
		// profittable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		profittable.setFont(f);
		profittable.setBounds(100, 100, 650, 300);
		// logtable.setBorder(BorderFactory.createEtchedBorder());
		// this.add(logtable);

		scrollPane = new JScrollPane(profittable);
		scrollPane.setFont(font);
		// scrollPane.setViewportView(logtable);
		scrollPane.setBounds(100, 100, 650, 300);
		this.add(scrollPane);

		Listener listen = new Listener();

		ok = new JButton("生成");
		ok.setBounds(250, 590, 110, 40);
		ok.setFont(new Font("隶书", Font.PLAIN, 20));
		ok.addMouseListener(listen);
		this.add(ok);

		exit = new JButton("取消");
		exit.setBounds(420, 590, 110, 40);
		exit.setFont(new Font("隶书", Font.PLAIN, 20));
		exit.addMouseListener(listen);
		this.add(exit);

	}

	private void getdata() {
		ProfitFinanceBLService pf = new ProfitStatistic();
		String[][] newdata = new String[1][4];
		newdata[0][0] = pf.addProfitForm().getTitle()+"";
		newdata[0][1] = pf.addProfitForm().getIncome()+"";
		newdata[0][2] = pf.addProfitForm().getOutCome()+"";
		newdata[0][3] = pf.addProfitForm().getProfit()+"";
		tableModel.setDataVector(newdata, tableheader);
	}

	private class Listener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exit) {
				m.jumpToFinanceMenuUI();
			} else if (e.getSource() == ok) {
				getdata();
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
