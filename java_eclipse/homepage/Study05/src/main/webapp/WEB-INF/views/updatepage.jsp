<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<body>
<h1 align=center>글 수정</h1>

<form id=frmInsert method=post action="/modify">
<table align='center' border=1>
<tr><td>게시물번호</td><td><input type=text id=post_id name=post_id value='${getupdate.post_id }' readonly></td></tr>
<tr><td>제목</td><td><input type=text id=title name=title value='${getupdate.title }'></td></tr>
<tr><td>내용</td>
	<td valign=top><textarea id=content name=content rows=10 cols=50>${getupdate.content }</textarea>
	</td></tr>
<tr><td>작성자</td>
	<td><input type=text value=${getupdate.writer } readonly></td></tr>
<tr><td>작성시각</td><td><label>${getupdate.created }</label></td></tr>
<tr><td>수정시각</td><td><label>${getupdate.updated }</label></td></tr>
<tr><td colspan=2 align=center><input type=submit value='수정'>&nbsp;<input type=reset value='BE우기'><button style="width=50px; height=50px"></button></td></tr>			
<tr><td colspan=2 align=right><a href='/'>목록으로</a></td></tr>
</table>
</form>

</body>
<script src='https://code.jquery.com/jquery-3.4.1.js'></script>
<script>
$(document)
.on('click','#btnUpdate',function(){
	$.post('/modify',{post_id:$('#post_id').val(),title:$('#title').val(),content:$('#content').val()}
			,function(data){document.location='/'},'text')
})
.on('click','#btnReset',function(){
		$('#title').val('')
		$('#content').val('')
})

</script>
</html>