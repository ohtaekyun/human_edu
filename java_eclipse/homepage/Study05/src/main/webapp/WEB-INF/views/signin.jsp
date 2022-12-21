<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<table align=center>
<tr><td>아이디</td><td><input type=text name=loginid id=loginid>
	<input type=button id=btnDuplicate value='중복확인'>
	<input type=hidden id=bDuplicate>
	</td></tr>

<tr><td>비밀번호</td><td><input type=password name=passcode1 id=passcode1></td></tr>
<tr><td>비밀번호확인</td><td><input type=password name=passcode2 id=passcode2></td></tr>
<tr><td>이름</td><td><input type=text name=name id=name></td></tr>
<tr><td>모바일</td><td><input type=text name=mobile id=mobile></td></tr>
<tr><td align=center colspan=2><input type=button value="회원가입" id=btnSubmit></td></tr>
<tr><td colspan=2, align=center><a href = '/'>홈으로</a>&nbsp;&nbsp;&nbsp;<a href = '/login'>로그인하기</a></td></tr>
</table>

</body>
<script src='https://code.jquery.com/jquery-3.4.1.js'></script>
<script>
$(document)
.on('click','#btnDuplicate',function(){
	if($('#loginid').val()=='') return false;
	$.post('/checkDup',{loginid:$('#loginid').val()},function(data){
		if(data==1){
			alert('이미 사용중인 아이디입니다');
		} else {
			alert('사용가능한 아이디입니다');
			$('#bDuplicate').val('ok');
		}
		
	},'text')
	return false;
})
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
	if($('#bDuplicate').val()!="ok"){
		alert('중복 확인');
		return false;
	}
	if($('#passcode1').val()!=$('#passcode2').val()){
		alert('비밀번호와 확인이 일치하지 않습니다');
		return false;
	} 
	$.post("/viewuser",{loginid:$('#loginid').val(),passcode1:$('#passcode1').val(),
		name:$('#name').val(),mobile:$('#mobile').val()},function(data){
			console.log(data);
			if(data=='ok'){
				document.location='/login';
			} else{
				alert('회원가입 실패');
				$('#loginid,#passcode1,#passcode2,#name,#mobile,#bDuplicate').val('');
			}
		},'text');	
})

</script>
</html>