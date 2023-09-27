<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포스트 타임 라인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/memoInput.css"  type="text/css">
</head>
<body>

		<div id="wrap">
			<c:import url="/WEB-INF/jsp/penguinInclude/header.jsp" />
	
	
			<section class="contents d-flex justify-content-center">
				
				<div class="col-3"></div>
				
				<!-- 타임라인 -->
				<div class="timeline col-6">
					<!-- 입력 상자 -->
					<div class="input-box border reounded mt-4">
						
						<textarea class="from-control border-0" rows="4" id="textareaInput"></textarea>
						<div class="d-flex justify-content-between">
							<input type="file" id="fileInput">
							<button type="button" class="btn btn-info" id="saveBtn">입력</button>
						</div>
					
					</div>
					<!-- /입력상자 -->
					
					<!-- 카드 리스트 -->
					<div class="card-list pt-2">
						<c:forEach var="post" items="${postList}">
						<!-- 카드 -->
						<div class="card">
							<div class="d-flex justify-content-between p-2">
								<div>${post.userId }</div>
								<i class="bi bi-three-dots-vertical"></i>
							
							</div>
							
							<div>
								<img width="100%" src="${post.imagePath}">
							</div>
							<div class="p-2">
								<i class="bi bi-heart"></i>
								좋아요11개
							</div>
						
							<div class="p-2">
								<b>${post.userId}</b> ${post.content}
							</div>
							
							
								<!-- 댓글 목록 -->
								<div class="comment-box">
									<div>댓글</div>
									<div class="pl-2"><b>pdjkkh12</b> 진짜 귀엽다!</div>
									<div class="pl-2"><b>asd123</b> 새가!</div>
								<div class="d-flex">
									<input type="text" class="form-control" id="textInput">
									<button type="button" class="btn btn-info" id="">게시</button>
								</div>
								
								
								</div>
								<!-- /댓글 목록 -->
				
						</div>
						<!-- /카드 -->
						</c:forEach>
					</div>
					<!-- /카드 리스트 -->
				
				
				</div>
				<!-- /타임라인 -->
				
				
				<div class="col-3"></div>
			
			</section>
			
		
			<c:import url="/WEB-INF/jsp/penguinInclude/footer.jsp" />
		
		
		</div>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script>
	
	
		$(document).ready(function() {
			$(#"saveBtn").on("click", function() {
				
				
				
				let textarea = $("#textareaInput").val();
				// 파일에 대한 유효성 검사
				
				
				if(textarea= "") {
					alert("제목을 입력하세요");
					return ;
				}
				
				
				let formData = new ForData();
				formData.append("content", content);
				formData.append("imageFile", file.files[0]);
				
				
				%.ajax({
					type:"post"
					, url:"/post/create"
					, data:formData
					, enctype:"multipart/form-data"  // 파일 업로드 필수 옵션
					, processData:false  // 파일 업로드 필수 옵션
					, contentType:false   // 파일 업로드 필수 옵션
					, success:function(data) {
						
						if(data.result == "success") {
							location.reload();
						} else {
							alert("글쓰기 실패");
						}
						
						}
						
					}
					, error:function() {
					alert("메모 작성 에러");
					}
						
				});
				
				
			});
			
			
			
		});
		
	
	
	
	</script>
		
	
	


</body>
</html>