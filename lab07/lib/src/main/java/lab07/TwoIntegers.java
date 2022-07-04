package lab07;

class TwoIntegers {

    /*
     * Given two integers, each between 1 and 99 inclusive, returns their sum.
     * Arguments out of range throw an IllegalArgumentException
     */

    public static int sum(final int n, final int m) {
        if (n < 1 || n > 99 || m < 1 || m > 99) {
            throw new IllegalArgumentException();
        }
        int value = m + n;
        assert (value <= 198) && (value >=0) : "Output out of range";
        return value;
    }
}

