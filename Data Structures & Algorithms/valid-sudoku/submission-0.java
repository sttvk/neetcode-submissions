class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char c = board[row][col];

                if (c == '.') {
                    continue;
                }

                if (!set.add(c + " in row " + row) || 
                    !set.add(c + " in col " + col) || 
                    !set.add(c + " in box " + row / 3 + " - " + col / 3)) {
                    return false;
                }
            }
        }

        return true;
    }
}
