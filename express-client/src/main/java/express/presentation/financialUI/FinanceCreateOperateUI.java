package express.presentation.financialUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import express.businessLogic.statisticBL.OperateStatistic;
import express.businesslogicService.financialBLService.OperateFinanceBLService;
import express.presentation.mainUI.DateChooser;
import express.presentation.mainUI.MainUIService;
import express.vo.ReceiveDocVO;

public class FinanceCreateOperateUI extends JPanel {

	private MainUIService m;
	private JButton ok, exit;
	private JTable operatetable;
	private JScrollPane scrollPane;
	private JTextField startdatetf, enddatetf;
	private DateChooser datechoosers, datechoosere;
	private String beginDate ="", endDate = "";
	private String[][] data= {{" "," "},{" "," "}};
	private String[] tableheader = { "收款单", "付款单" };
	 private DefaultTableModel tableModel;

	public FinanceCreateOperateUI(MainUIService main) {
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);

		int textlength = 150;
		int textwidth = 30;
		Font font = new Font("楷体", Font.PLAIN, 18);
		Font f = new Font("仿宋", Font.PLAIN, 16);

		JLabel begindatel = new JLabel("开始日期");
		begindatel.setFont(font);
		begindatel.setBounds(100, 50, 100, 40);
		this.add(begindatel);

		startdatetf = new JTextField();
		startdatetf.setFont(f);
		startdatetf.setBounds(210, 50, textlength, textwidth);
		startdatetf.setEditable(false);
		this.add(startdatetf);

		datechoosers = new DateChooser("yyyy-MM-dd", startdatetf);
		datechoosers.setBounds(370, 45, 40, 40);
		this.add(datechoosers);

		JLabel enddatel = new JLabel("结束日期");
		enddatel.setFont(font);
		enddatel.setBounds(430, 50, 100, 40);
		this.add(enddatel);

		enddatetf = new JTextField();
		enddatetf.setFont(f);
		enddatetf.setBounds(540, 50, textlength, textwidth);
		enddatetf.setEditable(false);
		this.add(enddatetf);

		datechoosere = new DateChooser("yyyy-MM-dd", enddatetf);
		datechoosere.setBounds(700, 45, 40, 40);
		this.add(datechoosere);
	
		tableModel = new DefaultTableModel(data, tableheader);
		operatetable = new JTable(tableModel);
		operatetable.setRowHeight(40);

		// TableColumnModel columns = operatetable.getColumnModel();
		// TableColumn column1 = columns.getColumn(0);
		// column1.setPreferredWidth(200);
		// TableColumn column2 = columns.getColumn(1);
		// column2.setPreferredWidth(160);
		// TableColumn column3 = columns.getColumn(2);
		// column2.setPreferredWidth(160);
		// TableColumn column4 = columns.getColumn(3);
		// column2.setPreferredWidth(160);
		// profittable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		operatetable.setFont(f);
		operatetable.setBounds(100, 100, 650, 450);
		// logtable.setBorder(BorderFactory.createEtchedBorder());
		// this.add(logtable);

		scrollPane = new JScrollPane(operatetable);
		scrollPane.setFont(font);
		// scrollPane.setViewportView(logtable);
		scrollPane.setBounds(100, 100, 650, 450);
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

	public void getdocs() {
		String[][] docs = null;
		
		if (!beginDate.equals("") && !endDate.equals("")) {
			OperateFinanceBLService oper = new OperateStatistic();
			ArrayList<ReceiveDocVO> receive = oper.addOperateForm(beginDate,
					endDate).getReceiveDoc();
			if (receive != null) {
				docs = new String[receive.size()][2];
				for (int i = 0; i < receive.size(); i++) {
					docs[i][0] = receive.get(i).getReceiveDate() + "    "
							+ receive.get(i).getReceivePrice();System.out.println(docs[i][0]);
							docs[i][1] = "  ";
				}
			}
			tableModel.setDataVector(docs, tableheader);
		}
		
	}

	private class Listener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exit) {
				m.jumpToFinanceMenuUI();
			} else if (e.getSource() == ok) {
				beginDate = startdatetf.getText();
				endDate = enddatetf.getText();
				getdocs();
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
