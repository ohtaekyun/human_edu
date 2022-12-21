<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<br><br><br><br><br><br><br><br>
<form method="get" action="/checkuser" id=frmLogin>
<table align=center>
<tr>
<td colspan=2 align=center><h1>로그인</h1><td>
</tr>
<tr>
	<td >아이디</td><td><input type=text name=userid id=userid></td>
</tr>
<tr>
	<td >비밀번호</td><td><input type=password name=passcode1 id=passcode1></td>
</tr>
<tr>
	<td colspan=2, align=center style="padding:10px">
		<input type=submit value='로그인' >
	</td>

</tr>
<tr>
	<td colspan=2 align=center style="padding:10px"><a href = '/'>홈으로</a>&nbsp;&nbsp;&nbsp;<a href = '/signin'>회원가입</a></td>
</tr>
</table>
</form>
</body>
<script src='https://code.jquery.com/jquery-3.4.1.js'></script>
<script>
$(document)
.on('submit','#frmLogin',function(){
	if($('#userid').val()==''){
		alert('아이디를 입력하세요');
		return false;
	} else if($('#passcode1').val()==''){
		alert('비밀번호를 입력하세요');
		return false;
	} else {return true;}
})
</script>
</html>