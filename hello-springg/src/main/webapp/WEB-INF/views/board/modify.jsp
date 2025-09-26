<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <link type="text/css" rel="stylesheet" href="/css/hello-spring.css" />
		<script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
		<script type="text/javascript" src="/js/common/validate.js"></script>
    </head>
    <body>
        <div class="wrapper">
            <h1 class="page-title">게시글 수정</h1>
            <form:form modelAttribute="requestModifyBoardVO" method="post" action="/modify/${board.id}" entype="multipart/form-data">
                <div class="grid board-write">
                   
                    <label for="subject" class="require">제목</label>
                    <div>
                        <input id="subject" type="text" name="subject" value="${board.subject}" />
                        <form:errors path="subject" cssClass="validate-error" />
                    </div>
                    
                    <label for="email" class="require email">이메일</label>
                    <div>
                        <input id="email" type="email" name="email" value="${board.email}" />
                        <form:errors path="email" cssClass="validate-error" />
                    </div>
                    
                    <label for="content" class="require">내용</label>
                    <div>
                        <textarea id="content" name="content" value="${board.content}"></textarea>
                        <form:errors path="content" cssClass="validate-error" />
                    </div>
                    
                    <div class="btn-group">
                        <div class="right-align">
                            <button class="cancel-btn" type="button">취소</button>
                            <button class="save-btn">저장</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </body>
</html>