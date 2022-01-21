<%--
  Created by IntelliJ IDEA.
  User: jungwoo
  Date: 2022/01/18
  Time: 3:24 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mypage</title>
</head>
<body>
<form action="mypage.do" method="post">

    <table border="1">
        <tr>
            <td>아이디</td>
            <td>${user.mid}</td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="password" placeholder="${user.password}" required></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" placeholder="${user.name}" required></td>
        </tr>
        <tr>
            <td>구분</td>
            <td>
                ${user.role}
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="변경하기"></td>
        </tr>
    </table>
</form>
</body>
</html>
