import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class TemperatureConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double value = Double.parseDouble(request.getParameter("value"));
        String fromUnit = request.getParameter("fromUnit");
        String toUnit = request.getParameter("toUnit");

        double convertedValue = convertTemperature(value, fromUnit, toUnit);
        request.setAttribute("convertedValue", convertedValue);
        request.getRequestDispatcher("temperatureConverter.jsp").forward(request, response);
    }

    private double convertTemperature(double value, String fromUnit, String toUnit) {
        if (fromUnit.equals(toUnit)) return value;

        // Konversi dari fromUnit ke Celcius
        double celsiusValue = switch (fromUnit) {
            case "Fahrenheit" -> (value - 32) * 5 / 9;
            case "Kelvin" -> value - 273.15;
            default -> value; // Celsius
        };

        // Konversi dari Celsius ke toUnit
        return switch (toUnit) {
            case "Fahrenheit" -> (celsiusValue * 9 / 5) + 32;
            case "Kelvin" -> celsiusValue + 273.15;
            default -> celsiusValue; // Celsius
        };
    }
}
