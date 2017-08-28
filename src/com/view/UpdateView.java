package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import Model.User;

import com.control.UserDaoImpl;

public class UpdateView extends JFrame{

	private JTextField textField;
	private JTextField textField1;
	private JTextField textField_1;
	public UpdateView(User user) {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setBounds(35, 24, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setBounds(35, 64, 54, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(99, 22, 161, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(user.getUname());
		textField.setEditable(false);
		
		textField1 = new JTextField();
		textField1.setBounds(99, 59, 161, 25);
		getContentPane().add(textField1);
		textField1.setText(user.getUpass());
		
		
		
		JLabel label_3 = new JLabel("  \u7535\u8BDD\uFF1A");
		label_3.setBounds(24, 108, 54, 15);
		getContentPane().add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 103, 161, 25);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(user.getTelphone());
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname =	textField.getText();
				String pass = textField1.getText();
				String tel = textField_1.getText();
			
				//做验证 
				//
				UserDaoImpl  dao =	UserDaoImpl.getInstance();
				User user=new User(uname,pass,tel);
				try{
					dao.update(user);
					JOptionPane.showMessageDialog(UpdateView.this, "修改成功");
				}catch(Exception  ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(UpdateView.this, "出现异常，修改失败");
				
				}finally{
					
				}
				
			}
				
		});
		btnNewButton.setBounds(120, 190, 70, 25);
		getContentPane().add(btnNewButton);
		
	}
	
	
}
