package express.presentation.managerUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import express.presentation.mainUI.MainUIService;

public class managerExamDocUI extends JPanel{

	private JButton exam,exit;
	private MainUIService m;
	
	public managerExamDocUI(MainUIService main){
		setLayout(null);
		m = main;
		this.setBounds(0, 0,850, 700);
		this.setBackground(Color.WHITE);
		
		exam = new JButton("ExamDoc");
		exam.setBounds(100, 100, 100, 50);
		this.add(exam);
		
		exit = new JButton("exit");
		exit.setBounds(100, 200, 100, 50);
		this.add(exit);
		
		exit.addMouseListener(new Listener());
	}
	
	private class Listener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==exit){
				m.jumpTomanagerMenuUI();			
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
