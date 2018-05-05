<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang='eng'>
    <head>
        <meta charset='UTF-8'>
        <title>login</title>
        <link rel='stylesheet' href='<c:url value="/app.css"/>'>
        <h1 class='title'>Apollo Tutoring Services - Forums</h1>
    </head>
    <nav class='nav'>
        <a href='<c:url value="/student"/>'>Home</a>
        | <a href='<c:url value="/student/directory"/>'>Directory</a>
        | <a href='<c:url value="/student/forum"/>'>Forum</a>
        | <a href='<c:url value="/login"/>'>Logout</a>
    </nav>
    <main>
        <div class='content'>
            <table class='student_schedule_table'>
                <tr class='header'>
                    <th>Name</th>
                    <th>Question/Answer</th>
                    <th>Button</th>
                </tr>
			  <c:forEach items="${question}" var="entry">
				  <tr>
				    <td>${entry.name}</td>
				    <td>${entry.message}</td>
				    <td><a>Answer Question</a></td>
				  </tr>
				  <c:forEach items="${answer}" var="answer">
					  <c:if test="${entry.id == answer.id}">
					  <tr>
					    <td></td>
					    <td>${answer.message}</td>
					    <td>${answer.name}</td>
					  </tr>
					  </c:if>
				  </c:forEach>
              </c:forEach>
            </table>
        </div>
    </main>
    <footer>
        <div>
            California State University of Los Angeles - CS 3337: SOFTWARE ENGINEERING
        </div>
        <div>
            Some functions of this website may not work as intended.
        </div>
        <div>
            CONCEPT DESIGN
        </div>
    </footer>
</html>
