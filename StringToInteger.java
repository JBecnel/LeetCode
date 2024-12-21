//https://leetcode.com/problems/string-to-integer-atoi/description/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInteger {
    public int myAtoi(String s) {
        String t = s.trim();
        int mult = 1;
        if (t.length() > 0)
            if (t.charAt(0)== '+') 
                t = t.substring(1);
            else if (t.charAt(0) == '-') {
                t =t.substring(1);
                mult = -1;
        }
        
        Pattern pattern = Pattern.compile("^\\d+");
        Matcher matcher = pattern.matcher(t);

        String leadingNumber = "0";
        if (matcher.find())
             leadingNumber = matcher.group();
        
        
        if (leadingNumber.length() > String.valueOf(Integer.MAX_VALUE).length())
            return (mult == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
            long result = mult * Long.parseLong(leadingNumber);
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else 
            return (int) result;
    }

    public static void main(String[] args) {
        StringToInteger sti = new StringToInteger();
        System.out.println(sti.myAtoi("  -12334"));
        System.out.println(sti.myAtoi("     +123949"));
        System.out.println(sti.myAtoi("  +12999494493939"));
        System.out.println(sti.myAtoi("-2000000000000000000000000000000000000000"));
    }
}
