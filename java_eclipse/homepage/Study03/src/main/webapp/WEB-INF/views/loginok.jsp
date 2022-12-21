<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Information</title>
</head>
<body>
<h1>로그인 성공</h1>

<H3>ID: ${user.loginid}</H3>
<H4>Password: ${user.passcode1}</H4><br><br>
<a href = '/'>홈으로</a>
</body>
</html>