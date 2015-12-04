package express.presentation.mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import express.businessLogic.syslogBL.SysLog;
import express.businesslogicService.managerBLService.SysLogBLService;
import express.vo.LogVO;


public class ViewSysLogUI extends JPanel{

	private JButton exit;
	private JTable logtable;
    private JScrollPane scrollPane; 
	private MainUIService m;
	
	public ViewSysLogUI(MainUIService main){
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
		Font font = new Font("楷体",Font.PLAIN,20);
		Font f = new Font("仿宋",Font.PLAIN,18);
		
		String[] tableheader = {"操作","时间"};
		String[][] data = getoperationdata() ;
		logtable = new JTable(data,tableheader);
		logtable.setRowHeight(40);
//		TableModel model = logtable.getModel(); 
////		model.setRowCount(0); 
//		((DefaultTableModel) model).setColumnIdentifiers(new Object[] { "操作","时间" });
//		logtable.setModel(model);
//		logtable.setTableHeader(new JTableHeader());
		TableColumnModel columns = logtable.getColumnModel();
		TableColumn column1 = columns.getColumn(0); 
		column1.setPreferredWidth(150);
		TableColumn column2 = columns.getColumn(1); 
		column2.setPreferredWidth(500);
//		logtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		logtable.setFont(f);
		logtable.setBounds(100, 50, 650, 550);	
//		logtable.setBorder(BorderFactory.createEtchedBorder());
//    	this.add(logtable);
		
		scrollPane = new JScrollPane(logtable); 
		scrollPane.setFont(font);
//		scrollPane.setViewportView(logtable);
		scrollPane.setBounds(100, 50, 650, 550);
		this.add(scrollPane);
		
//		exit = new JButton("取消");
//		exit.setBounds(360, 590, 110, 40);
//		exit.setFont(new Font("隶书",Font.PLAIN,20));
//		this.add(exit);
		
		logtable.addMouseListener(new Listener());
//		exit.addMouseListener(new Listener());
	}
	
	private class Listener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		  if(e.getSource()==logtable){
				int a = logtable.getSelectedRow();System.out.println("被选中的行数："+a);
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
	
	private String[][] getoperationdata(){
		SysLogBLService log = new SysLog();
		ArrayList<LogVO> logvo = log.getSystemLog();
		String[][]  data = null;
		
		if(logvo!=null){
			data = new String[logvo.size()][2];
			for(int i = 0;i<logvo.size();i++){
				data[i][0] = logvo.get(i).getOperation();
				data[i][1] = logvo.get(i).getTime();
			}
		}
		
		return data;		
	}
}
