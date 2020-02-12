<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>        

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Creator</th>
	            <th>Version</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${languages}" var="languages">
	        <tr>
	            <td>
	            	<a href="/languages/${languages.id}">
	            		<c:out value="${languages.name}"/>
	            	</a>
	            </td>
	            <td><c:out value="${languages.creator}"/></td>
	            <td><c:out value="${languages.version}"/></td>
	            <td>
					<form action="/languages/${languages.id}" method="post">
	    				<input type="hidden" name="_method" value="delete">
	    				<input type="submit" value="Delete">
					</form>	
	            	<a href="/languages/edit/${languages.id}">Edit</a>
	            </td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	</div>
	
	<div>
	<form:form action="/languages" method="post" modelAttribute="lang">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:textarea path="creator"/>
	    </p>
	    <p>
	        <form:label path="version">Version</form:label>
	        <form:errors path="version"/>
	        <form:input path="version"/>
	    </p>   
	    <input type="submit" value="Submit"/>
	</form:form>    
	</div>
	
</body>
</html>