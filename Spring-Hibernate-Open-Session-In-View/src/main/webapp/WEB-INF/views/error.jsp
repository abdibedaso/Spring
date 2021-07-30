<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
	<title>Error </title>
		<style>
		table td, table th {
			border: 1px solid black;
			padding: 3px;
		}
		table {
			margin-top: 30px;
			border-collapse: collapse;
		}
		form {
			margin-bottom: 30px;
		}
	</style>
</head>
<body>
	
	<c:if test="${student != null}">

	<div style="color:red">Sorry something we wrong &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;   ${student}</div>

	
	</c:if>
	
	<c:if test="${student == null && studentid != null}">
		Student not found
	</c:if>
</body>
</html>