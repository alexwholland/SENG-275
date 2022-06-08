package lab03;

public class Boundary {

    /**
     * Returns true if the sound level in decibels is unsafe - that is, higher than 85 decibels.
     *
     * The WCB defines unsafe sound exposure as long-term exposure to sound in excess
     * of 85 decibels in volume.
     *
     * @param volume the volume of the sound in decibels
     * @return      true if the volume is unsafe, false otherwise
     */
    public static boolean isUnsafe(int volume) {return volume > 85;}


    /**
     * Returns true if the temperature outside in degrees Celsius is comfortable for David.
     *
     * Comfortable temperatures for David are defined as any temperatures between
     * 5 and 20 degrees inclusive.
     *
     * @param temperature The temperature outside in degrees Celsius
     * @return    true if David finds it comfortable, false otherwise
     */
    public static boolean isComfortable(int temperature) {
        return (temperature >= 5 && temperature <= 20);
    }



    /**
     * Returns the number of elevators required by multi-suite buildings, depending on the
     * number of storeys above grade without direct grade access.
     *
     * https://www.bchousing.org/publications/BCH-Design-Guidelines-Construction-Standards.pdf
     *
     * @param storeys  The number of storeys above grade without direct-grade access
     * @return      the number of elevators required
     */
    public static int elevatorsRequired(int storeys) {
        if (storeys < 2) return 0;
        if (storeys < 6) return 1;
        return 2;
    }

    /**
     * Given a numerical grade from 0 to 100 inclusive, returns the
     * letter grade equivalent according to the UVic standardized
     * grading scale.  Throws an exception for grades outside this range.
     *
     * @param percent the percentage grade from 0 to 100
     * @return the corresponding letter grade
     * @throws java.lang.IllegalArgumentException for a grade < 0 or > 100
     */
    public static String percentageToLetterGrade(double percent) throws IllegalArgumentException {
        if (percent < 0 || percent > 100) throw new IllegalArgumentException();
        if (percent < 50) return "F";
        if (percent < 60) return "D";
        if (percent < 65) return "C";
        if (percent < 70) return "C+";
        if (percent < 73) return "B-";
        if (percent < 77) return "B";
        if (percent < 80) return "B+";
        if (percent < 85) return "A-";
        if (percent < 90) return "A";
        return "A+";
    }

}
