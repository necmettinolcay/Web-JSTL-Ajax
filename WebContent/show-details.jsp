<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml" %>
<students>
  <headings>
    <heading>Id</heading>
     <heading>Ad</heading>
      <heading>Ders</heading>
  </headings>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="index" items="${center}">
   <student>
    <id>${index.id}</id>
    <name>${index.name}</name>
    <lesson>${index.lesson}</lesson>
  </student>
 </c:forEach>
</students>