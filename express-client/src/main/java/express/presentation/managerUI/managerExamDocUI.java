package express.presentation.managerUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import express.presentation.mainUI.MainUIService;
import express.presentation.mainUI.MyTableModel;

public class managerExamDocUI extends JPanel {

	private JButton exam, exit;
	private MainUIService m;
	private JTable table;
	private MyTableModel tableModel;
	private Object[][] data = {{false,"到达单","12345"},{false,"到达单","127845"}};
	private String[] header = { "选择", "单据类型", "单据名称" };

	public managerExamDocUI(MainUIService main) {
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
		
		Font font = new Font("楷体", Font.PLAIN, 18);
		Font f = new Font("仿宋", Font.PLAIN, 16);
		Listener listener = new Listener();

		Class[] typeArray = { Boolean.class, Object.class, Object.class };
		
		tableModel = new MyTableModel(data, header,typeArray);
		table = new JTable(tableModel);
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);
		table.setBounds(50, 60, 750, 600);
		table.setFont(f);
		table.addMouseListener(listener);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 60, 750, 600);
		this.add(scrollPane);
		
		exam = new JButton("审批");
		exam.setBounds(100, 10, 100, 30);
		exam.setFont(font);
		exam.addMouseListener(listener);
		this.add(exam);

//		exit = new JButton("exit");
//		exit.setBounds(100, 200, 100, 50);
//		this.add(exit);
	}

	private class Listener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exam) {
				
			}
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
