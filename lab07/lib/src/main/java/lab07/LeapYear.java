
package lab07;


class LeapYear {

    public static boolean isLeapYear(final int year) {
        if (year < 1) throw new IllegalArgumentException();
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return year % 4 == 0;
    }
}