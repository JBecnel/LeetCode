// https://leetcode.com/problems/count-and-say/
public class CountAndSay {
    public static void main(String[] args) {
        new CountAndSay().countAndSay(30);
    }
    public String countAndSay(int n) {
        String rle = "1";
        for (int i = 2; i <= n; i++) {
            rle = computeRLE(rle);
            //System.out.println(i + " " + rle);
        }
            
        return new String(rle);
    }

    public static String computeRLE(String rle) {
        int index = 0;
        String update = "";
        while (index < rle.length()) {
            char c = rle.charAt(index);
            int count = 1;
            index++;
            while (index < rle.length() && rle.charAt(index) == c) {
                count++;
                index++;
            }
            update = (update + count) + c;
        }
        return update;
    }
}
