public class ComplexMultiplication {
    public static void main(String[] args) {
        System.out.println(new ComplexMultiplication().complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(new ComplexMultiplication().complexNumberMultiply("1+-1i", "1+-1i"));
        System.out.println(new ComplexMultiplication().complexNumberMultiply("10+-12i", "10+12i"));
        
    }

    public String complexNumberMultiply(String num1, String num2) {
        int[] nums = getValues(num1);
        int r1 = nums[0];
        int i1 = nums[1];
        nums = getValues(num2);
        int r2 = nums[0];
        int i2 = nums[1];

        int r = r1*r2 - i1*i2;
        int i = r1*i2 + r2*i1;

        return r + "+" + i + "i";
    }

    private static int[] getValues(String num) {
        int i = num.indexOf('+', 1);
        String real = num.substring(0, i);

        String imag = num.substring(i+1, num.length()-1);

        return new int[]{Integer.valueOf(real), Integer.valueOf(imag)};
    }
}