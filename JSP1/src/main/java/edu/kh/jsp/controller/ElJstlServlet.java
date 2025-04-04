package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



//@WebServlet() 소괄호 안쪽의 문자열 == 매핑될 주소
//주소 미작성시 반드시 맨앞에 "/"로 시작해야함!!
//-> 미작성시 서버가 안켜짐 (오류남)

@WebServlet("/el_jstl")
public class ElJstlServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.응답해줄 JSP파일 경로 지정하기(WEBAPP폴더 기준으로 작성하기)
		String path="/WEB-INF/views/el_jstl.jsp";
		
		//2.요청 발송자 (요청대리인) 얻어오기
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		//3.요청 위임(forward)
		dispatcher.forward(req, resp);
		
	}
}
