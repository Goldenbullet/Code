package express.presentation.customUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import express.businessLogic.searchBL.Search;
import express.businesslogicService.customerBLService.SearchBLService;
import express.vo.GoodTransStatusVO;

public class ResultUI {
	private SearchBLService sbs;
	JButton confirm=new JButton(new ImageIcon("picture/search1.png"));
	JButton exitbutton= new JButton(new ImageIcon("picture/x.png"));
	String orderID;
	JLabel status1=new JLabel("状态1");
	JLabel status2=new JLabel("");
	JLabel status3=new JLabel("");
	JLabel status4=new JLabel("");
	JLabel status5=new JLabel("");
	JLabel status6=new JLabel("");
	JLabel status7=new JLabel("");
	
	
	JLabel time1=new JLabel("");
	JLabel time2=new JLabel("");
	JLabel time3=new JLabel("");
	JLabel time4=new JLabel("");
	JLabel time5=new JLabel("");
	JLabel time6=new JLabel("");
	JLabel time7=new JLabel("");
	
	
	
	
	
	public JPanel getResult(){
		MyDrawPanel2 pane=new MyDrawPanel2();
		pane.setLayout(null);
		pane.setBackground(Color.WHITE);
		
		
		final JPanel buttonPanel = new JPanel();  
		buttonPanel.setBackground(null);                      // 把背景设置为会  
		buttonPanel.setOpaque(false); 
		buttonPanel.setLayout(null);
		buttonPanel.setSize(820,550);
		pane.add(buttonPanel);
		confirm.setSize(36,36);
		confirm.setLocation(537, 29);
		confirm.setBorderPainted(false);
		buttonPanel.add(confirm);
		
		JTextField orderid= new JTextField();
		orderid.setSize(570,48);
		orderid.setLocation(10,23);
		pane.add(orderid);
		

		exitbutton.setSize(30,30);
		exitbutton.setBorderPainted(false);
		exitbutton.setLocation(790,0);
		pane.add(exitbutton);
		
		status1.setSize(150,15);
		status1.setLocation(50,208);
		pane.add(status1);
		
		
		exitbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		
		
		
		
		return pane;
	}
	
	
	public boolean checkOrder(String orderid){
		sbs=new Search();
		return true;
		
//		GoodTransStatusVO vo=new GoodTransStatusVO();
//		vo=sbs.getOrderIDStatus(orderid);
//		if(vo==null){
//			return false;
//		}
//		else {
//			
//			
//			
//			
//			
//			
//			
//			return false;
//		}
//		
		
		
		
	}
	
}
class MyDrawPanel2 extends JPanel{
	public void paintComponent(Graphics g){
		Image image=new ImageIcon("picture/result.png").getImage();
		g.drawImage(image,0,0,this);
}
}