<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
	
		
		<header class="d-flex">
			<div id="h1" class="col-3">
			 	<img height="100%" src="https://media.istockphoto.com/id/1498663231/ko/%EB%B2%A1%ED%84%B0/%EA%B7%80%EC%97%AC%EC%9A%B4-%EB%A8%B8%EB%A6%AC-%ED%8E%AD%EA%B7%84-%EB%A7%8C%ED%99%94-%EB%B0%B0%EB%84%88.jpg?s=1024x1024&w=is&k=20&c=Fu64LmvpVbtrDfXhXNOWpzMwlDni3JEfkYLLOCZWHBA=">
			
			</div>
			
			<div id="h2" class="col-6 pt-5">
			<h1 class="text-center">penguinInsta</h1></div>
			
			<div id="h3" class="col-3 d-flex justify-content-center align-items-center pb-1">
			<c:if test="${not empty userId}">
			<div class="mr-3">${userName}님 <a href="/user/logout">로그아웃</a></div>
			</c:if>
			</div>
		</header>