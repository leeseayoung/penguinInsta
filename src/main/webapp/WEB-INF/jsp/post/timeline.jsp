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
					<div class="input-box border rounded mt-4">
						
						<textarea class="from-control border-0" rows="4" id="contentInput"></textarea>
						<div class="d-flex justify-content-between p-2">
							<input type="file" id="fileInput">
							<button type="button" class="btn btn-info btn-sm" id="addBtn">입력</button>
						</div>
					
					</div>
					<!-- /입력상자 -->
					
					<!-- 카드 리스트 -->
					<div class="card-list pt-2">
						<c:forEach var="post" items="${postList}">
						<!-- 카드 -->
						<div class="card">
							<div class="d-flex justify-content-between p-2">
								<div>${post.loginId}</div>
								<i class="bi bi-three-dots-vertical" data-toggle="modal" data-target="#exampleModal"></i>
							
							</div>
							
							<div>
								<img width="100%" src="${post.imagePath}">
							</div>
							<div class="p-2">
							 	<c:choose>
							 		<c:when test="${post.like}">
							 			<i class="bi bi-heart-fill text-danger"></i>
							 		</c:when>
							 		<c:otherwise>
										<i class="bi bi-heart like-Icon"></i>
							 		
							 		</c:otherwise>
							 	</c:choose> 
							 	
								좋아요 ${post.likecount}개
							</div>
						
							<div class="p-2">
								<b>${post.loginId}</b> ${post.content}
							</div>
							
							
								<!-- 댓글 목록 -->
								<div class="comment-box">
									<div class="px-2">댓글</div>
									<div class="px-2">
										<c:forEach var="comment" items="${post.commentList }">
										<div><b>${comment.loginId}</b> ${comment.content }</div>
										</c:forEach>
									</div>
									
								<div class="d-flex">
									<input type="text" class="form-control" id="commentInput${post.id}">
									<button type="button" class="btn btn-info comment-btn" data-post-id="${post.id}">게시</button>
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

			
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        삭제하기
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			        <button type="button" class="btn btn-danger" id="deleteBtn" data-post-id="${post.id}">삭제하기</button>
			      </div>
			    </div>
			  </div>
			</div>
		
		
		</div>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function() {
			
			$("#deleteBtn").on("click", function () {
				
				
				
			});
			
			
			
			
			
			
			
			
			
			$(".comment-btn").on("click", function () {
				
				let postId = $(this).data("post-id");
				let comment = $("#commentInput"+ postId).val();				
				
				$.ajax({
					type:"post"
					, url:"/post/comment/create"
					, data:{"postId":postId, "content":comment}
					, success:function(data) {
						
						if(data.result== "success") {
							location.reload();
						} else {
							alert("댓글 작성 실패");
						}
					}
					
					, error:function() {
						alert("댓글 작겅 에러!");
					}
				});
				
				
			});
			
			
			$(".like-Icon").on("click", function() {
				
				let postId = $(this).data("post-id");
				
				$.ajax({
					type:"post"
					, url:"/post/like"
					, data:{"postId":postId}
					, success:function(data) {
						
						if(data.result == "success") {
							location.reload();
						} else {
							
							alert("좋아요 실패");
						}			
					}
					
					, error:function() {
						alert("좋아요 에러!!");
					}
					
					
				});
				
			});
			
			
			$("#addBtn").on("click", function() {
				let content = $("#contentInput").val();
				let file = $("#fileInput")[0];
				
				
				if(content == "") {
					alert("내용을 입력하세요");
					return ;
				}
				
				// 파일에 대한 유효성 검사
				if(file.files.length == 0) {
					alert("파일을 선택해 주세요");
					return ;
				}
				

				let formData = new FormData();
				formData.append("content", content);
				formData.append("imageFile", file.files[0]);
				
				
				$.ajax({
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

					, erroe:function() {
						
						alert("글쓰기 작성 에러");
					}	

					
					
				});
				

			

				
				
			});
			
			
			
		});
	
		
		
	
	
	
	</script>
		
	
	


</body>
</html>