public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("123", "456"));
        System.out.println(ms.multiply("2", "3"));
        System.out.println(ms.multiply("999", "999"));
    }

    public String multiply(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int[] digit1 = new int[c1.length];
        int[] digit2 = new int[c2.length];

        for (int i = 0; i < c1.length; i++) 
            digit1[i] = Character.getNumericValue(c1[i]);
        
        for (int i = 0; i < c2.length; i++)
            digit2[i] = Character.getNumericValue(c2[i]);
        
        int[] result = add(digit1, digit2);
        
        StringBuilder sb = new StringBuilder();
        if (result[0] != 0)
            sb.append(result[0]);
        for (int i = 1; i < result.length; i++) 
            sb.append(result[i]);
        
        return sb.toString();
    }

    public int[] add(int[] num1, int[] num2) {
        int n = num1.length;
        int m = num2.length;

        if (n < m)
            return add(num2, num1);

        int[] result = new int[n+1];

        int a, b;
        int c = 0;
        int digit = 0;
        for (int i = 1; i <= m; i++) {
            a = num1[n-i];
            b = num2[m-i];
            digit = (a+b+c) % 10;
            result[n+1-i] =  digit;
            c = (a+b+c) / 10; 
        }

        for (int i = m+1; i <= n; i++) {
            a = num1[n-i];
            digit = (a+c) % 10;
            result[n+1-1] =  digit;
            c = (a+c) / 10;
        }
        
        if (c != 0)
            result[0] =  c;
        
        return result;
    }
}
