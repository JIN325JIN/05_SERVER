package edu.kh.todoList.controller;

import java.io.IOException;
import java.util.Map;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//"/main" 요청을 매핑하여 처리하는 서블릿 


@WebServlet("/main")
public class MainServlet extends HttpServlet{

	
	//왜 index.jsp에서 메인페이지 코드 작성하지 않고, main요청을 처리하는 서블릿을 만들었는가?
	//-> 메인페이지에서 db에 뿌려주려고?
	
	//Servlet(backend)에서 추가한 데이터 (조회한)데이터 를 메인페이지에서 부터 사용할 수 있게 하기 위해..
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	//DB에 갔다 오는 일!
		//요청이 오면 Servlet인 controller-> service-> dao->db에서 조회한 내용을 가지고 다시 역순으로 돌아옴
		//			응답<		-view 	<-	 <- 	<-		<-
		
		
		
		TodoListService service = new TodoListServiceImpl();
		
		//전체 할일 목록 조회 + 완료된 todo 개수 
		//맵으로 담아오기
		Map<String,Object> map = service.todoListFullView();
		
		
	}
	
	
}
