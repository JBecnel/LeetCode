public class Recursive {
    public static double average(int[] a, int left, int right) {
        if (left == right)
            return a[left];
        else {
            int m = (left+right)/2;
            return 1.0/(right-left+1) * ((m-left+1)*average(a, left, m) + (right-m)*average(a, m+1, right));        
        }
    }

    public static double sum(int[] a, int left, int right) {
        if (left == right)
            return a[left];
        else {
            int m = (left+right)/2;
            return sum(a, left, m) + sum(a, m+1, right); 
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        System.out.println(sum(a,0,a.length-1));
        System.out.println(average(a,0,a.length-1));
    }
}
