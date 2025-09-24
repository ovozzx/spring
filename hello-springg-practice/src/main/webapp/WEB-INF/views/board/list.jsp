<%-- jsp 주석입니다
 <%@ <== Directive
 <%@ page ... %> <== Page Directive (Java class Import)
 <%@ taglib ... %> <== Tag library Directive 
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="/css/hello-spring.css" />
</head>
<body>
    <h1>게시글 목록</h1>
    <div>검색된 게시글의 수 : ${list.count} 개</div>
    <table class="grid">
       <thead>
        <tr><%--한 row--%>
          <th>번호</th><%-- 한 header, 굵게 나옴 --%>
          <th>제목</th>
          <th>이메일</th>
          <th>조회수</th>
          <th>등록일</th>
          <th>수정일</th>
        </tr>
       </thead>
       <tbody><%-- content --%>
       <c:forEach items="${list.list}" var="article"><%-- for(BoardVO article : list)와 동일 --%>
       <%-- 반복을 시켜주는 태그 출처 c 적음, 
       items : 반복하고 싶은 컬렉션 (반복 횟수가 됨) --%>
	       <tr>
	          <td>${article.id}</td>
	          <td>${article.subject}</td><%-- 컨텐트! 텍스트처럼 나옴 --%>
	          <td>${article.email}</td>
	          <td>${article.viewCnt}</td>
	          <td>${article.crtDt}</td>
	          <td>${article.mdfyDt}</td>
	       </tr>
       </c:forEach>
       </tbody>
    </table>
</body>
</html>