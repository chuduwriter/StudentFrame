package com.view;


import javax.swing.*;
import Model.User;
import com.control.UserDaoImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LiginView extends JFrame {
	
	private JTextField textField;
	private JPasswordField passwordField;
	public LiginView() {
		setTitle("\u5854\u91CC\u6728\u5927\u5B66\u6559\u52A1\u7BA1\u7406");
		getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		panel_3.setBounds(0, 228, 439, 35);
		getContentPane().add(panel_3);
		
		JButton 登录 = new JButton("\u767B\u5F55");
		登录.setBounds(120, 5, 65, 25);
		登录.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=textField.getText();
				String upass =new  String (passwordField.getPassword());
				UserDaoImpl  dao =	UserDaoImpl.getInstance();
				User user =dao.login1(uname, upass);
				if(user==null){
					JOptionPane.showMessageDialog(LiginView.this, "用户名密码错误");
				}else{
					JOptionPane.showMessageDialog(LiginView.this, "登录成功");
					//LiginView.this.dispose();
					Main main=new Main();
					LiginView.this.dispose();
					main.setSize(876, 600);
					main.setLocationRelativeTo(null);
				    main.setResizable(false);
			   		   //退出时关闭
					main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					main.setVisible(true);
				}
				
				
			}
		});
		panel_3.setLayout(null);
		panel_3.add(登录);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setBounds(208, 5, 73, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panel_3.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(21, 146, 58, 23);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(89, 146, 216, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(21, 195, 54, 23);
		getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(89, 195, 216, 23);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setIcon(new ImageIcon(LiginView.class.getResource("/Image/sy_63065119474.jpg")));
		lblNewLabel_2.setBounds(0, 0, 424, 139);
		getContentPane().add(lblNewLabel_2);
		
		/*JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\\u8D44\u6599\\java\\\u84DD\u6865\u9879\u76EE\u4EE3\u7801\u5B9E\u73B0\\src\\Test\\u=3777025722,1752426817&fm=117&gp=0.jpg"));
		lblNewLabel_3.setBackground(Color.ORANGE);
		lblNewLabel_3.setBounds(219, 0, 220, 147);
		getContentPane().add(lblNewLabel_3);*/
		
		JButton btnNewButton = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lostpasswd lost=new Lostpasswd();
				lost.setSize(450, 300);
			    
				lost.setLocation(300, 400);
		   		
				
				lost.setVisible(true);
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(329, 194, 75, 25);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setBounds(0, 0, 439, 139);
		getContentPane().add(lblNewLabel_4);
	}

	public static void main(String[] args) {
		
          LiginView login=new LiginView();
           login.setSize(450, 300);
    
           login.setLocation(200, 200);
   		   //退出时关闭
           login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           login.setVisible(true);
	}
}
