<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Information</title>
</head>
<body>
<h3>ID: ${user.loginid}</h3>
<h3>Password: ${user.passcode1}</h3>
<h3>이름: ${user.name}</h3>
<h3>모바일: ${user.mobile }</h3>

<input type=button value="확인" id=btnOK>

</body>
<script src='https://code.jquery.com/jquery-3.4.1.js'></script>
<script>
$(document)
.on('click','#btnOK',function(){
	document.location="/login";
})
</script>
</html>