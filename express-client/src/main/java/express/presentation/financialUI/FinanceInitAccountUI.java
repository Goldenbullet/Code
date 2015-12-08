package express.presentation.financialUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import express.presentation.mainUI.DateChooser;
import express.presentation.mainUI.MainUIService;

public class FinanceInitAccountUI extends JPanel {

	private MainUIService m;
	private JPanel staff, org, vehicle, repo, bankaccount, showprevious;
	private JTabbedPane tabpane;
	private JTable[] table;
	private DefaultTableModel[] tableModel;
	private JTextField nametf, phonetf, datetf, idtf, orgnametf, orgidtf;
	private JComboBox gendercb, positioncb, orgcb,citycb, butypecb;
	private DateChooser datechooser;
	private String[][] header;
	private String[][][] data;
	private JButton ok, change, detele, add;
	private int leftside = 10;
	private int textwidth = 120;
	private int textheight = 30;
	private int labelwidth = 50;
	private int labelheight = 30;
	private int tablewidth = 720;
	private int tableheight = 480;
	private Font font = new Font("楷体", Font.PLAIN, 18);
	private Font f = new Font("仿宋", Font.PLAIN, 16);

	public FinanceInitAccountUI(MainUIService main) {
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);

		Listener listener = new Listener();
		Foclistener flis = new Foclistener();

		table = new JTable[6];
		tableModel = new DefaultTableModel[6];

		initstaffPanel();
		orgcb.addFocusListener(flis);

		vehicle = new JPanel();
		repo = new JPanel();
		bankaccount = new JPanel();
		showprevious = new JPanel();

		tabpane = new JTabbedPane();
		tabpane.add("人员信息", staff);
		tabpane.add("机构信息", org);
		tabpane.add("车辆信息", vehicle);
		tabpane.add("库存信息", repo);
		tabpane.add("银行账户信息", bankaccount);
		tabpane.add("查看之前期初信息", showprevious);
		tabpane.setFont(font);
		tabpane.setBounds(50, 0, 720, 610);
		this.add(tabpane);

		// vehicle.setBounds(leftside, base+4*bheight, bwidth, bheight);
		// vehicle.setFont(font);
		// this.add(vehicle);
		// 车牌号，车辆所属机构，车辆代号，服役时间

		// repo.setBounds(leftside, base+6*bheight, bwidth, bheight);
		// repo.setFont(font);
		// this.add(repo);
		// 仓库地址，仓库（航运区、铁运区、汽运区、机动区）排数

		// bankaccount.setBounds(leftside, base+8*bheight, bwidth, bheight);
		// bankaccount.setFont(font);
		// this.add(bankaccount);
		// 账户名，收入金额，支出金额，余额（自动生成）

		// showprevious.setBounds(leftside, base+10*bheight, bwidth, bheight);
		// showprevious.setFont(font);
		// this.add(showprevious);

		ok = new JButton("确认");
		ok.setBounds(180, 620, 110, 30);
		ok.setFont(font);
		this.add(ok);

		// exit = new JButton("取消");
		// exit.setBounds(440, 600, 110, 30);
		// this.add(exit);

		detele = new JButton("删除");
		detele.setBounds(340, 620, 110, 30);
		detele.setFont(font);
		this.add(detele);

		add = new JButton("添加");
		add.setBounds(500, 620, 110, 30);
		add.setFont(font);
		this.add(add);
		
		change = new JButton("修改");
		change.setBounds(500, 620, 110, 30);
		change.setFont(font);
		this.add(change);

