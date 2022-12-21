<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEpartment</title>
</head>
<body>



<table>
<tr><th>부서ID</th><th>부서명</th><th>관리자</th><th>총괄부서</th></tr>

<c:forEach var="department" items="${dp }">

	<tr><td>${department.department_id }</td>
		<td>${department.department_name }</td>
		<td>${department.emp_name }</td>
		<td>${department.parent_name }</td>
	</tr>
</c:forEach>

</table>



</body>
</html>