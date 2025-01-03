
// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards
public class DeckPartition {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] size = new int[10000]; 
        for (int num : deck) 
            size[num]++; 
                
        int gcd = size[deck[0]];
        for (int num : deck)  {
            gcd = GCD( size[num], gcd);
        }
        return (gcd != 1);
    }

    private static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        DeckPartition dp = new DeckPartition();
        int[] deck = new int[]{1,2,3,4,4,3,2,1};
        System.out.println(dp.hasGroupsSizeX(deck));
       
        deck = new int[]{1,1,1,2,2,2,3,3};
        System.out.println(dp.hasGroupsSizeX(deck));
    }
}

