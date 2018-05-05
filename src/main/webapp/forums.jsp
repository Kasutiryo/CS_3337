<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang='eng'>
    <head>
        <meta charset='UTF-8'>
        <title>Forum Page</title>
        <link rel='stylesheet' href='app.css'>
        <h1>Apollo Tutoring Services</h1>
    </head>
    <nav class='nav'>
        <a href='home.html'>Home</a>
        | <a href='Directory'>Directory</a>
        | <a href='profile.html'>Profile</a>
        | <a href='Forum'>Forum</a>
    </nav>
    <main>
        <div class='content'>
            <tr><th>Name</th><th>Question/Answer</th><th>Button</th></tr>
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
			  <p><a>Ask Question</a></p>
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
