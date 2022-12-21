<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지</title>
</head>
<body>
<%-- <c:if test="${empty userid}">
<a href = '/login'>로그인</a>&nbsp;&nbsp;<a href = '/signin'>회원가입</a><br><br><br>
</c:if>

<c:if test="${not empty userid}">
<label>${userid }</label>&nbsp;&nbsp;<a href='/signout'>로그아웃</a><br><br>
</c:if> --%>
<%
	if(session.getAttribute("gUserid")==null){
		out.print("<a href = '/login'>로그인</a>&nbsp;&nbsp;<a href = '/signin'>회원가입</a><br><br>");
	} else{
		out.print("<label>"+session.getAttribute("gUserid")+"</label>&nbsp;&nbsp;<a href='/signout'>로그아웃</a><br><br>");
	}
%>
<h1>Welcome to my Home</h1>
</body>
</html>