package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/el/scope")
public class ELTestServlet2 extends HttpServlet {
	
	
	//a태그 요청은 get방식 = doGet()오버라이딩!!!!
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//요청처리
		//1.page scope -> servlet단에서는 이용못함 =>위임받음 jsp에서만 확인가능(딱 1페이지)
		//다음페이지에서는 유효하지않음 사라짐.
		
		//2.request scope -> 우리가 지금까지 이용함
		//- 요청받은 servlet과 요청이 위임된 JSP에서 유지되는 객체
		
		//1)객체에 값(속성) 추가하는 방법
		//	범위 객체.setAttribute("key","value");
		
		//2) 객체에서 값(속성) 얻어오는 방법
		//범위 객체.getAttribute("key");
		//->반환형 Object -> 필요시 다운캐스팅
		req.setAttribute("requestValue","request scope 객체에 세팅한 값");
		//requestValue = request scope 객체에 세팅한 값
		
		
		System.out.println(req.getAttribute("requestValue"));
		//request scope 객체에 세팅한값 = 현재 servlet에서 유효한 값.
		//어디까지 유효한가.
		
		
		//3.Session scope
		//-클라이언트가 서버에 첫 요청시 서버쪽에 생성되는 객체
		//-클라이언트가 브라우저를 종료하거나 지정된 세션 만료시간이 지나면 사라짐
		//-> 위 상황이 아니면 계속 유지되는 객체
		
		
		//1) session scope 객체 얻어오기
		HttpSession session = req.getSession();
		
		//2)session scoope 값 세팅해보기
		session.setAttribute("sessionValue","session scope 객체에 세팅한 값");
		
		
		//4.application scope
		//-서버 전체에 1개만 존재하는 객체
		//-> 모든 클라이언트가 공유
		//-서버 시작시 생성, 서버 종료시 소멸
		
		//1) application scope 객체 얻어오기(세션에서 얻어와도 되고, 어플리케이션에서 얻어와도 된다)
		//이름이 갑자기 바뀌어서 어렵네
		ServletContext application =req.getServletContext();
		
		//2) 값 세팅
		application.setAttribute("applicationValue","application 객체에 세팅한 값");
		
		//--------------------------------------------------------------------------
		//범위별 우선순위 확인 !!!
		//좁은 범위가 우선순위 높다!!
		//page > requeset > session > application
		
		//key값을 동일하게 하여 범위별 객체에 값 추가
		req.setAttribute("menu", "짬뽕(request)");
		session.setAttribute("menu", "짜장(session)");
		application.setAttribute("menu", "볶음밥(application)");
		
		
		
		
		
		
		//----------------------------------------------------------------------------
		//응답처리
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/scope.jsp");
	
		dispatcher.forward(req, resp);
	
	
	}
}
