# https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
'''
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

 

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].

 

Constraints:

1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.'''


class Solution:
    def findSubstring(self, s: str, words: list[str]) -> list[int]:
        indices = [ ]
        n = len(s)
        m = len(words[0])

        word_count = {}
        for word in words:
            if word in word_count:
                word_count[word] = word_count[word] + 1
            else:
                word_count[word] = 1
        
        sum = 0
        for w in words:
            sum = sum + len(w)

        index = 0
        while (index < n):
            wc = word_count.copy()
            if match(s, wc, index):
                indices.append(index)
                match_indices = [ ]
                process_match(s, wc, index, match_indices)
                print(match_indices)
                if len(match_indices) > 0:
                    indices = indices + match_indices
                    index = indices[-1] + sum 
                else:
                    index = index + sum
                
            else:
                index = index + 1

        return indices 
    
def process_match(s, word_count, index, indices):
    sum = 0
    for w in words:
        sum = sum + len(w)
    
    for word, count in word_count.items():
        m = len(word)
        if s[index:].startswith(word) and s[(index+m):(sum+m)].endswith(word):
            index = index + m
            indices.append(index + m)
            

def match(s : str, word_count, index : int) -> bool:
    max_count = max(word_count.values())

    if 0 == max_count:
        return True
    elif index >= len(s):
        return False
    else:
        for word, count in word_count.items():
            m = len(word)
            if count > 0 and s[index:].startswith(word):
                word_count[word] = count -1
                return match(s, word_count, index+m )


        return False 
            
if __name__ == "__main__":
    s = "barfoothefoobarman" 
    words = ["foo","bar"]
    sol = Solution()
    print(sol.findSubstring(s, words))

    s = "barfoofoobarthefoobarman" 
    words = ["bar","foo","the"]
    print(sol.findSubstring(s, words))

    s = "wordgoodgoodgoodbestword" 
    words = ["word","good","best","word"]
    print(sol.findSubstring(s, words))

    s = "lingmindraboofooowingdingbarrwingmonkeypoundcake" 
    words = ["fooo","barr","wing","ding","wing"]
    print(sol.findSubstring(s, words))
