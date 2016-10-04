<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset='utf-8'>
</head>
<body>
<div class="container">
	<div class="header">
		<%@ include file="/include/topMenu.jsp" %>
	</div>	
	<div class="content">
		 <hr />
		 <h2>자바 네트워크 게시판</h2>
		 <hr />
		 <br><br>
		 <hr />
		 번호 : <c:out value="${param.no}" /><br>
		 글쓴이 : <c:out value="${board.writer}" /><br>
		 제목 : <c:out value="${board.title}" /><br>
		 내용 : <c:out value="${board.content}" /><br>
		 등록일시 : 
		 <fmt:formatDate var="regDate" value="${board.regDate}" pattern="yyyy-MM-dd HH:mm:ss" />
		 <c:out value="${regDate}" /><br>
		 첨부파일 : 
		 <a href="${pageContext.request.contextPath}/down?path=${file.filePath}&realName=${file.realFileName}&oriName=${file.oriFileName}">${file.oriFileName}</a>(${file.fileSize} byte)
		 <hr />
		 <a href='updateForm?no=<c:out value="${param.no}" />'>수정</a>
		 <a href='delete?no=<c:out value="${param.no}" />'>삭제</a>
		 <a href='list'>목록</a><br><br>
		 <a href='detail?no=<c:out value="${param.no}"/>&comment=Y&inputComment=N'>댓글</a><br>
		 <h1>${sessionScope.user.id}</h1>
		 <h5>comment : ${param.comment}</h5>
		 <c:choose>
		 	<c:when test="${param.comment == 'Y'}">
		 		<h2><c:out value='${param.no}'/></h2>
		 		<form action="detail">
		 			<input type="hidden" name="no" value=${param.no}>
		 			<input type="hidden" name="inputComment" value="Y">
		 			<input type="hidden" name="id" value=${sessionScope.user.id}>
					댓글입력 : <input type="input" size="50" name="commentContent">
					<input type="submit" value="등록">
		 		</form>
		 	</c:when>
		 </c:choose>
		 
		 <div>
		 	  <h2>네트워크 게시판</h2>
	  전체 ${fn:length(list)}개<br>
	  <hr>
	  <table width='100%' border='0'>
		<c:forEach var="comment" items="${list}">
		<tr>
		  <td>id : <c:out value="${comment.id}" /> , ${comment.commentNo}, ${param.commentNo} 
		  </td>
		  	<c:choose>
		  		<c:when test="${comment.commentNo == param.commentNo}">
					<td>수정 : 
						<form action="updateComment">
							<input type="hidden" name="inputComment" value="N">
							<input type="hidden" name="no" value=${param.no}>
							<input type="hidden" name="commentNo" value=${comment.commentNo}>
							<input type="text" name="updateContent">
							<input type="submit" value="수정">
						</form>
					</td>		  		
		  		</c:when>
		  		<c:otherwise>
		  			<td>내용 : <c:out value="${comment.commentContent}" /></td>
		  		</c:otherwise>
		  	</c:choose>
		  
		  
		  <td><fmt:formatDate var="regDate" value="${board.regDate}" pattern="yyyy-MM-dd" />
		      <c:out value="${regDate}" />
		  </td>
		  <td>
		  	<a href='detail?update=Y&commentNo=<c:out value="${comment.commentNo}"/>&no=<c:out value="${param.no}"/>&inputComment=N'>수정</a>
	  	  </td>
		  <td><a href='deleteComment?commentNo=<c:out value="${comment.commentNo}"/>&no=<c:out value='${param.no}'/>'>x</a></td>
		 </tr>
		 </c:forEach>
		 <c:if test="${empty list}">
		 <tr>
		    <td colspan='3'>댓글을 입력해 주세요.</td>
		 </tr>
		 </c:if>
		 </table>
		 
		 </div>
	</div>
	
	
	<div class="footer">
		<%@ include file="/include/bottom.jsp" %>
	</div>
</div>

</body>
</html>




