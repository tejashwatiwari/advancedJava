<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
List<String> names = new ArrayList<String>();
names.add("Ram");
names.add("Shyam");

%>

	<c:out value="${1+2}"></c:out>
	<c:set var="temp" value="${50}" />
	
	<h3>If Statement using if and test</h3>
	<c:if test="${temp>100}">
		<h1>Temp is less than 100</h1>
	</c:if>
	
	<h3>Switch Statement using Choose</h3>
	<c:choose>
		<c:when test="${temp > 100 }"> <h1>Temp is greater than 100</h1></c:when>
		<c:when test="${temp < 100 }"> <h1>Temp is less than 100</h1></c:when>
		<c:otherwise><h1> Temp is 100 </h1> </c:otherwise>
	</c:choose>
	
	<a href="<c:url value="temp.jsp" />">This is a link</a>
	
	<h3>For loop using for Each</h3>
	<c:forEach var="i" begin="1" end="10">
		i value <c:out value="${i}"></c:out><br>
	</c:forEach>
	
	
	<h3>To run loop</h3>
	 <c:forEach var="name" items="${names}">
            <c:out value="${name}"></c:out>
     </c:forEach>
	
</body>
</html>