<!DOCTYPE html>
<html>
<head>
    <title>Konverter Suhu</title>
</head>
<body>
    <h1>Konverter Suhu</h1>
    <form method="post" action="convertTemperature">
        <label>Masukkan Nilai:</label>
        <input type="number" step="0.01" name="value" required>
        <br>
        <label>Dari:</label>
        <select name="fromUnit">
            <option value="Celsius">Celsius</option>
            <option value="Fahrenheit">Fahrenheit</option>
            <option value="Kelvin">Kelvin</option>
        </select>
        <br>
        <label>Ke:</label>
        <select name="toUnit">
            <option value="Celsius">Celsius</option>
            <option value="Fahrenheit">Fahrenheit</option>
            <option value="Kelvin">Kelvin</option>
        </select>
        <br>
        <button type="submit">Konversi</button>
    </form>

    <%
        if (request.getAttribute("convertedValue") != null) {
            double convertedValue = (Double) request.getAttribute("convertedValue");
    %>
        <h2>Hasil Konversi: <%= convertedValue %></h2>
    <% } %>
</body>
</html>
