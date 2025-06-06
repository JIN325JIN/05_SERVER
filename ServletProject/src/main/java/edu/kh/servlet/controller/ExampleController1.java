package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * import jakarta.servlet.http.HttpServlet
 * -> http 프로토콜 서비스를 지원하는 추상 클래스
 * -> 상속 받아서 사용
 * 
 * 
 * [servlet 등록 절차]
 * 1.web.xml에 직접 작성하는 방법
 * 
 * 2.@webServlet() 어노테이션 이용 방법
 * 
 * */


//"example1"이라는 클라이언트의 요청을 받아서 처리한 후 응답을 해줄
//서블릿 클래스 ExampleController1를 만든다.


//Controller: 요청(Request)에 따라 어떤 Service를 호출할지 "제어"하고,
//어떻게 응답(Response)을 할지 "제어"하는 역할.
public class ExampleController1 extends HttpServlet{

	//doGet()메서드
	//-> GET방식 요청을 처리하는 메서드
	//HTTPServlet의 메서드를 오버라이딩 하여 사용
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//HttpServletRequest
		//-클라이언트 요청시 생성되는 객체 
		//- 요청 시 전달된 데이터, 요청한 클라이언트의 정보, 유연한 요청 처리를 하기위한
		//객체를 제공하는 것.
		
		
		//HttpServletResponse
		//-클라이언트 요청 시 생성되는 객체
		//-서버가 클라이언트에게 응답하기 위한 방법을 제공함
		//서버 -> 클라이언트로 연결된 출력용 스트림 제공 (printWriter)
		
		System.out.println("--이름, 나이를 입력받아 처리하는 서블릿 코드---");
		
		//요청시 입력된 이름, 나이를 전달받아오기
		
		//parameter: 매개변수 == 다른곳의 값을 전달 받아 올 때 사용
		
		//req.getParameter("name 속성 값 ");
		//-> 요청 시 전달 된 데이터 중 
		//name속성 값이 일치하는 데이터의 value를 얻어와 String형태로 반환
		
		
		//!!! HTML에서 얻어오는 모든 값은 String !!!
		String name = req.getParameter("inputName");
		String age = req.getParameter("inputAge");
		
		System.out.println("입력받을 이름 : "+name);
		System.out.println("입력받을 나이 : "+age);
		
		
		//-----------------------------------------------
		//서버-> 클라이언트 응답 처리 
		
		
		//1.서버에서 HTML코드를 만들어 클라이언트 에게 전달 ==응답(response)
		
		//2. 클라이언트의 브라우저가 응답 받은 HTML 코드를 해석하여 화면에 출력해줌
		
		//서버-> 클라이언트 응답하기
		//HTTPServletResponse객체 이용
		
		//응답처리 1번째 과정 : 응답하는 문서의 형식과 문자 인코딩 지정
		resp.setContentType("text/html; charset=UTF-8");
		
		//응답처리 2번째 과정 : 서버 -> 클라이언트로 연결되는 출력용 스트림 얻어오기
		PrintWriter out = resp.getWriter();
		
		//응답처리 3번재 과정 : 출력할 HTML코드 만들기
		StringBuilder sb = new StringBuilder();
		
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");                             
		sb.append("<head>");
		sb.append("<title>서버 응답 페이지</title>");
		sb.append("</head>");
		
		sb.append("<body>");
		sb.append("<h1>응답페이지 입니다.</h1>");
		sb.append("<p>입력 받을 이름 : "+ name + "</p>");
		sb.append("<p>입력 받을 나이 : "+ age + "</p>");
		sb.append("</body>");
		
		sb.append("</html>");
		
		//응답처리 4번째 과정 : 출력 스트림을 이용해 클라이언트에게 HTML코드 출력 (응답)
		
		out.write(sb.toString());
	}
}
