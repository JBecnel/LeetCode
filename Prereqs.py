'''
https://leetcode.com/problems/course-schedule/description/
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.


'''
class Solution:
    def is_cyc_util(self, adj, u, visited, rec_stack):
    
        if not visited[u]:
        
            # Mark the current node as visited
            # and part of recursion stack
            visited[u] = True
            rec_stack[u] = True

            # Recur for all the vertices 
            # adjacent to this vertex
            for x in adj[u]:
                if not visited[x] and self.is_cyc_util(adj, x, visited, rec_stack):
                    return True
                elif rec_stack[x]:
                    return True

        # Remove the vertex from recursion stack
        rec_stack[u] = False
        return False

    def is_cyclic(self, adj, V):
        visited = [False] * V
        rec_stack = [False] * V

        # Call the recursive helper function to
        # detect cycle in different DFS trees
        for i in range(V):
            if not visited[i] and self.is_cyc_util(adj, i, visited, rec_stack):
                return True

        return False

    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        adj = [[] for _ in range(numCourses)]
        for i, j in prerequisites:
            adj[i].append(j)

        return not self.is_cyclic(adj, numCourses)


if __name__ == "__main__":
    numCourses = 2
    prerequisites = [[1,0],[0,1]]
    s = Solution()
    print(s.canFinish(numCourses, prerequisites))
    
    numCourses = 2
    prerequisites = [[1,0]]
    s = Solution()
    print(s.canFinish(numCourses, prerequisites))