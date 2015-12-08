package express.presentation.adminUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import express.presentation.mainUI.MainUIService;

public class AdminStartUI extends JPanel {

	// private JLabel add;
	// private JLabel delete;
	private MainUIService main;
	private JLabel userinfo;
	private JButton button_exit, detele, add;
	private JTable table;
	private MyTableModel tmodel;
	// private DefaultTableModel tableModel;
	private TableColumnModel tcm;
	private Object[][] data;
	private String[] header = { "选择", "姓名", "职位", "工号", "密码" };

	public AdminStartUI(MainUIService m) {
		String[] pos = { "快递员", "管理员", "总经理", "普通财务人员", "最高权限财务人员",
				"中转中心仓库管理人员", "中转中心业务员", "营业厅业务员" };

		Object[] user1 = { true, "lhl", "man", "10001", "110" };
		Object[] user2 = { new Boolean(false), "hmt", "woman", "10086", "120" };
		Object user[][] = { user1, user2 };
		data = user;

		this.setLayout(null);
		this.main = m;
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 1000, 700);

		JListener listener = new JListener();

		userinfo = new JLabel();
		userinfo.setBounds(0, 0, 150, 30);
		userinfo.setText("      userinfo");
		userinfo.setForeground(Color.gray);
		userinfo.setFont(new Font("隶书", Font.PLAIN, 14));
		this.add(userinfo);

		button_exit = new JButton("退出");
		button_exit.setBounds(0, 600, 150, 50);
		button_exit.addMouseListener(listener);
		this.add(button_exit);

		// JCheckBox cb = new JCheckBox();
		JComboBox poscb = new JComboBox(pos);

		tmodel = new MyTableModel(data, header);
		// tableModel = new DefaultTableModel(data, header);
		table = new JTable(tmodel);
		table.setRowHeight(40);
		table.setBounds(200, 50, 750, 500);
		tcm = table.getColumnModel();
		// tcm.getColumn(0).setCellEditor(new DefaultCellEditor(cb));
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(poscb));
		table.addMouseListener(listener);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(200, 50, 750, 500);
		this.add(scrollPane);

		detele = new JButton("删除");
		detele.setBounds(220, 580, 150, 50);
		detele.addMouseListener(listener);
		this.add(detele);

		add = new JButton("添加");
		add.setBounds(400, 580, 150, 50);
		add.addMouseListener(listener);
		this.add(add);
	}

	private class MyTableModel extends DefaultTableModel {

		public MyTableModel(Object[][] data, String[] head) {
			super(data, head);
		}

		// 创建类型数组
		Class[] typeArray = { Boolean.class, Object.class, JComboBox.class,
				Object.class, Object.class };

		// 使表格具有可编辑性
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Class getColumnClass(int columnIndex) {
			return typeArray[columnIndex];// 返回每一列的数据类型
		}
	}

	private class JListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == button_exit) {
				main.jumpToSignInUI();
				repaint();
				System.out.println("应该回到登陆界面的");

			} else if (e.getSource() == detele) {
				for (int i = tmodel.getRowCount() - 1; i >= 0; i--) {
					if ((boolean) tmodel.getValueAt(i, 0)) {
						tmodel.removeRow(i);
					}
				}
			} else if (e.getSource() == add) {
				AdminAddUI addui = new AdminAddUI(tmodel);			
				addui.setVisible(true);
//				if (addui.isclose()) {
//					Object[] values = { false, addui.getvalues() };
//					tmodel.addRow(values);
//				}
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
