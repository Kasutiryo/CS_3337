<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang='eng'>
    <head>
        <meta charset='UTF-8'>
        <title>login</title>
        <link rel='stylesheet' href='<c:url value="/app.css"/>'>
        <h1 class='title'>Apollo Tutoring Services - Student</h1>
    </head>
    <nav class='nav'>
        <a href='<c:url value="/student"/>'>Home</a>
        | <a href='<c:url value="/student/directory"/>'>Directory</a>
        | <a href='<c:url value="/student/forum"/>'>Forum</a>
        | <a href='<c:url value="/login"/>'>Logout</a>
    </nav>
    <main>
        <div class='content'>
            <div class='student_information'>
                    <label>Student: </label>
                    <label>${user.getFullName()}</label>
                    <label>Major: </label>
                    <label>${user.getMajor()}</label> 
            </div>
            <div class='student_schedule_column'>
                <label>My Class Schedule: </label>
                <table class='student_schedule_table'>
                    <tr class='header'>
                        <th>Subject</th>
                        <th>Course Number</th>
                        <th>Course Name</th>
                        <th>Time</th>
                    </tr>
                    <c:forEach items="${user.getClasses()}" var="class">
                        <tr>
                            <td>${class.getSubject()}</td>
                            <td>${class.getClass_number()}</td>
                            <td>${class.getName()}</td>
                            <td>
                                <c:forEach items="${class.getSchedule()}" var="day">
                                    ${day.getDay()}
                                    <c:forEach items='${day.getIntervals()}' var="time">
                                       - ${time.toString()}  
                                    </c:forEach><br>
                                </c:forEach>
                            </td>                            
                        </tr>
                    </c:forEach>
                </table>
                <label>Available Sessions: </label>
                <table class='student_schedule_table'>
                    <tr class='header'>
                        <th>Subjects</th>
                        <th>Tutor</th>
                        <th>Days Available</th>
                        <th>Action</th>
                    </tr>
                        <c:forEach items="${tutors}" var="tutor">
                            <tr>
                                <td>${tutor.getStringSubjects()}</td>
                                <td>${tutor.getFullName()}</td>
                                <td>
                                    ${scheduler.find_avaiability(user, tutor)}
                                </td>
                                <td>
                                    <form action='<c:url value="/confirm-day?tutor=${tutor.getId()}"/>' method="POST">
                                        <input type='Submit' value="Schedule Now!">
                                    </form>                            
                                </td>
                            </tr>
                        </c:forEach>
                </table>
                    <form action='<c:url value="/student?action=find"/>' method='POST'> 
                        <input type="submit" value="Find tutors!">
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
