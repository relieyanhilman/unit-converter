<!DOCTYPE html>
<html>
<head>
    <title>Konverter Panjang</title>
</head>
<body>
    <h1>Konverter Panjang</h1>
    <form method="post" action="convertLength">
        <label>Masukkan Nilai:</label>
        <input type="number" step="0.01" name="value" required>
        <br>
        <label>Dari:</label>
        <select name="fromUnit">
            <option value="millimeter">Millimeter</option>
            <option value="centimeter">Centimeter</option>
            <option value="meter">Meter</option>
            <option value="kilometer">Kilometer</option>
            <option value="inch">Inch</option>
            <option value="foot">Foot</option>
            <option value="yard">Yard</option>
            <option value="mile">Mile</option>
        </select>
        <br>
        <label>Ke:</label>
        <select name="toUnit">
            <option value="millimeter">Millimeter</option>
            <option value="centimeter">Centimeter</option>
            <option value="meter">Meter</option>
            <option value="kilometer">Kilometer</option>
            <option value="inch">Inch</option>
            <option value="foot">Foot</option>
            <option value="yard">Yard</option>
            <option value="mile">Mile</option>
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
