// https://leetcode.com/problems/reverse-integer/description/
public class ReverseInteger {
    public int reverse(int i) {
        long x = Math.abs(i);
        long digit = 0;
        long result = 0;
        while (x > 0) {
            digit = x % 10;
            x = x / 10;
            result = result * 10 + digit;
        }

        if (i < 0)
            result = -result;

        
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        else 
            return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        
        ReverseInteger rv = new ReverseInteger();
        System.out.println(rv.reverse(123456789));
        System.out.println(rv.reverse(-1234567890));
        System.out.println(rv.reverse(Integer.MAX_VALUE));
        System.out.println(rv.reverse(Integer.MIN_VALUE));
    }
}