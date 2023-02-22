package com.tuckman.advent.of.code.leet;

public class RectangleCalc {

    /**
     * The width W should not be larger than the length L, which means L >= W.
     * The difference between length L and width W should be as small as possible.
     * @return an array [L, W] where L and W are the length and width of the web page you designed in sequence.
     */
    public static int[] constructRectangle(int area) {
        int ceilSqrt = (int) Math.sqrt(area);
        while (ceilSqrt > 1) {
            if (area % ceilSqrt == 0) {
                break;
            }
            ceilSqrt--;
        }
        return new int[]{area / ceilSqrt, ceilSqrt};
    }


}
