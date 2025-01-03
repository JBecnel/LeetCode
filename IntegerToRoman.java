public class IntegerToRoman {
    public String intToRoman(int num) {
        // Define the values and symbols for Roman numerals
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        // Initialize a StringBuilder to build the Roman numeral
        StringBuilder roman = new StringBuilder();

        // Iterate over the values and symbols
        for (int i = 0; i < values.length; i++) {
            // While the number is greater than or equal to the current value
            while (num >= values[i]) {
                // Append the symbol to the result
                roman.append(symbols[i]);
                // Subtract the value from the number
                num -= values[i];
            }
        }

        // Return the resulting Roman numeral
        return roman.toString();

    }

}
