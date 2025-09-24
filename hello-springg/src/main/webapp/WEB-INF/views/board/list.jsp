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
<script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="/js/board/list.js"></script>
</head>
<body>
  <div class="wrapper">
    <h1 class="page-title">게시글 목록</h1>
    <div>검색된 게시글의 수 : ${list.count} 개</div>
    <table class="grid">
       <%-- 테이블 크기 지정, 늘어날 수 있는 최대 크기 지정? --%>
         <colgroup>
             <col width="80" />
             <col width="*" /><%-- 제목이 커짐 --%>
             <col width="200" />
             <col width="80" />
             <col width="120" />
             <col width="120" />
         </colgroup>
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
           <c:choose>
             <c:when test="${not empty list.list}">
               <c:forEach items="${list.list}" var="article"><%-- for(BoardVO article : list)와 동일 --%>
	           <%-- 반복을 시켜주는 태그 출처 c 적음, 
	           items : 반복하고 싶은 컬렉션 (반복 횟수가 됨) --%>
	               <tr>
	                  <td>${article.number}</td>
	                  <td>
	                   <a href="/view/${article.id}">${article.subject}</a>
	                  </td><%-- 컨텐트! 텍스트처럼 나옴 --%>
	                  <td>${article.email}</td>
	                  <td>${article.viewCnt}</td>
	                  <td>${article.crtDt}</td>
	                  <td>${article.mdfyDt}</td>
	               </tr>
	           </c:forEach>
             </c:when><%--비어있지 않다면 수행--%>
             <c:otherwise>
               <tr>
	             <td colspan="6" class="no-data">게시글이 없습니다.</td>
	             <%--colspan : 컬럼을 합침 --%>
	           </tr>
             </c:otherwise>
           </c:choose>
       </tbody>
    </table>
    <div class="btn-group">
      <div class="right-align">
        <button type="button" class="save-btn write-article">새 글 작성</button><%-- jquery로 이동시키려고 앵커아닌 버튼넣음 --%>
      </div>
    </div>
   </div>
</body>
</html>