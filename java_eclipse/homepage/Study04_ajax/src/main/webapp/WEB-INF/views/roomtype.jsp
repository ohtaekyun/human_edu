<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room Type</title>
</head>
<body>



<table id='tblList' border=1>
<tr><th>type number</th><th>type name</th></tr>


<c:forEach var="roomtype" items="${rt }">
	<tr><td align=center>${roomtype.typenum }</td>
		<td align=center>${roomtype.typename }</td>
	</tr>
</c:forEach>
</table>



<form id=frmControl action="/controlRoomType">
<input type=text name=optype id=optype value='insert'>
<table>
	<tr><td>Type Number</td><td><input type=text name=typenum id=typenum readonly></td></tr>
	<tr><td>Type Name</td><td><input type=text name=typename id=typename></td></tr>
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
	if($('typenum').val()=='' || $('typename').val()=='')
		return false;
	$('#optype').val('delete');
	$('#frmControl').submit();
})
.on('click','#btnAddNew',function(){
	if($('#typename').val()=='')
		return false;
	/* $('#optype').val('insert'); */
	$('#frmControl').submit();
})
.on('click','#btnReset',function(){
	$('#typenum,#typename').val('');
	$('#optype').val('insert');
	return false;
})
.on('click','#tblList tr',function(){
	let typenum = $(this).find('td:eq(0)').text();
	let typename = $(this).find('td:eq(1)').text();
	$('#typenum').val(typenum);
	$('#typename').val(typename);
	$('#optype').val('update');
	return false;
})
</script>
</html>