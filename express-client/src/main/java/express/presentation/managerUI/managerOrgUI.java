package express.presentation.managerUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import express.presentation.mainUI.MainUIService;
import express.presentation.mainUI.MyTableModel;
import express.vo.OrganizationVO;

public class managerOrgUI extends JPanel{

	private MainUIService m;
	private JTable table;
	private MyTableModel tableModel;
	private TableColumnModel tcm;
	private JButton ok,exit;
	private JTextField nametf,addresstf,city1tf,city2tf,distancetf,pricetf;
	private JComboBox orgtypecb, citycb;
	private String changeunder = "<HTML><U>修改</U></HTML>";
	private String confirmunder = "<HTML><U>确认</U></HTML>";
	private String name,address,city1,city2,distance,price;
	private OrganizationVO orginfo;
	
	public managerOrgUI(MainUIService main){
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
		
		int leftside1 = 170;
		int leftside2 = 270;
		Font font = new Font("楷体",Font.PLAIN,18);
		Font f = new Font("仿宋",Font.PLAIN,16);
		
		// 所属城市，机构全称，性质（选择营业厅、中转中心），机构代号
		Class[] typeArray = { Boolean.class, Object.class, Object.class,
				Object.class, Object.class, Object.class };
		String[] headers = { "选择", "所属城市", "机构全称", "性质", "机构代号","修改"  };
		Object[][] datas = { { false, "卢海龙", "男", "123", "123",changeunder } };
		String[] cities = { "南京", "北京", "上海" };
		String[] orgtypes = { "营业厅", "中转中心" };

		tableModel = new MyTableModel(datas, headers, typeArray);
		table = new JTable(tableModel);
		table.setRowHeight(40);
		table.setFont(f);
		table.setBounds(50, 50, 750, 600);

		citycb = new JComboBox(cities);
		orgtypecb = new JComboBox(orgtypes);
		tcm = table.getColumnModel();		
		tcm.getColumn(1).setCellEditor(new DefaultCellEditor(citycb));
		tcm.getColumn(3).setCellEditor(new DefaultCellEditor(orgtypecb));
		
		JScrollPane scrollPanes = new JScrollPane(table);
		scrollPanes.setFont(font);
		scrollPanes.setBounds(50, 50, 750, 600);
		this.add(scrollPanes);
				
	}
	
	private class Listener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			requestFocus();
			if(e.getSource()==exit){
				
			}else if(e.getSource()==ok){
				
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
	
	private class Foclistener implements FocusListener{

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == nametf&&nametf.getText().equals("机构名称")){
				nametf.setText("");
			}else if(e.getSource() == addresstf&&addresstf.getText().equals("机构地址")){
				addresstf.setText("");
			}else if(e.getSource() == city1tf&&city1tf.getText().equals("城市1")){
				city1tf.setText("");
			}else if(e.getSource() == city2tf&&city2tf.getText().equals("城市2")){
				city2tf.setText("");
			}else if(e.getSource() == distancetf&&distancetf.getText().equals("距离")){
				distancetf.setText("");
			}else if(e.getSource() == pricetf&&pricetf.getText().equals("距离")){
				pricetf.setText("");
			}
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == nametf&&nametf.getText().isEmpty()){
				nametf.setText("机构名称");
			}else if(e.getSource() == addresstf&&addresstf.getText().isEmpty()){
				addresstf.setText("机构地址");
			}else if(e.getSource() == city1tf&&city1tf.getText().isEmpty()){
				city1tf.setText("城市1");
			}else if(e.getSource() == city2tf&&city2tf.getText().isEmpty()){
				city2tf.setText("城市2");
			}else if(e.getSource() == distancetf&&distancetf.getText().isEmpty()){
				distancetf.setText("距离");
			}else if(e.getSource() == pricetf&&pricetf.getText().isEmpty()){
				pricetf.setText("价格");
			}
		}		
	}

//	public void paintComponent(Graphics g) {
//		ImageIcon background = new ImageIcon("picture/background.png");
//		g.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
//	}
}
