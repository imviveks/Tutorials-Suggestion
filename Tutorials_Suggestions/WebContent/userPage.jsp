<%@page import="com.suggestions.bean.ProductType"%>
<%@page import="com.suggestions.bean.Category"%>
<%@page import="com.suggestions.bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to User Profile</h1>
 
	  <%
	    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //http 1.1
	    ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
	    ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("categoryList");
	    ArrayList<ProductType> productTypeList = (ArrayList<ProductType>)request.getAttribute("productTypeList");
	%>    
     <form action="LogoutServlet" method="post">
    <input type="submit" value="Logout" />
	</form> 
<div> 
<form action="ProcessHandlerController" method="post"> 
<label for="mydropdown" datalabel="mydropdown"> Category:</label>    
<select name="categoryId">
    <% for(int i = 0; i < categoryList.size(); i+=1) { %>
        <option value="<%=categoryList.get(i).getCategoryId()%>"><%=categoryList.get(i).getCategoryName()%></option>
    <% } %>
</select>
<br>
<label for="mydropdown" datalabel="mydropdown"> ProductType:</label>    
<select name="productTypeId">
    <% for(int i = 0; i < productTypeList.size(); i+=1) { %>
        <option value="<%=productTypeList.get(i).getProductTypeId()%>"><%=productTypeList.get(i).getProductTypeName()%></option>
    <% } %>
</select>
<input type="text" name="query" id="query" size="40" value=""> 
<input type="submit" value="Search"> 
<input type="hidden" name="search" value="1"> 
<input type="hidden" name="userType" value="user"> 
</form> 
</div> 
	
	<table>
	<% for(int i = 0; i < productList.size(); i+=1) { %>
        <tr>      
            <td><%=productList.get(i).getProductName()%></td>
        </tr>
    <% } %>
	</table>
</body>
</html>