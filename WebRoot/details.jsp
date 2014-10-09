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

<title>My JSP 'details.jsp' starting page</title>

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
	<h2>Author's information:</h2>
	<s:form id="form3">
		<s:iterator value="Names" status="st">
			<s:if test="Names[#st.index]!=null">
			Name:<s:property value="Names[#st.index]" />
			Age:<s:property value="Ages[#st.index]" />
			Country:<s:property value="Countrys[#st.index]" /><br />
			</s:if>
		</s:iterator>
		<br>
		<h2>Book's information:</h2>
		ISBN:<s:property value="ISBN" />
		<br />
		AuthorID:<s:property value="AuthorID" /><br />
		Title:<s:property value="Title" /><br />
		Publisher:<s:property value="Publisher" /><br />
		PublishDate:<s:property value="PublishDate" /><br />
		Price:<s:property value="Price" /><br />
	</s:form>
	<a href="javascript:window.opener=null;window.open('','_self');window.close();">Close</a>
</body>
</html>
