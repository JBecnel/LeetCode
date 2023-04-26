/*
https://leetcode.com/problems/word-ladder/
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/

import java.util.*;

public class WordLadder {

    //=====================MAIN===================
    // This method reads in a words list along with a begin and end word.
    // If the ending words is not in the list or there is no path 
    // to the ending word, 0 is outputted.
    // Otherwise the length of the shortest path to the end word from the begin
    // word (as described above) is displayed.
    public static void main(String[] args) {
        // words to be used. 1st word is the begin word
        String[] words = new String[7];
        words[0] = "hit"; // begin word
        words[1] = "hot"; 
        words[2] = "dot";
        words[3] = "dog";
        words[4] = "lot";
        words[5] = "log";
        words[6] = "cog";
        String end = "cog";

        // This method creates a 0/1 symmetric undirected graph 
        // represented by a matrix of size n by n where n is the number
        // of words. A 1 at position (i,j) indicates word[i] and word[j]
        // differ by one letter, otherwise there is a 0. 
        int[][] graph = createGraph(words);

        // find the position of the end word in the array
        // if the position returns -1, the end word is not in the list
        int pos = posInArray(end,words);
        if (pos >= 0) { // if word is in the list
            System.out.println(shortestPath(graph, pos)+1);  
        }
        else
            System.out.println("0"); // word not in list, print 0
    }

    //-------------------posInArray-------------------------
    /* This method find the index of the end word in the 
    array of words.
    Pre : given the end word and an array of words.
    Post: the index where the end word is located in the array is returned
    if the word is not in the array, then -1 is returned.
    */
    public static int posInArray(String end, String[] words) {
        for (int i = 0; i < words.length; i++) 
            if (end.equals(words[i]))
                return i;  
        return -1;
    }

    //-------------------shorestPath---------------------
    /* This method essentially does a BFS to find the length 
    of the length the from the first vertex (index 0) to the
    end vertex (index end).
    Pre: given an undirected graph represented by a double array
    where 1 indicates an edge and 0 no edge. Also, given the index
    of the end vertex of the path (index: end)
    Post: the length of the shortest path is returned from the 
    vertex at index 0 to vertex at index end.
    if there is no path -1 is returned
    */
    public static int shortestPath(int[][] graph, int end) {
        int numVertices = graph.length;
        //  queue of vertices (indices) whose adjacencies are  to be scanned as per 
        // BFS algorithm 
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Breadth first search
        boolean visited[] = new boolean[numVertices];
 
        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from 0
        int pred[] = new int[numVertices];
        int dist[] = new int[numVertices];

        // initially all vertices are unvisited
        // so visitied[i]=false for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
            dist[i] = 0;
            pred[i] = -1;
        }
 
        // now source is first to be visited and
        // distance from source to itself should be 0
        visited[0] = true;
        dist[0] = 0;
        queue.add(0);
 
        // bfs Algorithm
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < numVertices; i++) {
                if ((graph[u][i] == 1) && !visited[i])  { // if there is a connection
                        visited[i] = true;
                        dist[i] = dist[u] + 1;
                        pred[i] = u;
                        queue.add(i);
 
                    // stopping condition (when we find
                    // our destination)
                    if (i == end)
                        return dist[end];
                }
            }
        }
        return -1;
    }
    
    //----------------------createGraph-------------------
    /* This method takes an array of strings and creates an undirected graph.
    The graph will have an edge (1 in the (i,j) position) if the two words
    differ by only one character. 
    The graph will have a 0 in the (i,j) position otherwise.
    Pre : given an array of words with the same length.
    Post: a double array is returned representing the graph described above.
    */
    public static int[][] createGraph(String[] words) {
        int n = words.length;  // number of words in the list
        // we create a graph where 1 represents the words are 1 letter different
        // and 0 represents the words are more than 1 letter different or the same
        int[][] graph = new int[n][n]; 

        // the matrix representing the graph will be symmetric, so
        // we only traverse the upper triangle of the matrix
        for (int i = 0; i < n; i++) 
            for (int j = i+1; j < n; j++)
                if (diffByOne(words[i], words[j])) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }

        return graph;
    }

    //----------------diffByOne-------------------------
    /* This method takes two words (Strings) and determines
    if they differ by one character.
    Pre : given two strings (words)
    Post: true is returned if the words differ by 1 character; false otherwise
    */
    public static boolean diffByOne(String word1, String word2) {
        // count the number of characters words have in common
        int count = 0;
        for (int i = 0; i < word1.length(); i++) 
            if (word1.charAt(i)==word2.charAt(i))
                count = count + 1;
        // if the difference is one, return true; otherwise false
        return (count == word1.length()-1);
    }
}