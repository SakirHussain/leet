class Solution:
    def numTrees(self, n: int) -> int:
        numTree = [1] * (n+1)

        for nodes in range(2, n+1):
            sum = 0
            for root in range(1, nodes+1):
                left = root - 1
                right = nodes - root
                sum += numTree[left] * numTree[right]
            numTree[nodes] = sum
        return numTree[n]
        