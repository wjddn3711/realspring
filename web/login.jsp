<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>

<form action="login.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mid" value="${memberVO.mid}"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" value="${memberVO.password}"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="로그인하기"></td>
		</tr>
	</table>
</form>

</body>
</html>