package com.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Model.User;

import com.control.UserDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPanel;

public class ResView extends JFrame{
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	public ResView() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3  \u540D\uFF1A");
		lblNewLabel.setBounds(10, 31, 59, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u5BC6  \u7801\uFF1A");
		label.setBounds(10, 75, 73, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(87, 28, 164, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(87, 72, 164, 21);
		getContentPane().add(passwordField);
		
		JLabel label_1 = new JLabel("\u5BC6\u786E\u8BA4\u7801\uFF1A");
		label_1.setBounds(10, 132, 66, 15);
		getContentPane().add(label_1);
		
		
		
		JLabel label_3 = new JLabel("\u7535  \u8BDD\uFF1A");
		label_3.setBounds(10, 174, 54, 15);
		getContentPane().add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 171, 162, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		final JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setBounds(49, 216, 67, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(154, 215, 67, 25);
		getContentPane().add(btnNewButton_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(87, 127, 164, 21);
		getContentPane().add(passwordField_1);
		
		
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResView.this.dispose();
				ResView re=new ResView();
				re.setSize(480,280);
				re.setLocation(200, 300);
				re.setVisible(true);
                  
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textField.getText();
				String upass  = new String (passwordField.getPassword());
				String tel = textField_1.getText();
				//String   email = emailFiled.getText();
				//做验证 
				//
				UserDaoImpl  dao =	UserDaoImpl.getInstance();
				boolean b=dao.test(textField.getText());
				User user=new User(username,upass,tel);
				if(b){
					JOptionPane.showMessageDialog(ResView.this, "账号已经存在请重新填写");
					btnNewButton.setEnabled(false);
					ResView.this.dispose();
					ResView re=new ResView();
					re.setSize(480,280);
					re.setLocation(200, 300);
					re.setVisible(true);
				  }else{
		        		if("".equals(username)){
		        			JOptionPane.showMessageDialog(ResView.this, "账号不能为空，请输入账号！");
		        		}else if(passwordField.getText().equals(passwordField_1.getText())){
		        			
		        			JOptionPane.showMessageDialog(ResView.this, "注册成功");
		        			
		        			JLabel xs=new JLabel("");
		        			getContentPane().add(xs);
							xs.setBounds(270, 24, 180, 16);
							xs.setVisible(true);
							try{
								dao.add(user);
								
							}catch(Exception e1){
								e1.printStackTrace();
								JOptionPane.showMessageDialog(ResView.this, "出现异常，请查看");
							}
		        			//ResView.this.dispose();
		        		}else{
		        			JOptionPane.showMessageDialog(ResView.this, "两次输入密码不一致，请重新输入！");
		        		}
		        	}
					
				
			
				
				
				//JOptionPane.showMessageDialog(ResView.this, "注册成功");
				
				
				
			}
				
		});
		textField.addFocusListener(new FocusListener(){
			
			public void focusGained(FocusEvent arg0) {
			
			}
			public void focusLost(FocusEvent arg0) {
				String username=textField.getText();
				UserDaoImpl  dao =	UserDaoImpl.getInstance();
				
				//JOptionPane.showMessageDialog(ResView.this, "注册成功");
				boolean b=dao.test(username);
				if(b){
					/*JLabel lblNewLabel_1 = new JLabel("账号已经注册，请重新输入");
					lblNewLabel_1.setEnabled(false);
					lblNewLabel_1.setBounds(285, 35, 139, 18);
					panel.add(lblNewLabel_1);*/

					JLabel lblNewLabel_1 = new JLabel("账号已经注册，请重新输入");
					
					getContentPane().add(lblNewLabel_1);
					lblNewLabel_1.setBounds(285, 25, 160, 18);
					lblNewLabel_1.setVisible(true);
					//JOptionPane.showMessageDialog(resgiter.this, "账号已经注册，请重新输入");
				}else{
					
					JLabel lblNewLabel_1 = new JLabel("√");
					getContentPane().add(lblNewLabel_1);
					lblNewLabel_1.setBounds(285, 25, 160, 18);
					lblNewLabel_1.setVisible(true);
				}
			}
		});
		
	}
}
