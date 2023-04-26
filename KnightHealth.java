/* https://leetcode.com/problems/dungeon-game/

The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).

To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Return the knight's minimum initial health so that he can rescue the princess.

Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 
Example 1:

Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
Example 2:

Input: dungeon = [[0]]
Output: 1
 

Constraints:

m == dungeon.length
n == dungeon[i].length
1 <= m, n <= 200
-1000 <= dungeon[i][j] <= 1000
*/

class KnightHealth {
    public static int healthNeeded(int[][] dungeon) {
        // size of the dungeon table m x n
        int m = dungeon.length;
        int n = dungeon[0].length;

        // hp[i][j] - holds the health needed to survive getting from
        // square [i][j] to the bottom right [m-1][n-1]
        int[][] hp = new int[m][n];

        // if positive we only need to enter with 1 health to survive
        // if negative, then we need more than the hit points takes
        // for example, if holds -5, then we need 5+1=6 hit points
        hp[m-1][n-1] = Math.max(1, 1-dungeon[m-1][n-1]);

        // process the last column
        // here we can only move down to get to bottom right
        // so the hit points we can be found by adding
        //          hit points taken in the room + hp needed to survive the rest of the moves to bottom right
        //          secondly, hit points needed to survive should not drop below 1
        for (int i =m-2; i>=0; i--)
            hp[i][n-1] =  Math.max(hp[i+1][n-1]-dungeon[i][n-1],1);

        // process the row column
        // here we can only move right to get to bottom right
        // so the hit points we can be found by adding
        //          hit points taken in the room + hp needed to survive the rest of the moves to bottom right
        //          secondly, hit points needed to survive should not drop below 1
        for (int j = n-2; j>=0; j--)
            hp[m-1][j] = Math.max(hp[m-1][j+1] - dungeon[m-1][j],1);

        // process the interior
        // the number of hit points needed to survive [i][j] to [m-1][n-1] are computed
        // we have two choices (move right or down
        //      - we take the min number of hip points needed to surive from these rooms to bottom right
        //      - we add the hit points required to surive room [i][j]
        //      - hit points should not drop below 1
        for (int i = m-2; i>=0; i--)
            for (int j=n-2; j>=0; j--) 
                hp[i][j] = Math.max( Math.min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j],1);
        printTable(hp);

        return hp[0][0];
    }

    public static void printTable(int[][] table) {
        for (int i = 0; i < table.length; i++) { 
            for (int j = 0; j < table[0].length; j++)
                System.out.print(table[i][j]+ " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] d = new int[3][3];
        d[0][0] = -2;
        d[0][1] = -3;
        d[0][2] = -30;
        d[1][0] = -5;
        d[1][1] = 10;
        d[1][2] = 1; 
        d[2][0] = 10;
        d[2][1] = 30;
        d[2][2] = -5;          
        printTable(d);
        System.out.println(healthNeeded(d));
 //       System.out.println(calculateMinimumHP(d));
        // [[-2,-3,3],[-5,-10,1],[10,30,-5]]
    }
}