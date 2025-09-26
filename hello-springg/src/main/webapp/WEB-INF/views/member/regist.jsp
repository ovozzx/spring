<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <link type="text/css" rel="stylesheet" href="/css/hello-spring.css" />
	<script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="/js/common/validate.js"></script>
	<script type="text/javascript" src="/js/member/regist.js"></script>
</head>
<body>
    <div class="wrapper">
        <h1 class="page-title">회원가입</h1>
        <form:form modelAttribute="requestRegistMemberVO" method="post" action="/member/regist"><%-- action : 보낼곳--%>
            <div class="grid member-regist">
                <label for="email" class="require email">이메일</label>
                <div>
                   <input id="email" type="text" name="email" value="${registData.email}" />
                   <form:errors path="email" cssClass="validate-error validate-require validate-email" />
                </div>  
                <label for="name" class="require">이름</label>
                <div>
                   <input id="name" type="text" name="name" value="${registData.name}"/>
                   <form:errors path="name" cssClass="validate-error validate-require" />
                </div>  
                <label for="password" class="require password">비밀번호</label>
                <div>
                   <input id="password" type="password" name="password" data-pair="#password-confirm"/>
                   <form:errors path="password" cssClass="validate-error validate-require validate-password" />
                   <c:if test="${not empty passwordError}"><%-- 조건문 JSTL --%>
                    <span class='validate-error validate-password'>${passwordError}</span>
                   </c:if>
                </div>  
                <label for="password-confirm" class="require password">비밀번호 확인</label>
                <div>
                   <input id="password-confirm" type="password" name="passwordConfirm" data-pair="#password"/>
                   <form:errors path="passwordConfirm" cssClass="validate-error validate-require validate-password" />
                   <c:if test="${not empty passwordError}"><%-- 조건문 JSTL --%>
                    <span class='validate-error validate-password'>${passwordError}</span>
                   </c:if>
                </div>  
                <div class="btn-group">
                    <div class="right-align">
                        <button type="button" 
                        class="save-btn auto-active" 
                        data-range=".member-regist" 
                        data-dependencies="#email, #name, #password, #password-confirm"
                        disabled="disabled">등록</button>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>