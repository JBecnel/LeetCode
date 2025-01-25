import math
class Solution:
    def myPow(self, x: float, n: int) -> float:
        return math.pow(x,n)

if __name__ == '__main__':
    s = Solution();
    print(s.myPow(2,10.0))