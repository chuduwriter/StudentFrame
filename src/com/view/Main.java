package com.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import java.awt.FlowLayout;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Button;
import java.awt.Component;
import java.awt.Color;
import java.awt.PopupMenu;

import javax.swing.JMenu;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import Model.User;

import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.MatteBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
public class Main extends JFrame{
	 DefaultMutableTreeNode node_1;
	public Main() {
		
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.light"));
		panel.setBounds(0, 0, 885, 32);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("CheckBox.background"));
		menuBar.setBounds(0, 0, 883, 33);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u7BA1\u7406");
		mnNewMenu.setForeground(UIManager.getColor("Button.shadow"));
		mnNewMenu.setBackground(UIManager.getColor("Button.light"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FDD\u5B58");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128), 3));
		panel_2.setBounds(0, 34, 885, 52);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("             \u6559\u52A1\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 35));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(167, 0, 487, 42);
		panel_2.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(2, 0, 2, 3));
		panel_4.setBounds(0, 88, 135, 453);
		getContentPane().add(panel_4);
		panel_4.setBackground(new Color(240, 248, 255));
		panel_4.setLayout(null);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("\u6B22\u8FCE\u6765\u5230\u84DD\u6865\u6559\u52A1\u7CFB\u7EDF");
		tabbedPane.setBorder(new LineBorder(new Color(220, 220, 220), 4));
		tabbedPane.setBounds(135, 96, 735, 445);
		getContentPane().add(tabbedPane);
		
		JLabel lblNewLabel_2 = new JLabel("                         \u6B22\u8FCE\u6765\u5230\u84DD\u6865\u6559\u52A1\u7CFB\u7EDF");
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_2.setFont(new Font("华文细黑", Font.PLAIN, 26));
		tabbedPane.addTab("New tab", null, lblNewLabel_2, null);
		
		JButton btnNewButton = new JButton("\u5B66\u751F\u7BA1\u7406");
		/*btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				tabbedPane.add(new StudentView(),"学生信息");
				//tabbedPane.setSelectedComponent(new Button("X"));
			}
		});*/
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentView stu=new StudentView();
				tabbedPane.add(stu);
				tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1,new JtabPanel("学生管理",stu,tabbedPane));
			}
		});
		
		btnNewButton.setBounds(0, 390, 93, 25);
		panel_4.add(btnNewButton);
		
		
	
		 DefaultMutableTreeNode node_1 = new DefaultMutableTreeNode("基本信息管理");
		 DefaultMutableTreeNode node1= new DefaultMutableTreeNode("学生信息管理");
		 node_1.add(node1);
		 node_1.add(new DefaultMutableTreeNode("教师信息管理"));
		 node_1.add(new DefaultMutableTreeNode("后勤信息管理"));
	    final JTree tree = new JTree(node_1);
	    tree.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption));
	    tree.setBackground(new Color(248, 248, 255));
	  
		tree.setBounds(0, 0, 135, 103);
		panel_4.add(tree);
		
		DefaultMutableTreeNode node_2 = new DefaultMutableTreeNode("成绩信息管理");
		node_2.add(new DefaultMutableTreeNode("增减学生成绩"));
		node_2.add(new DefaultMutableTreeNode("修改学生成绩"));
		node_2.add(new DefaultMutableTreeNode("查询学生成绩"));
		node_2.add(new DefaultMutableTreeNode("删除学生信息"));
	    JTree tree2 = new JTree(node_2);
	    tree2.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption));
	    tree.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption, SystemColor.activeCaption));
	    tree.setBackground(new Color(248, 248, 255));
	  
		tree2.setBounds(0, 107, 135, 113);
		panel_4.add(tree2);
		 tree.addTreeSelectionListener(new TreeSelectionListener() {
			 
	            @Override
	           public void valueChanged(TreeSelectionEvent e) {
	           DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
	               if (node == null)
                     return;
	               
	               Object object = node.getUserObject();
	               String string =(String) object;
	               
	               if(string.equals("学生信息管理")){
	                	StudentView stu=new StudentView();
	    				tabbedPane.add(stu);
	    				tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1,new JtabPanel("学生管理",stu,tabbedPane));
	                }
	                
	 
	                
	               
	 
	            }
	        });
		/*final JTree tree = new JTree();
		final DefaultMutableTreeNode tree1=new DefaultMutableTreeNode(new u1("学生管理"));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("\u57FA\u672C\u4FE1\u606F\u7BA1\u7406") {
				{    
					
					getContentPane().add(tree1);
					getContentPane().add(new DefaultMutableTreeNode("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406"));
					getContentPane().add(new DefaultMutableTreeNode("\u540E\u52E4\u4FE1\u606F\u7BA1\u7406"));
				}
			}
		));
		
		tree.setBorder(UIManager.getBorder("Tree.editorBorder"));
		tree.setBackground(UIManager.getColor("Button.background"));
		tree.setBounds(0, 10, 130, 106);
		panel_4.add(tree);
		
		JTree tree_1 = new JTree();
		tree_1.setBounds(0, 149, 78, 64);
		panel_4.add(tree_1);
		 tree.addTreeSelectionListener(new TreeSelectionListener() {
			 
	           
	            public void valueChanged(TreeSelectionEvent e) {
	                DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
	 
	                if (node == null)
	                    return;
	              //  node.setUserObject(StudentView.class);
	               Object object = node.getUserObject();//绑定数据的   名称  stuView.class
	                if (node.isLeaf()) {
	                	  User user = (User) object;
	                	  if(user.toString().equals("学生管理")){
	                			StudentView stu=new StudentView();
	            				tabbedPane.add(stu);
	            				tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1,new JtabPanel("学生管理",stu,tabbedPane));
	                	  }
	                	 //Class  c =(Class)object; 
	                	//tabbedPane.add(node, (JComponent)c.newInstance());
	                }
	 
	            }
	        });*/
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setBounds(0, 536, 885, 32);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u84DD\u6865\u7BA1\u7406\u6559\u52A1\u7CFB\u7EDF\u7248\u6743\u6240\u6709@\u84DD\u68652017");
		lblNewLabel_1.setFont(new Font("华文细黑", Font.PLAIN, 13));
		lblNewLabel_1.setEnabled(false);
		panel_1.add(lblNewLabel_1);
		
	}
	}

