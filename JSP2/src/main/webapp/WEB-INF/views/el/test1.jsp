<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 확인1 </title>
</head>
<body>
	<h3>전달받은 파라미터 출력하기</h3>
	<pre>
	- /${param.key}: key 일치하는 파라미터 얻어오기
	- /${paramValues.key} : key 일치하는 파라미터 모두 얻어오기
	
	
	</pre>
	
	<h4>존재하는 파라미터 얻어오기</h4>
	<p>EL구문으로 str 파라미터 얻어오기 :
	${param.str}</p>
	
	<h4>존재하지 않는 파라미터 얻어오기</h4>
	<p>EL구문으로 temp 파라미터 얻어오기 : 
	${param.temp}</p>
	
	
	<h3>EL은 자료형 변환을 자동 수행 해준다</h3>
	

	<ul>
	<!-- EL은 문자열비교 ==(연산자) 사용가능 -->
	<li>${param.str=="abc"}</li>
	<!-- HTML에서 얻어온 데이터는 모두 String형
	하지만 EL에서 연산되는 자료형이 다를 경우
	자동으로 자료형 반환 진행해서 비교해준다!
	 -->
	<li>${param.intNum==100}</li>
	<li>${param.doubleNum==3.14}</li>
	</ul>
	<hr>
	<h3>같은 key값을 지닌 파라미터 얻어오기</h3>
	<ul>
	<!-- 여러개의 값이 중복으로 넘어오는 경우 
	(check박스의 체크가 여러개 전달된 경우)
	첫번째로 넘어오는 value값(=첫번째 파라미터 값)이 출력 -->
		<li>param.check: ${param.check}</li>
		<li> 
		<%--check라는 key를 가진 모든 파라미터 값을 모아 String[]로 반환 --%>
			paramValues.check : ${paramValues.check}<%--배열의 주소값 출력 --%>
		</li>
	
	<li>paramValues.check[0]:${paramValues.check[0]}</li>
	<li>paramValues.check[1]:${paramValues.check[1]}</li>
	<li>paramValues.check[2]:${paramValues.check[2]}</li>
	</ul>
	
</body>
</html>