		// staff.addMouseListener(listener);
		// org.addMouseListener(listener);
		// vehicle.addMouseListener(listener);
		// repo.addMouseListener(listener);
		// bankaccount.addMouseListener(listener);
		// showprevious.addMouseListener(listener);
		ok.addMouseListener(listener);
		change.addMouseListener(listener);
		detele.addMouseListener(listener);
		add.addMouseListener(listener);
	}

	private void initstaffPanel() {
		// staff
		// 姓名，性别，手机号，入职日期，职位（可选择），所在机构（可选择），工号（选择机构后自动显示一半）
		staff = new JPanel();
		staff.setLayout(null);
		
		String[] headers = { "姓名", "性别", "手机号", "入职日期", "职位", "所在机构", "工号" };
		String[][] datas = { { "卢海龙", "男", "123", "123", "123", "123", "123" } };
		String[] genders = { "男", "女" };
		String[] pos = { "快递员", "管理员", "总经理", "普通财务人员", "最高权限财务人员",
				"中转中心仓库管理人员", "中转中心业务员", "营业厅业务员" };
		String[] orgs = { "110", "101", "100" };
		
		tableModel[0] = new DefaultTableModel(datas, headers);
		table[0] = new JTable(tableModel[0]);
		table[0].setRowHeight(40);
		// FitTableColumns(table[0]);
		table[0].setFont(f);
		table[0].setBounds(0, 0, tablewidth, tableheight);

		TableColumn col_1 = table[0].getColumnModel().getColumn(1);
		col_1.setCellEditor(new DefaultCellEditor(new JComboBox(genders)));
		TableColumn col_2 = table[0].getColumnModel().getColumn(4);
		col_2.setCellEditor(new DefaultCellEditor(new JComboBox(pos)));
		TableColumn col_3 = table[0].getColumnModel().getColumn(5);
		col_3.setCellEditor(new DefaultCellEditor(new JComboBox(orgs)));
		
		JScrollPane scrollPanes = new JScrollPane(table[0]);
		scrollPanes.setFont(font);
		scrollPanes.setBounds(0, 0, tablewidth, tableheight);
		staff.add(scrollPanes);

		JLabel namel = new JLabel("姓名");
		namel.setBounds(leftside, tableheight + 10, labelwidth, labelheight);
		namel.setFont(font);
		staff.add(namel);

		nametf = new JTextField();
		nametf.setBounds(leftside + labelwidth, tableheight + 10,
				textwidth - 30, textheight);
		nametf.setFont(f);
		staff.add(nametf);

		JLabel genderl = new JLabel("性别");
		genderl.setBounds(leftside + labelwidth + 105, tableheight + 10,
				labelwidth, labelheight);
		genderl.setFont(font);
		staff.add(genderl);
		
		gendercb = new JComboBox(genders);
		gendercb.setBounds(leftside + 2 * labelwidth + 110, tableheight + 10,
				labelwidth, textheight);
		gendercb.setFont(f);
		staff.add(gendercb);

		JLabel phonel = new JLabel("手机号");
		phonel.setBounds(leftside + 3 * labelwidth + 125, tableheight + 10,
				labelwidth + 20, labelheight);
		phonel.setFont(font);
		staff.add(phonel);

		phonetf = new JTextField();
		phonetf.setBounds(leftside + 4 * labelwidth + 140, tableheight + 10,
				textwidth, textheight);
		phonetf.setFont(f);
		staff.add(phonetf);

		JLabel positionl = new JLabel("职位");
		positionl.setBounds(leftside + 4 * labelwidth + 150 + textwidth,
				tableheight + 10, labelwidth, labelheight);
		positionl.setFont(font);
		staff.add(positionl);
		
		positioncb = new JComboBox(pos);
		positioncb.setBounds(leftside + 5 * labelwidth + 150 + textwidth,
				tableheight + 10, textwidth + 50, textheight);
		positioncb.setFont(f);
		staff.add(positioncb);

		JLabel datel = new JLabel("入职日期");
		datel.setBounds(leftside, tableheight + 2 * labelheight,
				labelwidth + 30, labelheight);
		datel.setFont(font);
		staff.add(datel);

		datetf = new JTextField();
		datetf.setBounds(leftside + labelwidth + 40, tableheight + 2
				* labelheight, textwidth, textheight);
		datetf.setFont(f);
		datetf.setEditable(false);
		staff.add(datetf);

		datechooser = new DateChooser("yyyy-MM-dd", datetf);
		datechooser.setBounds(leftside + textwidth + labelwidth + 50,
				tableheight + 2 * labelheight - 5, 40, 40);
		staff.add(datechooser);

		JLabel orgl = new JLabel("机构");
		orgl.setBounds(leftside + textwidth + labelwidth + 125, tableheight + 2
				* labelheight, labelwidth, labelheight);
		orgl.setFont(font);
		staff.add(orgl);

		orgcb = new JComboBox(orgs);
		orgcb.setBounds(leftside + textwidth + 2 * labelwidth + 130,
				tableheight + 2 * labelheight, textwidth - 50, textheight);
		orgcb.setFont(f);
		staff.add(orgcb);

		JLabel idl = new JLabel("工号");
		idl.setBounds(leftside + 2 * textwidth + 2 * labelwidth + 115,
				tableheight + 2 * labelheight, labelwidth, labelheight);
		idl.setFont(font);
		staff.add(idl);

		idtf = new JTextField();
		idtf.setBounds(leftside + 2 * textwidth + 3 * labelwidth + 115,
				tableheight + 2 * labelheight, textwidth, textheight);
		idtf.setFont(f);
		staff.add(idtf);

	}

	private void initorgPanel() {
		// org
		// 所属城市，机构全称，性质（选择营业厅、中转中心），机构代号
		org = new JPanel();
		org.setLayout(null);
		String[] headers = { "所属城市", "机构全称", "性质",  "机构代号" };
		String[][] datas = { { "卢海龙", "男", "123", "123" } };
		tableModel[1] = new DefaultTableModel(datas, headers);
		table[1] = new JTable(tableModel[0]);
		table[1].setRowHeight(40);
		table[1].setFont(f);
		table[1].setBounds(0, 0, tablewidth, tableheight);

		JScrollPane scrollPanes = new JScrollPane(table[1]);
		scrollPanes.setFont(font);
		scrollPanes.setBounds(0, 0, tablewidth, tableheight);
		org.add(scrollPanes);
		
		JLabel cityl = new JLabel("所属城市");
		cityl.setBounds(leftside, tableheight + 10, labelwidth, labelheight);
		cityl.setFont(font);
		org.add(cityl);

		citycb = new JComboBox();
		citycb.setBounds(leftside + labelwidth, tableheight + 10,
				textwidth, textheight);
		citycb.setFont(f);
		org.add(citycb);
		
		JLabel orgnamel = new JLabel("机构全称");
		orgnamel.setBounds(leftside + labelwidth + textwidth, tableheight + 10, labelwidth, labelheight);
		orgnamel.setFont(font);
		org.add(orgnamel);
		
		orgnametf = new JTextField();
		orgnametf.setBounds(leftside + 2*labelwidth + textwidth, tableheight + 10,
				textwidth, textheight);
		orgnametf.setFont(f);
		org.add(orgnametf);
		
		JLabel  butypel = new JLabel("机构性质");
		 butypel.setBounds(leftside + labelwidth + textwidth, tableheight + 10, labelwidth, labelheight);
		 butypel.setFont(font);
		org.add( butypel);
		
		String[] butype = {"营业厅","中转中心"};
		butypecb = new JComboBox(butype);
		butypecb.setBounds(leftside + labelwidth, tableheight + 10,
				textwidth, textheight);
		butypecb.setFont(f);
		org.add(butypecb);
		
		JLabel orgidl = new JLabel("机构代号");
		orgidl.setBounds(leftside + labelwidth + textwidth, tableheight + 10, labelwidth, labelheight);
		orgidl.setFont(font);
		org.add(orgidl);
		
		orgidtf = new JTextField();
		orgidtf.setBounds(leftside + 2*labelwidth + textwidth, tableheight + 10,
				textwidth, textheight);
		orgidtf.setFont(f);
		org.add(orgidtf);
	}

	private class Listener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == ok) {

			} else if (e.getSource() == detele) {
				int index = tabpane.getSelectedIndex();
				int row = table[index].getSelectedRow();
				tableModel[index].removeRow(row);
			} else if (e.getSource() == add) {
				int index = tabpane.getSelectedIndex();
				String nametemp = nametf.getText();
				String gendertemp = gendercb.getSelectedItem().toString();
				String phonetemp = phonetf.getText();
				String positiontemp = positioncb.getSelectedItem().toString();
				String datetemp = datetf.getText();
				String orgtemp = orgcb.getSelectedItem().toString();
				String idtemp = idtf.getText();
				String[] values = { nametemp, gendertemp, phonetemp,
						datetemp, positiontemp, orgtemp, idtemp };
				tableModel[index].addRow(values);
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

	private class Foclistener implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == orgcb) {
				idtf.setText("123");
			}
		}

	}
}
