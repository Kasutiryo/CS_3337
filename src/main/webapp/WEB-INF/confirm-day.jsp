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
        <form class='box' action='<c:url value="/confirmation?tutor=${name}"/>' method='POST'>
            <label>Enter the day to have tutoring 
                 with ${name}</label>
            <input class='input' type='text' name='day'>
            <input class='login_button' type='submit' value='Confirm'>
        </form>
    </main>
    <footer>

    </footer>
</html>