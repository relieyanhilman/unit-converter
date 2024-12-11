<!DOCTYPE html>
<html>
<head>
    <title>Konverter Berat</title>
</head>
<body>
    <h1>Konverter Berat</h1>
    <form method="post" action="convertWeight">
        <label>Masukkan Nilai:</label>
        <input type="number" step="0.01" name="value" required>
        <br>
        <label>Dari:</label>
        <select name="fromUnit">
            <option value="milligram">Milligram</option>
            <option value="gram">Gram</option>
            <option value="kilogram">Kilogram</option>
            <option value="ounce">Ounce</option>
            <option value="pound">Pound</option>
        </select>
        <br>
        <label>Ke:</label>
        <select name="toUnit">
            <option value="milligram">Milligram</option>
            <option value="gram">Gram</option>
            <option value="kilogram">Kilogram</option>
            <option value="ounce">Ounce</option>
            <option value="pound">Pound</option>
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
