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

<title>My JSP 'index.jsp' starting page</title>
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
     var name = document.getElementById("name").value;
      if(name==""){
        alert("Please input Author's name");
        return false;
     }
	     return true;
   }
</script>
</head>

<body>
	<font size=7 ><b>Library</b></font>
	<h3>Please input the Author's name to search:</h3>
	<h2>
		<s:form action="books">
	Name: <s:textfield name="name" />
			<s:submit value="submit" onclick="return valid();"/>
		</s:form>
	</h2>
	Add one book:
	<a href="addbook.jsp?addbook=1/>">AddBook</a>
	<br /> Update one book:
	<a href="updatebook.jsp?updatebook=1/>">UpdateBook</a>
</body>
</html>
