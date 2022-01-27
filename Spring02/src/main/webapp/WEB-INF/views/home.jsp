<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
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
			<header class="jumbotron text-center">
				<h1>메인 페이지</h1>
			</header>
			
			<nav>
				<ul>
					<li>
						<a href="./user/register">회원 가입</a>
					</li>
					<li> <!-- TODO -->
						<a href="">로그인</a>
					</li>
					<li>
						<a href="./board/main">게시판 메인</a>
					</li>
				</ul>
			</nav>
			
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>