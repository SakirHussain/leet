class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        word1_length, word2_length = len(word1), len(word2)
        returnList = []
        word1_pointer, word2_pointer = 0,0

        word = 1
        while word1_pointer < word1_length and word2_pointer < word2_length :
            if word ==1:
                returnList.append(word1[word1_pointer])
                word1_pointer +=1
                word = 2
            else :
                returnList.append(word2[word2_pointer])
                word2_pointer +=1
                word = 1
        
        while word1_pointer < word1_length:
            returnList.append(word1[word1_pointer])
            word1_pointer +=1

        while word2_pointer < word2_length:
            returnList.append(word2[word2_pointer])
            word2_pointer +=1

        return ''.join(returnList)
