package express.presentation.mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewProfitUI extends JPanel {

	private MainUIService m;
	private JButton excel, exit, count;
	private JTextField time,income,outcome,profit;
	private JLabel title;
	private JTable profittable;
	private JScrollPane scrollPane;
	private String[] tableheader = { "统计时间", "总收入", "总支出", "总利润" };
	private DefaultTableModel tableModel;
	
	public ViewProfitUI(MainUIService main){
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
		
		Font font = new Font("楷体", Font.PLAIN, 18);
		Font f = new Font("仿宋", Font.PLAIN, 16);
		Font font2 = new Font("楷体", Font.BOLD, 18);
		
		title = new JLabel("成 本 收 益 表");
		title.setBounds(250, 50, 200, 40);
		title.setFont(font2);
		this.add(title);
		
		Listener listen = new Listener();
		
		String[][] data = null;
		tableModel = new DefaultTableModel(data, tableheader);
		profittable = new JTable(tableModel);
		profittable.getTableHeader().setFont(f);
		profittable.setRowHeight(40);
		profittable.addMouseListener(listen);
		this.add(profittable);
		
		excel = new JButton("导出到Excel");
		excel.setBounds(420, 480, 120, 40);
		excel.setVisible(false);
		excel.setFont(new Font("隶书", Font.PLAIN, 20));
		excel.addMouseListener(listen);
		this.add(excel);
		
		exit = new JButton("返回");
		exit.setBounds(420, 480, 120, 40);
		exit.setVisible(false);
		exit.setFont(new Font("隶书", Font.PLAIN, 20));
		exit.addMouseListener(listen);
		this.add(exit);
	}
	
	private class Listener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exit) {
				m.jumpToFinanceMenuUI();
			} else if (e.getSource() == excel) {
				
			}
			else if(e.getSource() == count){
				
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
