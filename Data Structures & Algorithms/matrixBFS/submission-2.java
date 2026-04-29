class Solution {
    public int shortestPath(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new ArrayDeque();
        boolean[][] visited = new boolean[rows][cols];

        q.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        int[][] dirs = {{ 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }};
        int pathLen = 0;

        while (!q.isEmpty()) {
            int qLen = q.size();
            
            for (int i = 0; i < qLen; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                if (row == rows - 1 && col == cols - 1) {
                    return pathLen;
                }

                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newCol < 0 || 
                        newRow >= rows || newCol >= cols || 
                        visited[newRow][newCol] || grid[row][col] == 1) {
                        continue;
                    }

                    q.offer(new int[] { newRow, newCol }); 
                    visited[newRow][newCol] = true;
                }
            }
            
            pathLen++;
        }
        
        return -1;
    }
}
