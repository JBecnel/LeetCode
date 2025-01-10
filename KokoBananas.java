
//https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoBananas {
    public static void main(String[] args) {
        KokoBananas kb = new KokoBananas();
        System.out.println(kb.minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(kb.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(kb.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0; i < piles.length; i++)
            if (piles[i] > max)
                max = piles[i];
        
        int right = max;
        int left = 1;
        int k = (right + left)/2;
        int speed = 1;
        while (left <= right) {
            if (speedWorks(piles, h, k)) {
                right = k - 1;
                speed = k;
                k = (left + right)/2;
            } else {
                left = k + 1;
                k = (left + right)/2;
            }
        }
        return speed;
    }

    public boolean speedWorks(int[] piles, int hours, int speed) {
        int totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
            totalHours += piles[i]/speed;
            if (piles[i] % speed != 0)
                totalHours = totalHours + 1;

            if (totalHours > hours) 
                return false;
        }
        return true;
    }
}
