public class UnitConvertorLength {

    public static double convertYardsToFeet(double yards) {
      //formula for converting yards to feet  
      return yards * 3;
    }

    public static double convertFeetToYards(double feet) {
      //formula for converting feet to yards
      return feet * 0.333333;
    }

    public static double convertMetersToInches(double meters) {
        //formula for converting meters to inches
        return meters * 39.3701;
    }

    public static double convertInchesToMeters(double inches) {
        //formula for converting inches to meters
        return inches * 0.0254;
    }

    public static double convertInchesToCm(double inches) {
      //formula for converting inches to centimeters
        return inches * 2.54;
    }
}
