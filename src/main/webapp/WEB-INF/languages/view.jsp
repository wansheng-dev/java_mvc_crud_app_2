<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<p><c:out value="${language.name}"/><p>
	<p><c:out value="${language.creator}"/><p>
	<p><c:out value="${language.version}"/><p>
	
	<a href="/languages/edit/${language.id}">Edit</a>
	<form action="/languages/${language.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
</body>
</html>