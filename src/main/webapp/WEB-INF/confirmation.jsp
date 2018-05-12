<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang='eng'>
    <head>
        <meta charset='UTF-8'>
        <title>login</title>
        <link rel='stylesheet' href='<c:url value="/app.css"/>'>
        <h1 class='title'>Apollo Tutoring Services - Confirmation</h1>
    </head>
    <nav class='nav'>
        <a href='<c:url value="/student?action=none"/>'>Home</a>
        | <a href='<c:url value="/student/directory"/>'>Directory</a>
        | <a href='<c:url value="/student/forum"/>'>Forum</a>
        | <a href='<c:url value="/logout"/>'>Logout</a>
    </nav>
    <main>
        You have confirmed a tutoring session on ${day}.
    </main>
    <footer>

    </footer>
</html>