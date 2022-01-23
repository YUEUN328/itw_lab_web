<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>회원 가입</title>
        
        <style>
        .invalid {
            color: red;
            display: none;
        }
        .valid {
            color: green;
            display: none;
        }
        </style>
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" 
        	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
    </head>
    <body>
        <div>
            <h1>회원 가입 페이지</h1>
            <form action="./signup" method="post">
                <div>
                    <input type="text" id="userId" name="userId" 
                        placeholder="아이디 입력" required />
                    <div class="invalid">이미 사용중이거나 탈퇴한 아이디입니다.</div>
                    <div class="valid">멋진 아이디네요!</div>
                </div>
                <div>
                    <input type="password" id="pwd" name="pwd"
                        placeholder="비밀번호 입력" required />
                </div>
                <div>
                    <input type="email" id="email" name="email"
                        placeholder="이메일 입력" required />
                </div>
                <input type="submit" value="가입하기" />
            </form>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script>
        $(document).ready(function () {
        	
        	// input 요소에 변화가 생길 때 처리하는 이벤트 리스너를 등록 

        	$('#userId').change(function () {
        		console.log('on change: ' + $(this).val());
        		
        		// XMLHttpRequest 생성 -> onload 콜백 등록 -> open(요청방식, 요청 주소) -> send()
        		var xhr = new XMLHttpRequest();
        		xhr.onload = function () {
        			if (xhr.status == 200) { // Ajax 요청에 대한 응답이 성공인 경우에
        				// xhr.responseText: 서버가 보내준 응답(response) 문자열
        				if (xhr.responseText == 'valid') { // 사용 가능 아이디
        					$('.valid').show();
        				    $('.invalid').hide();
        				} else { // 사용 불가능 아이디
        					$('.invalid').show();
        				    $('.valid').hide();
        				}
        			}
        		};
        		
        		// xhr.open('GET', 'checkid?userId=' + $(this).val());
        		// xhr.send();
        		
        		xhr.open('POST', 'checkid');
        		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        		var data = 'userId=' + $(this).val(); // 'param=value' 형식의 문자열
        		xhr.send(data); // send 함수에 요청 파라미터를 argument로 전달.
        	});
        	
        });
        </script>
    </body>
</html>