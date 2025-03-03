'''https://leetcode.com/problems/word-break/description/
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:'''
class Solution:
    def wordBreak2(self, s: str, wordDict: list[str]) -> bool:
        text = s
        while len(text) > 0:
            found = False
            for word in wordDict:
                if text.startswith(word):
                    text = text[len(word):]
                    found = True
                    break
            if not found:
                return False
        return True
    
    def wordBreak3(self, s: str, wordDict: list[str]) -> bool:
        if len(s) == 0:
            return True 
        
        for word in wordDict:
            found = False
            if s.startswith(word):
                found = self.wordBreak(s[len(word):], wordDict)
            if found:
                return True
            
        return False
    
    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        mem_func = [0]*len(s)
        return self.wordBreakUtil(s, 0, wordDict, mem_func)
    
    def wordBreakUtil(self, s: str, index : int , wordDict: list[str], mem_func) -> bool:
        if index == len(s):
            return True 
        elif mem_func[index] != 0:
            return False
            
        for word in wordDict:
            found = False
            if s[index:].startswith(word):
                found = self.wordBreakUtil(s, index+len(word), wordDict, mem_func)
            if found:
                return True
        
        mem_func[index] = -1   
        return False
    
if __name__ == "__main__":
    s = Solution()
    print(s.wordBreak("leetcode", ["leet","code"]))
    print(s.wordBreak("applepenapple", ["apple","pen"]))
    print(s.wordBreak("catsandog", ["cats","dog","sand","and","cat"]))
    print(s.wordBreak("cars", ["car","ca","rs"]))
    string = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    wordDict = ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    print(s.wordBreak(string, wordDict))