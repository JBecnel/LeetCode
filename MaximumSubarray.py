class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        mf = [nums[0]]
        #index = [0]
        max = nums[0]
        #max_index = 0
        for i in range(1,len(nums)):
            if mf[i-1] >= 0:
                mf.append(mf[i-1]+nums[i])
            else:
                mf.append(nums[i])
            '''
            if nums[i] > 0:  
                if mf[i-1] <= 0:  # (+, -)
                    mf.append(nums[i])
                    #index.append(i)
                else:              # +, +
                    mf.append(mf[i-1]+nums[i])
                    #index.append(index[i-1])
            else:
                if mf[i-1] >= 0:   # - +
                    mf.append(mf[i-1]+nums[i])
                    #index.append(index[i-1])
                else:             # - -
                    mf.append(nums[i])
                    #index.append(i)
            '''
            if mf[i] > max:
                max = mf[i]
                #max_index = i

        #print(nums[index[max_index]:max_index+1])

        return max
    
if __name__ == "__main__":
    s = Solution()
    print(s.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))
    print(s.maxSubArray([1]))
    print(s.maxSubArray([5,4,-1,7,8]))