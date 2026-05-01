class Solution {
    int[][] heights;
    int rows;
    int cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.rows = heights.length;
        this.cols = heights[0].length;

        boolean[][] inPacific = new boolean[rows][cols];
        boolean[][] inAtlantic = new boolean[rows][cols];

        List<List<Integer>> res = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            dfs(row, 0, heights[row][0], inPacific);
            dfs(row, cols - 1, heights[row][cols - 1], inAtlantic);
        }

        for (int col = 0; col < cols; col++) {
            dfs(0, col, heights[0][col], inPacific);
            dfs(rows - 1, col, heights[rows - 1][col], inAtlantic);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (inPacific[row][col] && inAtlantic[row][col]) {
                    res.add(Arrays.asList(row, col));
                }
            }
        }

        return res;
    }

    private void dfs (int row, int col, int ht, boolean[][] visit) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || visit[row][col] || ht > heights[row][col]) {
            return;
        }

        visit[row][col] = true;
        dfs(row + 1, col, heights[row][col], visit);
        dfs(row - 1, col, heights[row][col], visit);
        dfs(row, col + 1, heights[row][col], visit);
        dfs(row, col - 1, heights[row][col], visit);
    }
}
