//https://leetcode.com/problems/divide-two-integers/

public class Divisor {

    public static void main(String[] args) {
    System.out.println(divide(Integer.MIN_VALUE, -1));
System.out.println(divide(Integer.MAX_VALUE, 1));
System.out.println(divide(7, -3));

}


    public static int divide(int dividend, int divisor) {
        long a = 1;
        long n = dividend;
        long m = divisor;
        
        if (n*m < 0)
            a = -1;

        if (n < 0)
            n = -n;

        if (m < 0)
            m = -m;

        long quot = n/m;
        quot = a*quot;

        if (quot > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (quot < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) quot;
    }
}