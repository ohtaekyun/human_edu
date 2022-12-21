<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="/viewuser" id="frmSignin">
<table>
<tr><td>아이디</td><td><input type=text name=loginid></td></tr>
<tr><td>비밀번호</td><td><input type=password name=passcode1 id=passcode1></td></tr>
<tr><td>비밀번호확인</td><td><input type=password name=passcode2 id=passcode2></td></tr>
<tr><td>이름</td><td><input type=text name=name></td></tr>
<tr><td>모바일</td><td><input type=text name=mobile></td></tr>
<tr><td align=center colspan=2><input type=submit value="회원가입" id=btnSubmit></td></tr>
<tr><td><a href = '/'>홈으로</a></td><td align="right"><a href = '/login'>로그인하기</a></td></tr>
</table>
</form>
</body>
<script src='https://code.jquery.com/jquery-3.4.1.js'></script>
<script>
$(document)
/*.on('submit','#frmSignin', function(){
	if($('#passcode1').val()==$('#passcode2').val()){
		return true;
	} else {
		alert('비밀번호와 확인이 일치하지 않습니다');
		return false;
	}
})*/
.on('click','#btnSubmit',function(){
	if($('#passcode1').val()==$('#passcode2').val()){
		$('frmSignin').submit();
	} else {
		alert('비밀번호와 확인이 일치하지 않습니다');
		return false;
	}
})



</script>
</html>