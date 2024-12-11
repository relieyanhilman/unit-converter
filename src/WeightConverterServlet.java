import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class WeightConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double value = Double.parseDouble(request.getParameter("value"));
        String fromUnit = request.getParameter("fromUnit");
        String toUnit = request.getParameter("toUnit");

        double convertedValue = convertWeight(value, fromUnit, toUnit);
        request.setAttribute("convertedValue", convertedValue);
        request.getRequestDispatcher("weightConverter.jsp").forward(request, response);
    }

    private double convertWeight(double value, String fromUnit, String toUnit) {
        // Konversi ke gram sebagai unit standar
        double gramValue = switch (fromUnit) {
            case "milligram" -> value / 1000;
            case "kilogram" -> value * 1000;
            case "ounce" -> value * 28.3495;
            case "pound" -> value * 453.592;
            default -> value; // gram
        };

        // Konversi dari gram ke unit target
        return switch (toUnit) {
            case "milligram" -> gramValue * 1000;
            case "kilogram" -> gramValue / 1000;
            case "ounce" -> gramValue / 28.3495;
            case "pound" -> gramValue / 453.592;
            default -> gramValue; // gram
        };
    }
}
