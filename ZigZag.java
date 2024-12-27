
// https://leetcode.com/problems/zigzag-conversion/description/
public class ZigZag {
    public static void main(String[] args) {
        ZigZag zz = new ZigZag();
        System.out.println(zz.convert("PAYPALISHIRING",3));        
        System.out.println();
        System.out.println(zz.convert("PAYPALISHIRING",4));
        System.out.println(zz.convert("A", 1));
    }
    
    public String convert(String s, int numRows) {
        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++)
            rows[i] = "";
        
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows; i++)  {
                rows[i] = rows[i] +  ((index < s.length()) ? s.charAt(index) : "");
                index = index + 1;
            }
            int spot = numRows - 2; 
       
            for (int col = 0; col < numRows-2; col++) {
                for (int r = 0; r < numRows; r++) {
                    if (r == spot) {
                        rows[r] = rows[r] + ((index < s.length()) ? s.charAt(index) : "");
                        index = index + 1;
                        spot = spot - 1;
                    } 
                }
            }
            
        }
        
        String result = "";
        for (int i = 0; i < numRows; i++) {
            result += rows[i].trim();
            //System.out.println(rows[i]);
        }
        //System.out.println(result);
        return result;
    }

}
