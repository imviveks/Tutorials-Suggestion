<%@page import="com.suggestions.bean.ProductType"%>
<%@page import="com.suggestions.bean.Category"%>
<%@page import="com.suggestions.bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%
	    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //http 1.1
	    ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
	    ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("categoryList");
	    ArrayList<ProductType> productTypeList = (ArrayList<ProductType>)request.getAttribute("productTypeList");
	%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 Welcome to Admin Page
<form action="ProcessHandlerController" method="post">
    <input type="button" value="categoryName" />
    <input type="text" name="categoryName" size="20">
    <br><br>
    <input type="button" value="productTypeName" />
    <input type="text" name="productTypeName" size="20">
    <br><br>
    <input type="button" value="productName" />
    <input type="text" name="productName" size="20">
    <label for="mydropdown" datalabel="mydropdown"> Category:</label>    
<select name="categoryId">
    <% for(int i = 0; i < categoryList.size(); i+=1) { %>
        <option value="<%=categoryList.get(i).getCategoryId()%>"><%=categoryList.get(i).getCategoryName()%></option>
    <% } %>
</select>

<label for="mydropdown" datalabel="mydropdown"> ProductType:</label>    
<select name="productTypeId">
    <% for(int i = 0; i < productTypeList.size(); i+=1) { %>
        <option value="<%=productTypeList.get(i).getProductTypeId()%>"><%=productTypeList.get(i).getProductTypeName()%></option>
    <% } %>
</select>
<br><br>
<input type="submit" value="Submit">
<br><br>
<input type="hidden" name="userType" value="admin"> 
</form>
 <form action="LogoutServlet" method="post">
    <input type="submit" value="Logout" />
</form>


<%
 response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		%>
	
    
</form> 
</body>
</html>