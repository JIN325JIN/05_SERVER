package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fr/forward")
public class ForwardServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//requesetScope 값 세팅
		req.setAttribute("str","안녕하세요");
		
		//jsp파일 경로 작성 (webapp폴더기준)
		
		String path = "/WEB-INF/views/fr/forward_result.jsp";
		
		//요청 발송자를 이용해서 req, resq 위임하기
		req.getRequestDispatcher(path).forward(req, resp);
		
		
	}
	
}
