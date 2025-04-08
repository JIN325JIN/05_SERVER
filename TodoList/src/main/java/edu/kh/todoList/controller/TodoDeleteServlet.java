package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/todo/delete")
public class TodoDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//할일제거
		try {
			//1.todoListServiceImple객체 생성
			TodoListService service = new TodoListServiceImpl();
			  // 2. 삭제할 할 일의 ID(번호) 파라미터로 받아오기
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
		
					
			// 3. 서비스 호출 후 결과 반환
		    int result = service.todoDelete(todoNo);
		
			//4.성공/실패 메시지 세팅하기
			String message = null;
			
			if(result> 0) message = "할일 삭제 성공!";
			else 		  message = "할일 삭제 실패...";
		
			  // 5. 세션에 메시지 저장
            HttpSession session = req.getSession();
			session.setAttribute("message", "todo가 존재하지 않습니다.");
			
			
			
			//6.메인 페이지로 리다이렉트
			resp.sendRedirect("/");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	
	}
	
	
}
