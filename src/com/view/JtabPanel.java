package com.view;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JtabPanel extends JPanel {
   
	   private JLabel Title_jLabel=new JLabel();
	   private JLabel Colse_JLabel=new JLabel("X");
	   
	   public JtabPanel(String title, final JComponent jco, final JTabbedPane jta){
		 
		   Title_jLabel.setText(title);
		   setLayout(new FlowLayout(FlowLayout.LEFT));
		   add(Title_jLabel);
		   add(Colse_JLabel);
		   
		    Colse_JLabel.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					jta.remove(jco);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
		    	
		    });
	   }
	   
	
	
}
