<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% ResultSet resultset =null;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>Ajax: Veri İşleme</title>
<link rel="stylesheet"
      href="./css/styles.css"
      type="text/css"/>
<script src="./scripts/ajax-utils.js"
        type="text/javascript"></script>
<script src="./scripts/ajax-data.js"
        type="text/javascript"></script>
</head>
<body>
  <div align="center">
    <fieldset>
      <legend>Ondokuz Mayıs Üniversitesi </legend>
       <form action="#">
        <label for="ogrenci">Öğrenci Ad:</label>
        <select id="ogrenciID">
       <%
       try{
           Class.forName("com.mysql.jdbc.Driver").newInstance();
		   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?user=root&password=7056");
       	   Statement statement = connection.createStatement() ;
           resultset =statement.executeQuery("select * from togrenci") ;
     	   while(resultset.next()){ %>
           <option value="<%=resultset.getString("ogrenciID")%>"><%= resultset.getString("ad")%></option>
     	<% } 
       } catch(Exception e) {
         out.println("wrong entry"+e);
       } %>
     	</select>
   		<br/>
   		<br/>
   		<input type="button" value="Göster"
          onclick='xmlStudentTable("ogrenciID", "student-table")'/>
  	   </form>
  	   <p/>
   	   <div id="student-table"></div>
    </fieldset>
  </div>
</body>
</html>