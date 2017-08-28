package com.view;


import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;




import Model.User;


import com.control.UserDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class StudentView   extends JPanel  {
	private JTable table;
	private JTextField textField;
	private String []user= new String[]{"用户名","密码","电话"};
	public StudentView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setPreferredSize(new Dimension(0,120));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名:");
		lblNewLabel.setBounds(14, 33, 72, 18);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(78, 30, 113, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 int rowNum = table.getSelectedRow();//getSelectedRow会返回给用户点中的行
				
				  //如果该用户一行都没有选，就返回-1
				 
				  if(rowNum == -1){
				  //提示
				  JOptionPane.showMessageDialog(StudentView.this , "请选中一行");
				
				  }else{
					    String name=String.valueOf(table.getValueAt(rowNum,0));
						UserDaoImpl  delete=UserDaoImpl.getInstance();
						delete.delete(name);
						JOptionPane.showMessageDialog(StudentView.this , "已经被删除");
				  }
			}
		});
		btnNewButton.setBounds(131, 80, 92, 27);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i  =table.getSelectedRow();
				String name =String.valueOf(table.getValueAt(i, 0));
				UserDaoImpl  update=UserDaoImpl.getInstance();
			     User user =update.selete(name);
				UpdateView  regView=new UpdateView(user);
				regView.setSize(400, 500);
				regView.setVisible(true);
				regView.setLocationRelativeTo(null);
				
				
			}
		});
		btnNewButton_1.setBounds(251, 80, 85, 27);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u7CBE\u51C6\u67E5\u627E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				UserDaoImpl  find1=	UserDaoImpl.getInstance();
				String [][] data =find1.jingfind(name);
				TableModel ta=new DefaultTableModel(data,user);
				table.setModel(ta);
				table.updateUI();
				
				
				
			}
		});
		btnNewButton_2.setBounds(14, 80, 92, 27);
		panel.add(btnNewButton_2);
		
		JButton button_1 = new JButton("\u589E\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ResView re=new ResView();
				re.setSize(480,280);
				re.setLocation(200, 300);
				re.setVisible(true);
				
				
				
			}
		});
		button_1.setBounds(367, 80, 85, 27);
		panel.add(button_1);
		final JScrollPane scrollPane1 = new JScrollPane();
		add(scrollPane1, BorderLayout.CENTER);
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(SystemColor.text);
		btnNewButton_3.setIcon(new ImageIcon("F:\\\u84DD\u6865\u4EE3\u7801\\JavaStu1\\src\\Image\\\u5237\u65B0 (2).png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDaoImpl  find=	UserDaoImpl.getInstance();
				String [][] data =find.find();
				TableModel ta=new DefaultTableModel(data,user);
				table.setModel(ta);
				table.updateUI();
				
			
				
			}
		});
		
		btnNewButton_3.setBounds(381, 33, 26, 24);
		panel.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		
		UserDaoImpl  find=	UserDaoImpl.getInstance();
		String [][] data =find.find();
		table = new JTable(data,user);
		
		//把表格放到滚动面板上 
		scrollPane.setViewportView(table);
	
		
	
		
	}
	
}
