class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        if (m*k) > len(bloomDay):
            return -1
        
        l, r = min(bloomDay), max(bloomDay)
        result = r

        def canFormBouq(days):
            count = 0
            possible = 0
            for day in bloomDay:
                if day <= days:
                    count +=1
                else:
                    possible += count // k
                    count = 0

            possible += count // k
            return (possible >= m)


        while l <= r:
            days = (l+r)//2
            
            if canFormBouq(days):
                result = min(result, days)
                r = days - 1
            else :
                l = days + 1
        
        return result