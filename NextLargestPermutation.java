//https://leetcode.com/problems/next-greater-element-iii/solutions/4799378/easy-approach/
public class NextLargestPermutation {
    public static void main(String[] args) {
        System.out.println(new NextLargestPermutation().nextGreaterElement(12));
        System.out.println(new NextLargestPermutation().nextGreaterElement(123));
        System.out.println(new NextLargestPermutation().nextGreaterElement(4231));
        System.out.println(new NextLargestPermutation().nextGreaterElement(Integer.MAX_VALUE-1));
        System.out.println(new NextLargestPermutation().nextGreaterElement(Integer.MAX_VALUE));
        System.out.println(new NextLargestPermutation().nextGreaterElement(1999999999));
    }

    public int nextGreaterElement(int n) {
        int numDigits = 0;
        int num = n;
        while (num > 0) {
            num = num / 10;
            numDigits++;
        }    
        System.out.println("Num Digits: " + numDigits);
        int[] digits = new int[numDigits];
        num = n;
        for (int k = numDigits-1; k>=0; k--) {
            digits[k] = num % 10;
            num = num / 10;
        }

        // find the largest index such that a[i] < a[i+1]
        int i = numDigits -2;
        while (i>=0 && digits[i] >= digits[i+1])
            i--;
        System.out.println("Largest Index " + i);
        if (i == -1)
            return -1;
        

        // find the largest index j such that a[i] < a[j]
        int j = numDigits -1;
        while (j >=0 && digits[i] >= digits[j])
            j--;

        System.out.println("Swap Index " + j);
        if (j == -1)
            return -1;

        // swap a[i] and a[j]
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // reverse the order of the numbers from a[i+1] to a[n-1]
        int l = i+1;
        int r = numDigits-1;
        while (l < r) {
            temp = digits[l];
            digits[l] = digits[r];
            digits[r] = temp;
            l++;
            r--;
        }

        // reconstruct the number
        long newNum = 0;
        long place = 1;
        for (int k = numDigits-1; k >= 0; k--) {
            newNum =   newNum + place*digits[k];
            if (newNum > Integer.MAX_VALUE)
                return -1;
            place = place * 10;
        }

        return (int) newNum;
    }
}
