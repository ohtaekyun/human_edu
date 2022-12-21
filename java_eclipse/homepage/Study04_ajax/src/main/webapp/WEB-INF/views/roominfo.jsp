<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room Info</title>
</head>
<body>



<table id='roomList' border=1>
<tr><th>num</th><th>Room name</th><th>Room type</th><th>howmany</th><th>howmuch</th></tr>


<c:forEach var="roominfo" items="${ri }">
	<tr><td align=center>${roominfo.num }</td>
		<td align=center>${roominfo.name }</td>
		<td align=center>${roominfo.type }</td>
		<td align=center>${roominfo.howmany }</td>
		<td align=center>${roominfo.howmuch }</td>
	</tr>
</c:forEach>
</table>


<br><br>
<form id=infoControl action="/controlRoomInfo">
<input type=text name=optype id=optype value='insert'>
<table border=1>
	<tr><td>객실번호</td><td><input type=text name=roomnum id=roomnum readonly></td></tr>
	<tr><td>객실명</td><td><input type=text name=roomname id=roomname></td></tr>
	<tr><td>객실타입</td><td>
		<select id=roomtype name=roomtype>
			<c:forEach var="rtype" items="${rt }">
				<option value="${rtype.typenum }">${rtype.typename }</option>
			</c:forEach>
		</select>
	</td></tr>
	
	
	
	<tr><td>숙박가능인원</td><td><input type=number name=howmany id=howmany></td></tr>
	<tr><td>1박 요금</td><td><input type=text name=howmuch id=howmuch></td></tr>
	<tr><td colspan=2 align=center>
		<input type=button value='등록' id=btnAddNew>
		<input type=button value='삭제' id=btnDelete>
		<input type=button value='비우기' id=btnReset>
	</td></tr>	
</table>
</form>
</body>
<script src='https://code.jquery.com/jquery-3.4.1.js'></script>
<script>
$(document)
.on('click','#btnDelete',function(){
	if($('roomnum').val()=='')
		return false;
	$('#optype').val('delete');
	$('#infoControl').submit();
})
.on('click','#btnAddNew',function(){
	if($('#roomname').val()==''||$('#roomtype').val()==''||$('#howmany').val()==''||$('#howmuch').val()=='')
		return false;
	/* $('#optype').val('insert'); */
	$('#infoControl').submit();
})
.on('click','#btnReset',function(){
	$('#roomnum,#roomname,#roomtype,#howmany,#howmuch').val('');
	$('#optype').val('insert');
	return false;
})
.on('click','#roomList tr',function(){
	$('#roomnum').val($(this).find('td:eq(0)').text());
	$('#roomname').val($(this).find('td:eq(1)').text());
	$('#roomtype').val($(this).find('td:eq(2)').text());
	$('#howmany').val($(this).find('td:eq(3)').text());
	$('#howmuch').val($(this).find('td:eq(4)').text());
	$('#optype').val('update');
	return false;
})
</script>
</html>