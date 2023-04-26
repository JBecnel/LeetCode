import java.util.Scanner;

public class MootVictor {
    public static void main(String[] args) {
        // read in the family members attending
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the members of the moot in order using M or C with no spaces:");
        String moot = console.next();

        // display the victor
        if (victor(moot) == 'M')
            System.out.println("Montague Victory!");
        else
            System.out.println("Capulet Victory!");

        console.close();
    }

    public static char victor(String moot) {

        int M = 0; // number of alive M's
        int C = 0; // number of alive C's
        String remain = new String(moot);
        int n = moot.length();
        do {
            remain = "";
            for (int i = 0; i < moot.length(); i++) {
                if (moot.charAt(i) == 'M')
                    if (C == 0) {
                        remain = remain + "M";
                        M++;
                    } else
                        C--;
                else { // "C"
                    if (M == 0) {
                        remain = remain + "C";
                        C++;
                    } else
                        M--;
                } // end else
            } // end for
            n = moot.length();
            moot = new String(remain);
        } while (n != moot.length());

        if (M > 0)
            return 'M';
        else
            return 'C';
    }

}
