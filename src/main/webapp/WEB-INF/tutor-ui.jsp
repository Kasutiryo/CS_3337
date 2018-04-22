<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang='eng'>

    <head>
        <meta charset='UTF-8'>
        <title>Home Page</title>
        <link rel='stylesheet' href='app.css'>
        <h1>Apollo Tutoring Services - Tutor</h1>
    </head>
    <nav class='nav'>
        <a href='<c:url value="/tutor"/>'>Home</a>
        | <a href='<c:url value="/tutor/directory"/>'>Directory</a>
        | <a href='<c:url value="/tutor/forum"/>'>Forum</a>
    </nav>
    <main>
        <div class='content'>
            <div class='student_information'>
                <form>
                    <label>Tutor: </label>
                    <label>{TUTOR_NAME}</label>
                    <!-- GRAB THIS FROM CSULA DATABASE -->
                    <label>Fields of expertise: </label>
                    <label>{TUTOR_FIELD_OF_EXPERTISE}</label>
                    <!-- GRAB THIS FROM CSULA DATABASE -->
                </form>
            </div>
            <div class='tutor_schedule_column'>
                <label>Enter your schedule here in military time (i.e "1100-1300,1530-1745"): </label>
                <table class='student_input_schedule'>
                    <tr class='header'>
                        <th>Monday</th>
                        <th>Tuesday</th>
                        <th>Wednesday</th>
                        <th>Thursday</th>
                        <th>Friday</th>
                        <th>Action</th>
                    </tr>
                    <tr>
                        <form action='<c:url value="/tutor/change"/>' method='POST'>
                            <td><input type='text' name='monday'></td>
                            <td><input type='text' name='tuesday'></td>
                            <td><input type='text' name='wednesday'></td>
                            <td><input type='text' name='thursday'></td>
                            <td><input type='text' name='friday'></td>
                            <td><input type='submit' value='Enter'></td>
                        </form>
                    </tr>
                </table>
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