//https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger rm = new RomanToInteger();
        System.out.println(rm.romanToInt("III"));
        System.out.println(rm.romanToInt("LVIII"));
        System.out.println(rm.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        // Define the values and symbols for Roman numerals
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

       
        // Iterate over the values and symbols
        int index = 0;
        int num = 0;
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i].length() == 1) {
                while (index < s.length() && s.charAt(index) == symbols[i].charAt(0)) {
                    num = num + values[i];
                    index++;
                }
            } else {
                if (index + 1 < s.length() && s.charAt(index) == symbols[i].charAt(0) && s.charAt(index+1) == symbols[i].charAt(1)) {
                    num = num + values[i];
                    index = index + 2;
                }

            }
            
        }

        // Return the resulting Roman numeral
        return num;

    }

}
