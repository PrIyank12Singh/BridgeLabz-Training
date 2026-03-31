public class UnitConvertorAdvanced {

    public static double convertFahrenheitToCelsius(double f) {
      //formula for converting fahrenheit to celsius  
      return (f - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double c) {
      //formula for converting celsius to fahrenheit  
      return (c * 9 / 5) + 32;
    }

    public static double convertPoundsToKg(double pounds) {
      //formula for converting pounds to kg
        return pounds * 0.453592;
    }

    public static double convertKgToPounds(double kg) {
      //formula for converting kg to pounds
        return kg * 2.20462;
    }


    public static double convertGallonsToLiters(double gallons) {
      //formula for converting gallons to liters
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
      //formula for converting liters to gallons
        return liters * 0.264172;
    }
}
