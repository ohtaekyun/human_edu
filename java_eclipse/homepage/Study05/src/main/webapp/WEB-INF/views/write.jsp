<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 작성</title>
</head>
<body>
<h1 align=center>개si판</h1>
<form id=frmInsert method=post action="/insert">
<table align=center>
<tr><td>제목</td><td><input type=text name=title id=title required></td></tr>
<tr><td>내용</td><td valign=top><textarea id=content name=content rows=10 cols=80 required></textarea></td></tr>
<tr><td colspan=2 align=center><input type=submit value='등록'>&nbsp;<input type=reset value="비우기"></td></tr>
<tr><td colspan=2 align=right><a href='/'>목록으로</a></td></tr>
</table>

</form>
</body>
<script src='https://code.jquery.com/jquery-3.4.1.js'></script>
<script>
$(document)
.on('click','submit',function(){
	$.post('/',{title:$('#title').val(),content:$('#content').val()},function(data){
		},'text');
	
	
})
</script>
</html>