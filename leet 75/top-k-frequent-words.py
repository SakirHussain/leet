class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        count = {}
        freq = [[] for i in range(len(words) + 1)]

        for word in words:
            count[word] = 1 + count.get(word, 0)

        for word, count in count.items():
            freq[count].append(word)
        
        result = []

        for i in range(len(freq) - 1, 0, -1):
            freq[i].sort()
            for j in freq[i]:
                result.append(j)
                if(len(result) == k):
                    return result