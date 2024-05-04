public class GCDString {
    public static void main(String[] args) {
        System.out.println(new GCDString().gcdOfStrings("ABCABC", "ABC"));
        System.out.println(new GCDString().gcdOfStrings("LEET", "CODE"));
        System.out.println(new GCDString().gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(new GCDString().gcdOfStrings("ABABCCABAB", "ABAB"));
        
    }

    private static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // put the longer string as the first argument
        if (n < m) 
            return gcdOfStrings(str2, str1);
            
        int k = 0;
        while (k+m <= n) {
            if (!str1.startsWith(str2, k)) 
                return "";
            k = k + m;
        }
        if (!str1.endsWith(str2))
            return "";
        
        // find the GCD of the string length
        int gcd = GCD(n, m);
        return str2.substring(0, gcd);
    }
}
