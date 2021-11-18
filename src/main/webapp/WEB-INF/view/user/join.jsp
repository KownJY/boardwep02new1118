
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String msg = (String)request.getAttribute("msg");
%>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .err{color: brown;}
</style>
<body>

<h1>회원가입</h1>
<%if(msg != null) { %>
    <div class="err"><%=msg%></div>
<%}%>
    <div>
        <form action="/user/join" method="post">
            <div><input type="text" name="uid" placeholder="user id"></div>
            <div><input type="password" name="upw" placeholder="user passward"></div>
            <div><input type="text" name="nm" placeholder="user name"></div>
            <div>
                gender  : <label>woman <input type="radio" name="gender" value="1" checked ></label>
                gender  : <label>man <input type="radio" name="gender" value="0" checked ></label>
            </div>
            <div>
                <input type="submit" value="join">
            </div>
        </form>

    </div>


</body>
</html>
