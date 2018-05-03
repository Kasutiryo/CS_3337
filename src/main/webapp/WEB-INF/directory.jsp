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
        | <a href='directory.jsp'>Directory</a>
        | <a href='profile.html'>Profile</a>
        | <a href='forums.html'>Forum</a>
    </nav>
    <main>
        <div class='content'>
            <table class='tutor_directory_table'>
                <tr class='header'>
                    <th>Subjects of Expertise</th><th>Tutor Name</th><th>Schedule</th><th>Email</th>
                </tr>
                <c:forEach items="${entries}" var="entry">
				  <tr>
				    <td>${entry.subjects}</td>
				    <td>${entry.name}</td>
				    <td>${entry.tutorschedule}</td>
				    <td>${entry.email}</td>
				  </tr>
				 </c:forEach> 
            </table>
            <div class='directory_filter_options'>
                Filter
                    <form>
                        <label>Subjects: </label>
                        <div>
                          <input type='checkbox' name='subject'> ENGL<br>
                          <input type='checkbox' name='subject'> PHYS<br>
                          <input type='checkbox' name='subject'> MATH<br>
                          <input type='checkbox' name='subject'> CS<br>
                          <input type='checkbox' name='subject'> ART<br>
                          <input type='checkbox' name='subject'> CHEM<br>
                          <input type='checkbox' name='subject'> BIO<br>                          
                        </div>
                    </form>
                    <form>
                        <label>Days: </label>
                        <div>
                            <input type='checkbox' name='days'> Monday<br>
                            <input type='checkbox' name='days'> Tuesday<br>
                            <input type='checkbox' name='days'> Wednesday<br>
                            <input type='checkbox' name='days'> Thursday<br>
                            <input type='checkbox' name='days'> Friday<br>                            
                        </div>

                    </form>
            </div>
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
