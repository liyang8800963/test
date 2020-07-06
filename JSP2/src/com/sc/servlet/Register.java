package com.sc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.db.conDB;
@WebServlet("/Register")

public class Register extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	this.doPost(req, resp);
    }
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  req.setCharacterEncoding("utf-8");
    	  String name = req.getParameter("uname");
    	  String pass = req.getParameter("upass");
    	  String age = req.getParameter("uage");
    	  int uage=Integer.parseInt(age);
    	  
    	  conDB db=new conDB();
    	  String dir = "com.mysql.jdbc.Driver";
  		  String url="jdbc:mysql://127.0.0.1:3306/db190506";
  		  db.getconDb(dir, url, "root", "sasa");
  		  String sql="insert into users value(null,'"+name+"','"+pass+"',"+uage+")";
  		  db.exsql(sql);
  		  db.closes();
  		  
  		resp.setCharacterEncoding("gbk");
		PrintWriter out = resp.getWriter();
		out.print("<center><h1>¹§Ï²Äã£¬×¢²á³É¹¦!</h1></center>");
		out.close();
    }
}
