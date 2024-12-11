import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LengthConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double value = Double.parseDouble(request.getParameter("value"));
        String fromUnit = request.getParameter("fromUnit");
        String toUnit = request.getParameter("toUnit");

        double convertedValue = convertLength(value, fromUnit, toUnit);
        request.setAttribute("convertedValue", convertedValue);
        request.getRequestDispatcher("lengthConverter.jsp").forward(request, response);
    }

    private double convertLength(double value, String fromUnit, String toUnit) {
        // Konversi ke meter sebagai unit standar
        double meterValue = switch (fromUnit) {
            case "millimeter" -> value / 1000;
            case "centimeter" -> value / 100;
            case "kilometer" -> value * 1000;
            case "inch" -> value * 0.0254;
            case "foot" -> value * 0.3048;
            case "yard" -> value * 0.9144;
            case "mile" -> value * 1609.34;
            default -> value; // meter
        };

        // Konversi dari meter ke unit target
        return switch (toUnit) {
            case "millimeter" -> meterValue * 1000;
            case "centimeter" -> meterValue * 100;
            case "kilometer" -> meterValue / 1000;
            case "inch" -> meterValue / 0.0254;
            case "foot" -> meterValue / 0.3048;
            case "yard" -> meterValue / 0.9144;
            case "mile" -> meterValue / 1609.34;
            default -> meterValue; // meter
        };

    }
}