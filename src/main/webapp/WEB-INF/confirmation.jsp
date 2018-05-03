<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang='eng'>
    <head>
        <meta charset='UTF-8'>
        <title>Home Page</title>
        <link rel='stylesheet' href='app.css'>
        <h1>Apollo Tutoring Services</h1>
    </head>
    <nav class='nav'>
        <a href='<c:url value="/student"/>'>Home</a>
        | <a href='<c:url value="/student/directory"/>'>Directory</a>
        | <a href='<c:url value="/student/forum"/>'>Forum</a>
        | <a href='<c:url value="/logout"/>'>Logout</a>
    </nav>
    <main>
        You have confirmed a tutoring session with ${name} on ${day}.
    </main>
    <footer>

    </footer>
</html>