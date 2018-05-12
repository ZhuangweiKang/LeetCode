class Solution {
    /*
    public int mySqrt(int x) {
        long y = 0;
        while (y*y <= x) y++;
        return (int)y-1;
    }
    */

    public int mySqrt(int x) {
        return mySqrtHelper(x, 0, x/2 + 1);
    }

    private int mySqrtHelper(int x, long low, long high) {
        if (low > high) return (int)high;
        long middle = (low + high)/2;
        if (middle * middle == x)
            return (int)middle;
        else if (middle * middle > x)
            return mySqrtHelper(x, low, middle-1);
        else
            return mySqrtHelper(x, middle+1, high);
    }
}