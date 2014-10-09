<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
   function valid(){
     var ISBN = document.getElementById("ISBN").value;
     var AuthorID = document.getElementById("AuthorID").value;
     var Title = document.getElementById("Title").value;
     var Publisher = document.getElementById("Publisher").value;
     var PublishDate = document.getElementById("PublishDate").value;
     var Price = document.getElementById("Price").value;
     var Name= document.getElementById("Name").value;
     var Age = document.getElementById("Age").value;
     var Country = document.getElementById("Country").value;
	 var reg =  /^[1-9]+[0-9]*]*$/;
     if(ISBN==""){
        alert("Please input ISBN");
        return false;
     }
     if(AuthorID==""){
        alert("Please input AuthorID");
        return false;
     }
      if(Title==""){
        alert("Please input Title");
        return false;
     }
      if(Publisher==""){
        alert("Please input Publisher");
        return false;
     }
      if(PublishDate==""){
        alert("Please input PublishDate");
        return false;
     }
      if(Price==""){
        alert("Please input Price");
        return false;
     }
      if(Name==""){
        alert("Please input Name");
        return false;
     }
      if(Age==""){
        alert("Please input Age");
        return false;
     }
      if(Country==""){
        alert("Please input Country");
        return false;
     }
     if(reg.test(Price)==false){
     	alert("Please input right Price");
        return false;
     }
     if(reg.test(Age)==false){
     	alert("Please input right Age");
        return false;
     }
     return true;
   }
</script>

</head>

<body>
	<h2>Please input the information of book and author:</h2>
	<s:form id="updatebook" action="updatebook">
		<table border="1">
			<tr>
				<th>ISBN*:</th>
				<th><input type="text" name="ISBN" size=10>
				</th>
			</tr>
			<tr>
				<th>AuthorID*:</th>
				<th><input type="text" name="AuthorID" size=10></th>
			</tr>
			<tr>
				<th>Title:</th>
				<th><input type="text" name="Title" size=10></th>
			</tr>
			<tr>
				<th>Publisher:</th>
				<th><input type="text" name="Publisher" size=10></th>
			</tr>
			<tr>
				<th>PublishDate:</th>
				<th><input type="text" name="PublishDate" size=10></th>
			</tr>
			<tr>
				<th>Price:</th>
				<th><input type="text" name="Price" size=10></th>
			</tr>
			<tr>
				<th>Name:</th>
				<th><input type="text" name="Name" size=10></th>
			</tr>
			<tr>
				<th>Age:</th>
				<th><input type="text" name="Age" size=10></th>
			</tr>
			<tr>
				<th>Country:</th>
				<th><input type="text" name="Country" size=10></th>
			</tr>

		</table>
		<input type="submit" value="submit" onclick ="return valid();">
	</s:form>
</body>
</html>
