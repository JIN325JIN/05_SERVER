package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/todo/update")
public class updateServlet extends HttpServlet{

	
	//수정화면 전환 GET 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
	
			//수정 화면에는 기존의 제목, 상세내용이 input,textarea에 채워져 있는 상태
			//수정 전 제목/내용 조회 == 현재 todo에 저장되어있는 상세 조회 서비스 재호출
			
			
			
			//요청시 전달 받은 파라미터 얻어오기
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			//서비스 객체 생성
			TodoListService service = new TodoListServiceImpl();
			
			//알맞은 서비스 호출 후 결과 반환 받기
			Todo todo = service.todoDetail(todoNo);
			
			if(todo==null) {
				//메인 페이지 redirect 
				resp.sendRedirect("/");
				return;
			}
			//request scope 에 todo 객체 세팅
			//forward해야됨 : 수정페이지로 이동시켜줘!
			req.setAttribute("todo", todo);
			
			//요청 발송자를 통해 forward
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		}

	
	
	
	
	/*
	 * 요청 주소가 같을 때
	 * 데이터 전달(제출) 방식이 다르면 (GET/POST)
	 * 하나의 서블릿 클래스에서 각각의 메서드 (doGet()/doPost())를 
	 * 만들어 처리 할 수 있다.*/
	
	
	//할일 제목 / 내용 수정 POST 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//전달 받은 파라미터 3개 얻어오기 ( 제목, 상세내용, todoNo)
			String title = req.getParameter("title");
			String detail = req.getParameter("detail");
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			TodoListService service = new TodoListServiceImpl();
			int result = service.todoUpdate(todoNo,title,detail);
			
			//수정 성공시 상세조회 페이지로 redirect
			//alert창에 "수정되었습니다"message 출력
			
			//수정 실패시 수정화면으로 redirect
			//alert창에 "수정 실패" message출력
			
			String url = null;
			String message = null;
			
			if(result>0) {
				//성공
				url = "/todo/detail?todoNo="+todoNo;
				message = "수정 되었습니다.";
				
			}else {
				// 실패
				url = "/todo/update?todoNo="+todoNo;
				message = "수정 실패";
			}
			//session 객체에 message속성 추가
			req.getSession().setAttribute("message", message);
			
			//redirect 는 get방식 요청
			resp.sendRedirect(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
