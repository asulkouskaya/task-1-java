import java.util.Locale;
import java.util.Arrays;
public class BaseConverter {
    private double celsius;

    public BaseConverter(double celsius) {
        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }

    public double toKelvin() {
        return celsius + 273.15;
    }

    public double toFahrenheit() {
        return celsius * 9 / 5 + 32;
    }

    public String convert(String unit) {
        double result;
        String symbol;
        switch (unit) {
            case "K":
                result = toKelvin();
                symbol = "K";
                break;
            case "F":
                result = toFahrenheit();
                symbol = "°F";
                break;
            case "C":
                result = getCelsius();
                symbol = "°C";
                break;
            default:
                return "Invalid unit";
        }
        return String.format("%.2f %s", result, symbol);
    }

    public static BaseConverter create(double celsius) {
        Locale locale = Locale.getDefault();
        String[] fahrenheitCountries = {"BS", "US", "BZ", "KY", "PW"};
        boolean isFahrenheit = Arrays.asList(fahrenheitCountries).contains(locale.getCountry());
        if (isFahrenheit) {
            celsius = (celsius - 32) * 5 / 9;
        }
        return new BaseConverter(celsius);
    }
}