'''https://leetcode.com/problems/candy/description/
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104'''

class Solution:
    def candy(self, ratings: list[int]) -> int:
        candies = len(ratings) * [1]
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
                
        for i in range(len(ratings)-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i], candies[i+1]+1)
        
        #print(candies) 
        return sum(candies) 
    
if __name__ == "__main__":
    s = Solution()
    print(s.candy([1,0,2])) # 5
    print(s.candy([1,2,2])) # 4
    print(s.candy([1,2,3,4,5,6,7,8,9,10])) # 55
    print(s.candy([1,2,3,4,5,6,7,8,9,10,9,8,7,6,5,4,3,2,1])) #
    print(s.candy([1,3,5,3,5,1,2,3,5,4,3,2,1])) # 24