<%@ page import="com.koreait.board2.model.BoardVO" %>
<%@ page import="com.koreait.board2.model.UserVO" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021-11-18
  Time: 오후 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    BoardVO data = (BoardVO)request.getAttribute("data");
    UserVO loginUser = (UserVO) session.getAttribute("loginUser");

%>
<html>
<head>
    <title>${requestScope.data.tile}</title>
</head>
<body>

<h1>디테일</h1>
<%if(loginUser != null && data.getWriter() == loginUser.getIuser()) { %>
<a href="/board/mod?pk=${requestScope.data.iboard}"><input type="button" value="수정"></a>
<a href="/board/del?pk=${requestScope.data.iboard}"><input type="button" value="삭제"></a>
<%}%>
<div>${requestScope.err}</div>
<div><a href="/list">리스트</a> </div>

<div> 글번호 : ${data.iboard}</div>
<div> 제목 : ${data.tile}</div>
<div> 작성자 : ${data.writerNm}</div>
<div> 작성일시 : ${data.rdt}</div>
<div> 내용 : ${data.ctnt}</div>

</body>
</html>
