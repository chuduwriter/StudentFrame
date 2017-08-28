package com.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import Model.User;

import com.control.UserDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lostpasswd extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public Lostpasswd() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(29, 68, 68, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("         \u9A8C\u8BC1\u8D26\u6237\u624B\u673A\u53F7");
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setBounds(91, 22, 257, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_2.setBounds(29, 127, 54, 15);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(107, 71, 217, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 124, 217, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=textField.getText();
				String tel=textField_1.getText();
				
				UserDaoImpl  gettel =	UserDaoImpl.getInstance();
				User users=gettel.getTel(uname, tel);
				
				
				if(users!=null){
					JOptionPane.showMessageDialog(Lostpasswd.this, "验证成功,已经为你重置密码：123456");
					users.setUpass("123456");
				}else{
					JOptionPane.showMessageDialog(Lostpasswd.this, "登录失败，请重新输入");
					textField.setText("");
					textField_1.setText("");
				}
				
			}
			
		});
		button.setBounds(101, 201, 95, 25);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(229, 201, 95, 25);
		getContentPane().add(button_1);
	}
}
