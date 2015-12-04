package express.presentation.financialUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import express.presentation.mainUI.DateChooser;
import express.presentation.mainUI.MainUIService;

public class FinanceSumReceiveDocUI extends JPanel{

	private JComboBox businesshallcb;
	private JButton ok,exit;
	private JTextField totalmoney,datetf;
	private DateChooser datechooser;
	private MainUIService m;
	
	public FinanceSumReceiveDocUI(MainUIService main){
		setLayout(null);
		m = main;
		this.setBounds(0, 0,850, 700);
		this.setBackground(Color.WHITE);
		
		Font font = new Font("楷体",Font.PLAIN,20);
		Font f = new Font("仿宋",Font.PLAIN,18);
		
		JLabel businesslabel = new JLabel("营业厅");
		businesslabel.setBounds(210, 155, 100, 30);
		businesslabel.setFont(font);
		this.add(businesslabel);
		
		String[] businesshall = getbussinesshall();
		businesshallcb=new JComboBox(businesshall);
		businesshallcb.setBounds(320, 155, 100, 30);
		businesshallcb.setFont(f);
		this.add(businesshallcb);
		
		JLabel datelabel = new JLabel("日期");
		datelabel.setBounds(210, 235, 100, 30);
		datelabel.setFont(font);
		this.add(datelabel);
		
		datetf = new JTextField();
		datetf.setBounds(320, 235, 150, 30);
		datetf.setFont(f);
		datetf.setEditable(false);
		this.add(datetf);
		
		datechooser = new DateChooser("yyyy-MM-dd", datetf);
		datechooser.setBounds(480, 230, 40, 40);
		this.add(datechooser);
		
		JLabel totallabel = new JLabel("总额");
		totallabel.setBounds(210, 315, 100, 30);
		totallabel.setFont(font);
		this.add(totallabel);
		
		totalmoney = new JTextField("总额");
		totalmoney.setBounds(320, 315, 100, 30);
		totalmoney.setFont(f);
		this.add(totalmoney);
		
		JListener listener = new JListener();
		
		ok=new JButton("合计");
		ok.setBounds(300, 440, 110, 40);
		ok.setFont(font);
		ok.addMouseListener(listener);
		this.add(ok);
		
//		exit=new JButton("取消");
//		exit.setBounds(400, 490, 110, 40);
//		exit.addMouseListener(listener);
//		this.add(exit);
	}
	
	private String[] getbussinesshall(){
		String[] city = {"北京","南京","上海"};
		return city;		
	}
	
	private int gettotal(){
		int total = 0;
		return total;
	}
	
	private class JListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource()==ok){
				totalmoney.setText(gettotal()+"");
			}
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}
