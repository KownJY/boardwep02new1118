<%@ page import="com.koreait.board2.model.UserVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.koreait.board2.model.BoardVO" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021-11-17
  Time: 오후 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserVO loginUser = (UserVO) session.getAttribute("loginUser");
    List<BoardVO> list = (List<BoardVO>) request.getAttribute("data");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%if(loginUser !=null) {%>
 <div><a href="/board/write">글쓰기</a> </div>
 <div><%=loginUser.getNm()%>님 안녕하세요?</div>
 <%}%>
 <%if(loginUser !=null) {%>
 <div><a href="/user/logout">로그아웃</a> </div>
 <%} else {%>
 <a href="/user/login">로그인</a>
 <%}%>
    <h1>리스트</h1>

 <table>
     <tr>

         <td>글번호</td>
         <td>제목</td>
         <td>글쓴이</td>
         <td>작성시각</td>

     </tr>

     <% for(BoardVO vo : list){ %>
     <tr>
         <td><%=vo.getIboard()%></td>
         <td>
             <a href="/board/detail?iboard=<%=vo.getIboard()%>"><%=vo.getTile()%></a>
         </td>
         <td><%=vo.getWriter()%></td>
         <td><%=vo.getRdt()%></td>
     </tr>

     <%}%>
 </table>


</body>
</html>
