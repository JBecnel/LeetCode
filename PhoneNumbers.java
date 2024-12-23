//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.List;

public class PhoneNumbers {
    public static void main(String[] args) {
        String digits = "12304";
        PhoneNumbers ph = new PhoneNumbers();
        for (String s : ph.letterCombinations(digits))
            System.out.println(s);
    }

    public ArrayList<String> findCombos(ArrayList<String> combos, String digits, int index, String[] options) {
        if (index == digits.length())
            return combos;
        else {
            ArrayList<String> updatedCombos = new ArrayList<String>();
            int digit = Character.getNumericValue(digits.charAt(index));
            String letters = options[digit];
            // System.out.println(digit + " letters " + letters + " " + combos.size());
            if (digit == 1)
                return findCombos(combos, digits, index + 1, options);
            for (String s : combos)
                for (int i = 0; i < letters.length(); i++) {
                    updatedCombos.add(s + letters.charAt(i));
                    // System.out.println(s+letters.charAt(i));
                }

            return findCombos(updatedCombos, digits, index + 1, options);
        }
    }

    public List<String> letterCombinations(String digits) {
        String[] options = { " ", "", "abc", "edf", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ArrayList<String> combos = new ArrayList<String>();
        if (digits.length() == 0)
            return combos;
        else {
            combos.add("");

            return findCombos(combos, digits, 0, options);
        }

    }
}
