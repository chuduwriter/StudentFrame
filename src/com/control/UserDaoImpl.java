package com.control;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import Model.User;

/**
 * �û����ݿ������

 *
 */
public class UserDaoImpl {

	private ArrayList <User>users=new ArrayList<User>(10);
	private  int size=0;
	private static UserDaoImpl  userDaoImpl=null;
	
	private UserDaoImpl(){
		User user=new User("111","111","111");
		add(user);
		
	}
	
	public  static  UserDaoImpl  getInstance(){
		if(userDaoImpl==null){
			userDaoImpl = new UserDaoImpl();
		}
		return  userDaoImpl;
	}
	 
	/**
	 * ע�᷽��
	 */
	public void  add(User user){
		users.add(user);
	}
	
	
	//��¼
	public  User  login(String uname,String upass){
		User user=null;
		
		/*for(int i=0;i<users.size();i++){
		
			if(users.get(i).getUname().equals(uname) && users.get(i).getUpass().equals(upass)){
				user = users.get(i);
				break;
			}
		}*/
	/*	for(User u:users){
			if(u!=null){
				if(u.getUname().equals(uname) &&u.getUpass().equals(upass)){
					user = u;
					break;
				}
			}
		}*/
		Iterator <User>i=users.iterator();
		while(i.hasNext()){
			User u=i.next();
			if(u!=null){
				if(u.getUname().equals(uname) &&u.getUpass().equals(upass)){
					user = u;
					break;
				}
			}
		}
		return user;
		
	}
		
	public  User  login1(String uname,String upass){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test1";
		String user = "root"; 
		String password = "123456";
	    User user1 =null;
		Connection conn=null;
		try {        
			
		     Class.forName(driver);
		   
		     conn= (Connection) DriverManager.getConnection(url, user, password);
		     System.out.println("Succeeded connecting to the Database!");
		     
		     Statement statement = (Statement)conn.createStatement();
		     String sql="select * from user where username='"+uname+"' and passwd='"+upass+"' ";        
		      ResultSet rs=statement.executeQuery(sql);
		      if(rs.next()){
		    	  String name=rs.getString("username");
		    	  String passwd=rs.getString("passwd");
		    	  String tel=rs.getString("telephone");
		    	  user1=new User(name,passwd);	  
		      }
		  }catch(Exception e) {
		         e.printStackTrace();
		  } finally {
			  if(conn !=null){
				  try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		     }
		  }
		return user1;
	}
	//�ж�
	public boolean test(String nname){
		boolean b=false;
		for(int i=0;i<users.size();i++){
			//System.out.println("111");
			if(users.get(i).getUname().equals(nname)){
			    b=true;
				break;
				
			}
		}
		return b;
	}
	
	public User getTel(String nname,String tel){
		User user=null;
		for(int i=0;i<users.size();i++){
			//System.out.println("111");
			if(users.get(i).getUname().equals(nname)&&users.get(i).getTelphone().equals(tel)){
			    user=users.get(i);
				break;
			}
		}
		return user;
	}
 
	public    String [][]   find(){
		String [][]  data=new String[users.size()][4];
		int index=0;
		for(int i=0;i<users.size();i++){
			if(users.get(i)!=null){
				data [index][0]=users.get(i).getUname();
				data [index][1]=users.get(i).getUpass();
				data [index][2]=users.get(i).getTelphone();
				index++;
			}
		}
		return data;
	}
	
	public    String [][]   jingfind(String name){
		
		String [][]  data=new String[users.size()][4];
		int index=0;
		for(int i=0;i<users.size();i++){
		
			if(users.get(i).getUname().equals(name)){
				
				data [index][0]=users.get(i).getUname();
				data [index][1]=users.get(i).getUpass();
				data [index][2]=users.get(i).getTelphone();
				index++;
				
				
			}
			
			
		}
		return data;
	}
	
	//ѡ��ɾ��
	public void delete(String name){
		
		for(int i=0;i<users.size();i++){
			
			if(users.get(i)!=null)
				if(users.get(i).getUname().equals(name)){
					users.remove(i);
					break;
				    
			}
			     
	     }
	}
	//�õ��û�
	public  User   selete(String uname){
		User user=null;
		for(int i=0;i<users.size();i++){
			
			if(users.get(i)!=null){
				if(users.get(i).getUname().equals(uname)){
					user=users.get(i);
					break;
				}
			}
			
		}
		return user;
		
	}
	//����
	public void update(User user){
		for(int i=0;i<users.size();i++){
			
			if(users.get(i).getUname().equals(user.getUname())){
				users.remove(i);
				users.add(user);				
				break;
			}
		}
	}
   }


