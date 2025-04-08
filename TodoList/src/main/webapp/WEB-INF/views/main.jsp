<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List</title>
	<%--css 파일 연결 (webapp폴더 기준 경로 작성 --%>
	<link rel = "stylesheet" href ="/resources/css/main.css">
</head>
<body>
	<h1>Todo List</h1>
	<h3>전체 Todo 개수 : ${fn:length(todoList)}개/ 
	완료된 Todo 개수 : ${completeCount}개</h3>
	<hr>
	<h4>할일 추가</h4>
	<form action = "/todo/add" method="post" id ="addForm" >
		<div>
		제목 : <input type ="text" name="title">
		</div>
		<br>
		<div>
			<textarea rows="3" cols="50" name ="detail" placeholder="상세 내용 입력.."></textarea>
		</div>
		<button>추가하기</button>
	</form>
	<hr>
	<%--할일 목록 출력 --%>
	<table id ="todoList" border="1">
	<thead>
		<tr>
			<th>출력 번호</th><%--페이지 에서 보이는 용도의 단순 출력 번호 --%>
			<th>todo 번호</th><%--실제 DB에 저장된 todoNo 고유 번호 --%>
			<th>할일 제목</th>
			<th>완료 여부</th>
			<th>등록 날짜 </th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${todoList}" var="todo" varStatus="vs">
			<tr>
				<th>${vs.count}</th> <%--단순 출력 번호 --%>
				<th>${todo.todoNo}</th>
				<td>
				<%--제목 클릭시 todoNo(고유 todo번호)를 데이터로 전송 (제출)하여
				서버에서 상세내용 조회시 todoNo를 이용하게 끔 함 --%>
					<a href="/todo/detail?todoNo=${todo.todoNo}">${todo.todoTitle}</a>
				</td>
				<th>
				<c:if test="${todo.todoComplete}">O</c:if>
				<%--todo객체의 todoComplete가 true라면 O출력 --%>
				
				<c:if test="${not todo.todoComplete}">X</c:if>
				<%--todo객체의 todoComplete가 false 라면(=true가 아니라면) X출력 --%>
				
			</th>
			<td>${todo.regDate}</td>
			</tr>
			
		</c:forEach>
	</tbody>
	</table>	
	
	
	<%--session 범위에 message라는 key가 있을 경우  --%>
	<c:if test ="${not empty sessionScope.message}">
		<script>
			//JS영역
			alert("${message}");
			//JSP해석 순위 
			//1순위 : JAVA부분 (EL/JSTL)
			//2순위 : Front(HTML/CSS/JS)
			</script>
			
			<%--message를 한번만 출력하고 제거  --%>
		<c:remove var = "message" scope ="session" />
	</c:if>
	

<%--JS연결 --%>
<script src = "/resources/js/main.js"></script>
</body>
</html>