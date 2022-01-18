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
    <title>signup</title>
</head>
<body>
<form action="signup.do" method="post">
    <table border="1">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="mid" placeholder="id 를 입력하세요" required></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="password" placeholder="비밀번호를 입력하세요" required></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" placeholder="이름을 입력하세요" required></td>
        </tr>
        <tr>
            <td>구분</td>
            <td>
                <select name="role">
                    <option value="ADMIN">ADMIN</option>
                    <option value="USER" selected>USER</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="회원정보바꾸기"></td>
        </tr>
    </table>
</form>
</body>
</html>
