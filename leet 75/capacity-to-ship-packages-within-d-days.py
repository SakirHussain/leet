class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l, r = max(weights), sum(weights)
        result = r

        def canship(cap):
            ships = 1
            currCap = cap
            for w in weights:
                if currCap - w < 0:
                    ships+=1
                    currCap = cap
                currCap -= w
            return ships <= days

        while l <= r:
            capacity = (l+r)//2

            if canship(capacity):
                result = min(result, capacity)
                r = capacity - 1
            else:
                l = capacity + 1
        
        return result
