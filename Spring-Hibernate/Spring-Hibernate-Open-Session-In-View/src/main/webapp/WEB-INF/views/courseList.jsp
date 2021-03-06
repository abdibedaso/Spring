<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
    <title>Student Details</title>
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

    <div>First name: ${student.firstname}</div>
    <div>Last name: ${student.lastname}</div>

    <table>
        <tr>
            <th>Course Number</th>
            <th>Name</th>
            <th>Grade</th>
        </tr>

        <c:forEach var="course" items="${student.courses}">

            <tr>
                <td>${course.courseNumber}</td>
                <td>${course.name}</td>
                <td>${course.grade}</td>
            </tr>

        </c:forEach>
    </table>

</c:if>

<c:if test="${student == null && studentId != null}">
    Student not found
</c:if>
</body>
</html>