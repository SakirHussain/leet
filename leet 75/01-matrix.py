class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = deque()
        visited = set()

        directions = [[1,0], [0,1], [-1,0], [0, -1]]

        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append([i,j,0])
                elif mat[i][j] == 1:
                    mat[i][j] = float('inf')
        
        while q:
            r, c, length = q.popleft()
            if mat[r][c] > length:
                mat[r][c] = length

            for dr, dc in directions:
                row = r + dr
                col = c + dc
                if row < 0 or row == len(mat) or col < 0 or col == len(mat[0]):
                    continue

                if mat[row][col] == float('inf') and (row, col) not in visited:
                    q.append([row, col, length+1])
                    visited.add((row, col))

        
        return mat
