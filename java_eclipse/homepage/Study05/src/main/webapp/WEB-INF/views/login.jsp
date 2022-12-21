<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<table align=center>
<tr><td colspan=2 align=center><h1>로그인</h1><td></tr>
<tr><td>아이디</td><td><input type=text id=userid></td></tr>
<tr><td>비밀번호</td><td><input type=password id=passcode></td></tr>
<tr><td colspan=2, align=center><input type=button value='로그인' id=btnGo></td></tr>
<tr>
	<td colspan=2 align=center style="padding:10px"><a href = '/'>홈으로</a>
	&nbsp;&nbsp;&nbsp;<a href = '/signin'>회원가입</a></td>
</tr>
</table>
</body>
<script src='https://code.jquery.com/jquery-3.4.1.js'></script>
<script>
$(document)
.on('click','#btnGo',function(){
	if($('#userid').val()==''){
		alert('아이디를 입력하세요');
		return false;
	} else if($('#passcode').val()==''){
		alert('비밀번호를 입력하세요');
		return false;
	} 
	$.post('/checkuser',{userid:$('#userid').val(),passcode:$('#passcode').val()},function(data){
		if(data=='ok'){
			document.location="/";
		} else {
			alert('로그인 실패. 아이디와 비밀번호를 정확히 입력하세요');
			$('#userid,#passcode').val('');
		}
	},'text');
	return true;
})
</script>
</html>