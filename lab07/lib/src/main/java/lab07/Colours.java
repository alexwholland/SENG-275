package lab07;

/*
 * Given three one-byte r,g,b values (each 0-255), returns a three-byte packed rgb integer
 * as 0x00rrggbb.  Throws an IllegalArgumentException for values out of range.
 */

public class Colours {
    public static int rgbBytesToInt(final int r, final int b, final int g) {
        if (r < 0 || b < 0 || g < 0 || r > 255 || b > 255 || g > 255) throw new IllegalArgumentException();
        int i = r * 256 + b * 16 + g;
        return i;
    }
}
