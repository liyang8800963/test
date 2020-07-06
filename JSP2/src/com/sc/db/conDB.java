package com.sc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class conDB {
	
	   Connection con;
	   Statement stat;
	
	 public Connection  getconDb(String dir,String url,String uname,String upass){
		 try {
			Class.forName(dir);
			con = 
				DriverManager.getConnection
				(url,uname,upass);	
			System.out.println("连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		 return con;
	 }
	
	
	
//	public ArrayList selectuserAll(String sql){
//		ResultSet rs ;
//		ArrayList  ar = new ArrayList();
//	  try {
//		stat=con.createStatement();
//		 rs = stat.executeQuery(sql);
//		while(rs.next()){
//			userBean user= new userBean();
//			user.setUid(rs.getInt(1));
//			user.setUname(rs.getString(2));
//			user.setUsex(rs.getString(3));
//			ar.add(user);
//		}
//		
//		rs.close();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	  
//		
//		return ar;
//	}
	
	
	public void exsql(String sql){
		try {
			stat=con.createStatement();
			stat.execute(sql);
			System.out.println("ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void closes(){
		try {
			if(!stat.isClosed()){
				stat.close();
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public void getCon(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = 
				DriverManager.getConnection
				("jdbc:mysql://127.0.0.1:3306/stut1","root","sasa");	
			Statement stat = con.createStatement();						

		    stat.close();
			con.close();
			
			System.out.println("ok");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
