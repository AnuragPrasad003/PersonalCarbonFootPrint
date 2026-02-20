<html>
<body>
<h2>Survey</h2>

<form action="/survey/save" method="post">

    Transport Mode:
    <select name="transportMode">
        <option value="car">Car</option>
        <option value="bike">Bike</option>
        <option value="bus">Bus</option>
        <option value="train">Train</option>
        <option value="cycle">Cycle</option>
        <option value="walk">Walk</option>
    </select><br><br>

    Diet Type:
    <select name="dietType">
        <option value="veg">Vegetarian</option>
        <option value="nonveg">Non-Vegetarian</option>
        <option value="vegan">Vegan</option>
    </select><br><br>

    Energy Usage (kWh):
    <input type="number" name="energyUsage" min="0"><br><br>

    <button type="submit">Submit</button>
</form>

</body>
</html>