class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = defaultdict(list)

        for s in strs:
            count = [0] * 26

            for c in s:
                count[ord(c) - ord('a')] += 1
            
            result[tuple(count)].append(s)

        return list(result.values())
        
        
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hm = {}

        for i in strs:
            temp = ''.join(sorted(i))
            hm[temp] = hm.get(temp, []) + [i]

        final = []
        for v in hm.values():
            final.append(v)

        return final