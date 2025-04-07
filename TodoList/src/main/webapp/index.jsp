<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- 
	"/"요청시 최상위 루트 = 메인페이지 
	index.jsp화면이 보여지겠지.
	여기서 다른 Servlet이 응답 할 수 있도록 요청 위임
	
	"/"요청이 오면 "/main" 서블릿으로 요청을 위임
	
	
 -->
<jsp:forward page ="/main"/>
