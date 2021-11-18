<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021-11-18
  Time: 오전 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = (String) request.getAttribute("err");
%>
<html>
<head>
    <title>write</title>
</head>
<body>
<h1>글쓰기</h1>
<%if(err!=null) { %>
    <div><%=err%></div>
<%}%>
<div>
    <form action="/board/write" method="post">
        <div><input type="text" name="tile" placeholder="tile"></div>
        <div>
            <textarea name="ctnt" placeholder="content"></textarea>
        </div>
        <div>
            <input type="submit" value="등록">
            <input type="reset" value="초기화">
        </div>


    </form>
</div>

</body>
</html>
