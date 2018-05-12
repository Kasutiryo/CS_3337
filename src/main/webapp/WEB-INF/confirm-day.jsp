<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang='eng'>
    <head>
        <meta charset='UTF-8'>
        <title>login</title>
        <link rel='stylesheet' href='<c:url value="/app.css"/>'>
        <h1 class='title'>Apollo Tutoring Services - Confirm Day</h1>
    </head>
    <nav class='nav'>
        <a href='<c:url value="/student?action=none"/>'>Home</a>
        | <a href='<c:url value="/student/directory"/>'>Directory</a>
        | <a href='<c:url value="/student/forum"/>'>Forum</a>
        | <a href='<c:url value="/logout"/>'>Logout</a>
    </nav>
    <main>
        <form class='box' action='<c:url value="/confirmation?tutor=${name}"/>' method='POST'>
            <label>Choose the day you want tutoring:</label>
            <c:forEach items="${day}" var='day'>
                <a href="<c:url value='/confirmation?day=${day}'/>">${day}</a>
            </c:forEach>
        </form>
    </main>
    <footer>

    </footer>
</html>