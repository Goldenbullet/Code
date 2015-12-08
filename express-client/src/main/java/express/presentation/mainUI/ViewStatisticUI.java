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

import express.businessLogic.statisticBL.OperateStatistic;
import express.businessLogic.statisticBL.ProfitStatistic;
import express.businesslogicService.financialBLService.OperateManagerBLService;
import express.businesslogicService.financialBLService.ProfitManagerBLService;


public class ViewStatisticUI extends JPanel{

	private JButton exit;
	private MainUIService m;
	private JTable table;
    private JScrollPane scrollPane; 
	private ArrayList<String> title;
	private String str;
	
	public ViewStatisticUI(MainUIService main,String s){
		setLayout(null);
		m = main;
		str = s;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);	
		Font font = new Font("楷体",Font.PLAIN,20);
		Font f = new Font("仿宋",Font.PLAIN,18);
		
		title = getdate(s);
		String[] tableheader =new String[1];
		tableheader[0] = s;
		String[][] tabledata = new String[title.size()][1];
		for(int i = 0;i<title.size();i++){
			tabledata[i][0] = title.get(i);
		}
		table = new JTable(tabledata,tableheader);
		table.setRowHeight(40);
		TableColumnModel columns = table.getColumnModel();
		TableColumn column1 = columns.getColumn(0); 
		column1.setPreferredWidth(650);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(f);
		table.setBounds(100, 50, 650, 500);	
		
		scrollPane = new JScrollPane(table); 
		scrollPane.setFont(font);
		scrollPane.setBounds(100, 50, 650, 500);
		this.add(scrollPane);
		
		exit = new JButton("取消");
		exit.setBounds(360, 590, 110, 40);
		exit.setFont(new Font("隶书",Font.PLAIN,20));
		this.add(exit);
		
		Listener listener = new Listener();
		
		table.addMouseListener(listener);
		exit.addMouseListener(listener);
	}
	
	private ArrayList<String> getdate(String s){
		ArrayList<String> titlearr = new ArrayList<String>();
		if(s.equals("经营状况表")){
		OperateManagerBLService oper = new OperateStatistic();
		titlearr = oper.getOperateFormListTitle();
		}else if(s.equals("成本收益表")){
			ProfitManagerBLService profits = new ProfitStatistic();
			titlearr = profits.getProfitFormListTitle();
		}
		return titlearr;
	}
	
	private class Listener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==exit){
				m.jumpTomanagerMenuUI();			
			}else if(e.getSource()==table){
				int index = table.getSelectedRow();
				String date = title.get(index);
				m.jumpToStatisticDataUI(str, index,date);
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
