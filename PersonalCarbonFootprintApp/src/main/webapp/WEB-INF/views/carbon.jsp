<%@ page language="java" %>
<html>
<body>

    <h2>Add Carbon Log</h2>

    <form action="/carbon/add" method="post">

        Transport Emission (kg CO2): 
        <input type="number" step="0.1" name="transportEmission"><br><br>

        Food Emission (kg CO2): 
        <input type="number" step="0.1" name="foodEmission"><br><br>

        Energy Emission (kg CO2): 
        <input type="number" step="0.1" name="energyEmission"><br><br>

        <button type="submit">Save</button>

    </form>

    <br>
    <a href="/dashboard">Back to Dashboard</a>

</body>
</html>