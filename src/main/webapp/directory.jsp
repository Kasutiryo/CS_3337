<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset='UTF-8'>
        <title>Directory Page</title>
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
            <table class='tutor_directory_table'>
                <tr class='header'>
                    <th>Subjects of Expertise</th><th>Tutor Name</th><th>Schedule</th><th>Email</th>
                </tr>
                <c:forEach items="${tutor}" var="tutor">
					<tr>
						<td>${tutor.subjects}</td>
						<td>${tutor.name}</td>
						<td>${tutor.schedule}</td>
						<td>${tutor.email}</td>
					</tr>
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
