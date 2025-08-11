class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        d = {}
        pairs = 0

        for num in nums :
            diff = k - num
            if(diff in d and d[diff] > 0):
                d[diff] -= 1
                pairs+=1
            else:
                # d[num] = 0
                d[num] = d.get(num , 0) + 1

        return pairs