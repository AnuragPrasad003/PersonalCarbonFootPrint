<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

    <h2>Welcome to Dashboard</h2>

    <h3>Total Carbon Emission: ${totalEmission} kg CO2</h3>

    <br>

    <h3>Your Carbon History</h3>

    <c:forEach var="log" items="${logs}">
        <p>
            <b>Date:</b> ${log.date} <br>
            <b>Transport Emission:</b> ${log.transportEmission} kg CO2 <br>
            <b>Food Emission:</b> ${log.foodEmission} kg CO2 <br>
            <b>Energy Emission:</b> ${log.energyEmission} kg CO2 <br>
            <b>Total Emission:</b> ${log.totalEmission} kg CO2 <br>
            <hr>
        </p>
    </c:forEach>

    <br>

    <a href="/surveyPage">Fill Survey</a> |
    <a href="/carbonPage">Add Manual Log</a>

</body>
</html>