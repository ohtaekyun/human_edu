<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX Roominfo</title>
</head>
<body>
<table align=center>
<tr><td colspan=2 align=center><h1>Hi there</h1></td>

</tr>
<tr>
	<td valign=top>
		<table id='tblList' border=1>
			<tr><th>객실번호</th><th>객실이름</th><th>객실타입</th><th>인원</th><th>요금</th></tr>
		</table>
	</td>
	
	<td valign=top>
		<input type=hidden name=optype id=optype value='insert' readonly>
		<table border=1>
			<tr><td>객실번호</td><td><input type=text name=roomnum id=roomnum readonly></td></tr>
			<tr><td>객실명</td><td><input type=text name=roomname id=roomname></td></tr>
			<tr><td>객실타입</td><td>
				<select id=roominfo name=roominfo>
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
	</td>
		
	<td>
	</td>
</tr>
</table>
</body>
<script src='https://code.jquery.com/jquery-3.4.1.js'></script>
<script>
$(document)
.ready(function(){
	loadRoomInfo();
})
.on('click','#tblList tr', function(){
   $('#roomnum').val($(this).find('td:eq(0)').text());
   $('#roomname').val($(this).find('td:eq(1)').text());
   $('#roominfo').val($(this).find('td:eq(2)').text());
   $('#howmany').val($(this).find('td:eq(3)').text());
   $('#howmuch').val($(this).find('td:eq(4)').text());
   $('#optype').val('update');
   return false;
})

.on('click', '#btnReset', function(){
   $('#roomnum, #roomname, #roominfo, #howmany, #howmuch').val('');
   $('#optype').val('insert');
   return false;
})

.on('click','#btnDelete',function(){
   if($('#roomnum').val()=='')
         return false;
   $.get("/cudRoomInfo", {optype:'delete', roomnum:$('#roomnum').val()}, function(data){
      loadRoomInfo();
      $('#btnReset').trigger('click');
   }, 'text');
   
   return false;
})

.on('click','#btnAddNew',function(){
	if($('#roomname').val()=='') return false;
	$($.get('/cudRoomInfo',
			{optype:$('#optype').val(),
			 roomnum:$('#roomnum').val(),
			 roomname:$('#roomname').val(),
			 roomtype:$('#roominfo').val(),
			 howmany:$('#howmany').val(),
			 howmuch:$('#howmuch').val()
			 },
		function(data){
			loadRoomInfo();
			$('#btnReset').trigger('click');
	},'text'));
	return false;
}) 

function loadRoomInfo(){
   $('#tblList tr:gt(0)').remove();
   $('#roominfo option:gt(0)').remove();
   $.get('/getRoomInfo', {}, function(data){
      for(i=0; i<data.length; i++) {
         let rinfo = data[i];
         let str = '<tr><td>' + rinfo['roomnum'] + 
         		   '</td><td>' + rinfo['roomname'] + 
         		   '</td><td>' + rinfo['roomtype'] +
         		   '</td><td>' + rinfo['howmany'] +
         		   '</td><td>' + rinfo['howmuch'] +
         		   '</td></tr>';
         $('#tblList').append(str);
      }
   },'json');
   $.get('/getRoomType', {}, function(data){
	   for(i=0; i<data.length; i++) {
		   let rtype = data[i];
           let str = '<option value='+rtype['typenum']+'>'+rtype['typename']+'</option>';
           $('#roominfo').append(str);
           
	   }
   }, 'json');
}

	
	
	
	
	
</script>







</html>