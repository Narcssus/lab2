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

<title>My JSP 'books.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h2>Books:</h2>
	<s:if test="ISBN[0]==null">
		<h3>Not find!</h3>
	</s:if>
	<s:iterator value="Authorbooks" status="st">
		<s:if test="ISBN[#st.index]!=null">
			<a href="author.jsp?ISBN=<s:property value="ISBN[#st.index]" />"
				target="_blank"><s:property value="Authorbooks[#st.index]" /> </a>
			<a>click here to delete: </a>
			<a href="delete.jsp?ISBN=<s:property value="ISBN[#st.index]" />"
				target="_blank">Delete</a>
			<br />
		</s:if>
	</s:iterator>
	<h3>Click on book's name for more information!</h3>
	<a href="index.jsp?/>">Back</a>
</body>
</html>
