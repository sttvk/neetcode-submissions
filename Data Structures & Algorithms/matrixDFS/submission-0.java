class Solution {
    public int countPaths(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        return dfs(grid, 0, 0, visited);
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 1 || visited[row][col]) {
            return 0;
        }

        if (row == rows - 1 && col == cols - 1 && grid[row][col] == 0) {
            return 1;
        }

        visited[row][col] = true;

        int numPaths = 0;
        numPaths += dfs(grid, row + 1, col, visited);
        numPaths += dfs(grid, row - 1, col, visited);
        numPaths += dfs(grid, row, col + 1, visited);
        numPaths += dfs(grid, row, col - 1, visited);

        visited[row][col] = false;

        return numPaths;
    }
}
