package edu.kh.todoList.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getter,setter,toString
@AllArgsConstructor
@NoArgsConstructor
@builder

public class Todo {

	private int todoNo;	//todo 번호
	private String todoTitle;//todo제목
	private String todoDetail;//todo 상세내용
	private boolean todoComplete;// todo 완료여부
	private String regDate; // todo 등록일
}
