<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>

<h1><spring:message code="message.header.title"/></h1>
<h2>${user.name}<spring:message code="message.header.hello"/></h2>
<a href="logout.do"><spring:message code="message.header.logout"/></a>
<a href="mypage.do"><spring:message code="message.footer.member"/></a>

<hr>

<form action="main.do" method="post">
	<table width="1000">
		<tr>
			<td><select name="searchCondition">
				<c:forEach items="${conditionMap}" var="v">
					<option value=${v.value}>${v.key}</option>
				</c:forEach>
			</select></td>
			<td><input type="text" name="searchContent" /></td>
			<td><input type="submit" value="<spring:message code="message.body.search"/> " /></td>
		</tr>
	</table>
</form>
<table border="1" width="1000">
	<tr>
		<th><spring:message code="message.body.table.num"/> </th>
		<th><spring:message code="message.body.table.title"/></th>
		<th><spring:message code="message.body.table.writer"/></th>
		<th><spring:message code="message.body.table.reg"/></th>
		<th><spring:message code="message.body.table.cnt"/> </th>
	</tr>
	<c:forEach var="v" items="${datas}">
		<tr>
			<td><a href="board.do?bid=${v.bid}">${v.bid}</a></td>
			<td>${v.title}</td>
			<td>${v.writer}</td>
			<td>${v.bdate}</td>
			<td>${v.cnt}</td>
		</tr>
	</c:forEach>
</table>

<hr>

<a href="insertBoard.jsp"><spring:message code="message.footer.board"/> </a>

</body>
</html>