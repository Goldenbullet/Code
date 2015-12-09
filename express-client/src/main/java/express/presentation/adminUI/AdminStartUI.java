package express.presentation.adminUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import express.businessLogic.infoManageBL.Admin;
import express.businesslogicService.adminBLService.AdminBLService;
import express.businesslogicService.adminBLService.RemoveUserBLService;
import express.presentation.mainUI.MainUIService;
import express.presentation.mainUI.MyTableModel;
import express.vo.UserInfoVO;

public class AdminStartUI extends JPanel {

	private MainUIService main;
	private JLabel userinfo, idl;
	private JTextField idtf;
	private JButton detele, add, search;
	private JLabel exit;
	private JTable table;
	private MyTableModel tmodel;
	// private DefaultTableModel tableModel;
	// private TableColumnModel tcm;
	private AdminBLService abs;
	private ArrayList<UserInfoVO> userarr;
	private String id;
	private Object[][] data;
	private String[] header = { "选择", "姓名", "职位", "工号", "密码" };

	public AdminStartUI(MainUIService m) {
		String[] pos = { "快递员", "管理员", "总经理", "普通财务人员", "最高权限财务人员",
				"中转中心仓库管理人员", "中转中心业务员", "营业厅业务员" };
		Class[] typeArray = { Boolean.class, Object.class, JComboBox.class,
				Object.class, Object.class };
//		 Object[] user1 = { true, "lhl", "man", "10001", "110" };
//		 Object[] user2 = { new Boolean(false), "hmt", "woman", "10086", "120"
//		 };
//		 Object user[][] = { user1, user2 };
//		 data = user;

		this.setLayout(null);
		this.main = m;
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 1000, 700);

		Font font = new Font("楷体", Font.PLAIN, 18);
		Font f = new Font("仿宋", Font.PLAIN, 16);

		JListener listener = new JListener();
		abs = new Admin();

		userarr = abs.getUnregistered();
		if (userarr!=null) {
			data = new Object[userarr.size()][5];
			for (int i = 0; i < userarr.size(); i++) {
				UserInfoVO temp = userarr.get(i);
				data[i][0] = false;
				data[i][1] = temp.getName();
				data[i][3] = temp.getID();
				data[i][2] = temp.getPosition();
				data[i][4] = "";
			}
		}

		userinfo = new JLabel();
		userinfo.setBounds(0, 0, 150, 30);
		userinfo.setText("      姓名");
		userinfo.setForeground(Color.BLACK);
		userinfo.setFont(new Font("隶书", Font.PLAIN, 16));
		this.add(userinfo);

		exit = new JLabel("<HTML><U>退出</U></HTML>");
		exit.setBounds(120, 0, 50, 20);
		exit.setFont(new Font("幼圆", Font.BOLD, 16));
		exit.setForeground(Color.BLACK);
		exit.addMouseListener(listener);
		this.add(exit);

		JComboBox poscb = new JComboBox(pos);

		tmodel = new MyTableModel(data, header,typeArray);
		table = new JTable(tmodel);
		table.setRowHeight(40);
		table.setBounds(50, 60, 900, 600);
		table.setFont(f);
		// tcm = table.getColumnModel();
		// // tcm.getColumn(0).setCellEditor(new DefaultCellEditor(cb));
		// tcm.getColumn(2).setCellEditor(new DefaultCellEditor(poscb));
		table.addMouseListener(listener);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 60, 900, 600);
		this.add(scrollPane);

		detele = new JButton("删除");
		detele.setBounds(280, 10, 100, 40);
		detele.setFont(font);
		detele.addMouseListener(listener);
		this.add(detele);

		add = new JButton("添加");
		add.setBounds(410, 10, 100, 40);
		add.addMouseListener(listener);
		add.setFont(font);
		this.add(add);

		search = new JButton("查找");
		search.setBounds(770, 10, 100, 40);
		search.addMouseListener(listener);
		search.setFont(font);
		this.add(search);

		idl = new JLabel("工号");
		idl.setBounds(540, 10, 50, 40);
		idl.setFont(font);
		this.add(idl);

		idtf = new JTextField();
		idtf.setBounds(600, 10, 150, 40);
		idtf.setFont(f);
		this.add(idtf);
	}

	private class JListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == exit) {
				
				exit.setForeground(Color.RED);
				main.jumpToSignInUI();

			} else if (e.getSource() == detele) {
				
				RemoveUserBLService rub = new Admin();
				for (int i = tmodel.getRowCount() - 1; i >= 0; i--) {
					if ((boolean) tmodel.getValueAt(i, 0)) {
						tmodel.removeRow(i);
						rub.removeUser((String) tmodel.getValueAt(i, 3));
					}
				}
				JOptionPane.showMessageDialog(null, "删除成功", "提示",
						JOptionPane.INFORMATION_MESSAGE);
				
			} else if (e.getSource() == add) {
				
				AdminAddUI addui = new AdminAddUI(tmodel);
				addui.setVisible(true);
				
			} else if (e.getSource() == search) {
				
				id = idtf.getText();
				if (abs.checkUserID(id)) {
					AdminChangeUI acui = new AdminChangeUI(tmodel, id);
					acui.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "工号不存在", "提示",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			updateUI();
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exit) {
				exit.setForeground(Color.BLUE);
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exit) {
				exit.setForeground(Color.BLACK);
			}
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exit) {
				exit.setForeground(Color.RED);
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exit) {
				exit.setForeground(Color.BLUE);
			}
		}

	}
}
