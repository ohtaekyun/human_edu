<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 보기</title>
</head>
<body>
<h1 align=center>게시글</h1>
<table align='center' border=1 >

<tr><td>게시물번호</td><td><label id=lblPost_id>${getview.post_id }</label></td></tr>
<tr><td>제목</td><td><label id=lblTitle>${getview.title }</label></td></tr>
<tr><td>내용</td>
	<td valign=top><textarea id=content name=content rows=10 cols=50 readonly>${getview.content }</textarea>
	</td></tr>
<tr><td>작성자</td>
	<td><label id=lblWriter>${getview.writer }</label></td></tr>
<tr><td>작성시각</td><td>${getview.created }</td></tr>
<tr><td>수정시각</td><td>${getview.updated }</td></tr>		
<tr><td colspan=2 align=right><a href='/'>목록으로</a></td></tr>
</table>
</body>
</html>