<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ex02</title>

		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" 
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
	</head>
	<body>
		<div class="container-fluid">
			<header class="text-center">
				<h1>게시글 상세보기 페이지</h1>
			</header>
			
			<nav> <!-- 페이지 이동 메뉴 -->
				<ul>
					<li><a href="../">메인</a></li>
					<li><a href="./main">게시판 메인</a></li>
					<li><a href="./update?bno=${board.bno}">수정</a></li>
				</ul>
			</nav>
			
			<div>
				<form>
					<div>
						<label for="title">글 제목</label>
						<input type="text" id="title" name="title" value="${board.title}" required autofocus readonly />
					</div>
					<div>
						<label for="content">글 내용</label>
						<textarea rows="5" id="content" name="content" required readonly>${board.content}
						</textarea>
					</div>
					<div>
						<label for="userid">작성자 아이디</label>
						<input type="text" id="userid" name="userid" value="${board.userid}" required readonly />
					</div>
					<div>
						<label for="reg_date">최종 수정 시간</label>
						<fmt:formatDate value="${board.reg_date}" pattern="yyyy/MM/dd HH:mm:ss" 
							var="last_update_time" />
						<input type="text" id="reg_date" name="reg_date" value="${last_update_time}" readonly />
					</div>
				</form>
			</div>
			
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>