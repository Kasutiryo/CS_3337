<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang='eng'>

<head>
    <meta charset='UTF-8'>
    <title>login</title>
    <link rel='stylesheet' href='<c:url value="/app.css"/>'>
    <h1 class='title'>Apollo Tutoring Services - Login</h1>
</head>
<main> 
    <form class='box' action='<c:url value="/login"/>' method='POST'>
        <label>Username: </label>
        <input class='input' type='text' name='username'>
        <label>Password: </label>
        <input class='input' type="password" name='password'>
        <input class='login_button' type='submit' value='Log in'>
    </form>
</main>

</html>