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
<br><br><br><br><br><br><br><br>
<table align=center>
<tr><td>아이디</td><td><input type=text name=loginid id=loginid></td></tr>
<tr><td>비밀번호</td><td><input type=password name=passcode1 id=passcode1></td></tr>
<tr><td>비밀번호확인</td><td><input type=password name=passcode2 id=passcode2></td></tr>
<tr><td>이름</td><td><input type=text name=name id=name></td></tr>
<tr><td>모바일</td><td><input type=text name=mobile id=mobile></td></tr>
<tr><td align=center colspan=2 style="padding:10px"><input type=submit value="회원가입" id=btnSubmit></td></tr>
<tr><td colspan=2, align=center style="padding:10px"><a href = '/'>홈으로</a>&nbsp;&nbsp;&nbsp;<a href = '/login'>로그인하기</a></td></tr>
</table>
</form>
</body>
<script src='https://code.jquery.com/jquery-3.4.1.js'></script>
<script>
$(document)
/* .on('submit','#frmSignin', function(){
	if($('#passcode1').val()==$('#passcode2').val()){
		return true;
	} else {
		alert('비밀번호와 확인이 일치하지 않습니다');
		return false;
	}
}) */
.on('click','#btnSubmit',function(){
	if($('#loginid').val()==''){
		alert('아이디를 입력하세요');
		return false;
	} else if($('#passcode1').val()==''){
		alert("비밀번호를 입력하세요");
		return false;
	} else if($('#passcode2').val()==''){
		alert("비밀번호 확인을 입력하세요");
		return false;
	} else if($('#name').val()==''){
		alert("이름을 입력하세요");
		return false;
	} else if($('#mobile').val()==''){
		alert("전화번호를 입력하세요");
		return false;
	} else {return true;} 
})
.on('click','#btnSubmit',function(){
	if($('#passcode1').val()==$('#passcode2').val()){
		$('frmSignin').submit();
		return true;
	} else {
		alert('비밀번호와 확인이 일치하지 않습니다');
		return false;
	}
})



</script>
</html>