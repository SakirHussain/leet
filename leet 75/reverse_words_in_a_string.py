class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()
        words = s.split()
        words = words[::-1]
        return " ".join(words)

