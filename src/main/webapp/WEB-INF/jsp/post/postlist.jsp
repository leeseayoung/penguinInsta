<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타입라인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/memoInput.css"  type="text/css">
</head>
<body>

		<div id="wrap">
			<c:import url="/WEB-INF/jsp/penguinInclude/header.jsp" />
	
	
			<section class="contents d-flex justify-content-center">
			<div class="post-layout">
			
			<h1>게시글 리스트</h1>
			<table class="table">
				<thead>
					<tr>
						<th>NO</th>
						<th>제목</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<%--여기 오류  --%>
					<c:forEach var="post" items="${postList}">
						<tr>
							<td>${post.id}</td>
							<td>${post.title}</td>
							
							<td><fmt:formatDate value="${post.createdAt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
					</c:forEach>
					
				</tbody>
			
			</table>
				<div class="d-flex justify-content-end">
					<a href="/post/newpost-view" class="btn btn-secondary">글 쓰기</a>
				</div>
			</div>
		</section>
		
			<c:import url="/WEB-INF/jsp/penguinInclude/footer.jsp" />
		
		
		</div>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	


</body>
</html>