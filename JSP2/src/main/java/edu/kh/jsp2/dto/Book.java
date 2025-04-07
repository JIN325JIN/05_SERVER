package edu.kh.jsp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@Tostring()
@Data//위에 세가지를 합쳐논 (getter+setter+tostirng)
@NoArgsConstructor //기본 생성자
@AllArgsConstructor// 모든 필드 매개변수 생성자

public class Book {

	
	private String title;//제목
	private String writer;//작성자
	private int price;//가격
	
	
	//메서드 (생성자, getter/setter/toStirng())
	//롬복으로
}
