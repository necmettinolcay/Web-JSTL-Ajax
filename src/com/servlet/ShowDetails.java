package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@WebServlet("/ShowDetails")
public class ShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache");
	        response.setHeader("Pragma", "no-cache");
		String ogrenciID = request.getParameter("ogrenciID");
		String format = request.getParameter("formar");
		ResultSet resultset = null;
		String outputPage;
		String id = null,ad = null,ders = null;
		ArrayList<StudentBean> center = new ArrayList<StudentBean>();
		
		try{
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?"
				+ "user=root&password=7056");
	        Statement statement = connection.createStatement() ;
	        resultset = statement.executeQuery("select togrenci.ogrenciID, togrenci.ad, tders.dersAd from "
	        	+ "togrenci,tders,togrenciders "
	        	+ "where togrenci.ogrenciID=togrenciders.ogrenciID "
	        	+ "and tders.dersID=togrenciders.dersID and togrenci.ogrenciID="+ogrenciID) ;
	        
	        while(resultset.next()){
	        	id = resultset.getString("togrenci.ogrenciID");
	        	ad = resultset.getString("togrenci.ad");
	        	ders = resultset.getString("tders.dersAd");
	        	
	        	StudentBean bean = new StudentBean();
	        	bean.setID(id);
	        	bean.setName(ad);
	        	bean.setLesson(ders);
	        	center.add(bean);
	        } 
	        } catch (Exception ex) {
	        	System.out.print(ex);
	    	}
		request.setAttribute("center", center );
		request.getServletContext().getRequestDispatcher("/show-details.jsp").
		forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
