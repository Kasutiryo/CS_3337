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
    </nav>
    <main>
        <div class='content'>
            <div class='student_information'>
                <form>
                    <label>Student: </label>
                    <label>{STUDENT_NAME}</label> <!-- GRAB THIS FROM CSULA DATABASE -->
                </form>
                <form>
                    <label>Major: </label>
                     <label>{STUDENT_MAJOR}</label> <!-- GRAB THIS FROM CSULA DATABASE -->
                </form>
            </div>
            <div class='student_schedule_column'>
                <label>My Class Schedule: </label>
                <table class='student_schedule_table'>
                    <tr class='header'>
                        <th>Subject</th>
                        <th>Course Number</th>
                        <th>Time</th>
                    </tr>
                    <tr>
                        <td>CS</td> <!-- GRAB THIS FROM CSULA DATABASE -->
                        <td>3337</td> <!-- GRAB THIS FROM CSULA DATABASE -->
                        <td>11:30 AM - 3:45 PM</td> <!-- GRAB THIS FROM CSULA DATABASE -->
                    </tr>
                    <tr>
                        <td>CS</td> <!-- GRAB THIS FROM CSULA DATABASE -->
                        <td>3220</td> <!-- GRAB THIS FROM CSULA DATABASE -->
                        <td>4:00 PM - 8:05 PM</td> <!-- GRAB THIS FROM CSULA DATABASE -->
                    </tr>
                </table>
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
                        <form action='<c:url value="/student/schedule"/>' method='POST'>
                            <td><input type='text' name='monday'></td>
                            <td><input type='text' name='tuesday'></td>
                            <td><input type='text' name='wednesday'></td>
                            <td><input type='text' name='thursday'></td>
                            <td><input type='text' name='friday'></td>
                            <td><input type='submit' value='Enter'></td>
                        </form>
                    </tr>
                </table>
                <label>Available Sessions: </label>
                <table class='student_schedule_table'>
                        <tr class='header'>
                            <th>Subject</th>
                            <th>Course Number</th>
                            <th>Tutor</th>
                            <th>Time</th>
                            <th>Action</th>
                        </tr>
                        <tr>
                             <td>CS</td> <!-- COMPUTE THROUGH SCHEDULING MODULE -->
                            <td>3337</td> <!-- COMPUTE THROUGH SCHEDULING MODULE -->
                            <td>John Doe</td> <!-- COMPUTE THROUGH SCHEDULING MODULE -->
                            <td>{Mon, Wed, Fri} 1:00 PM - 3:00 PM</td> <!-- COMPUTE THROUGH SCHEDULING MODULE -->
                            <td><button>Schedule Now!</button></td> <!-- CREATE AND CONFIRM SESSION THROUGH COMMUNICATION AND SCHEDULING MODULES -->
                        </tr>
                        <tr>
                            <td>CS</td> <!-- COMPUTE THROUGH SCHEDULING MODULE -->
                            <td>3220</td> <!-- COMPUTE THROUGH SCHEDULING MODULE -->
                            <td>Julia Smith</td> <!-- COMPUTE THROUGH SCHEDULING MODULE -->
                            <td>{Tues, Thur} 8:00 AM - 10:00 AM</td> <!-- COMPUTE THROUGH SCHEDULING MODULE -->
                            <td><button>Schedule Now!</button></td>
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
