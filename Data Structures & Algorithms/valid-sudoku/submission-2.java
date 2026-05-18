class Solution {
    public boolean isValidSudoku(char[][] board) {
        // set for rows
        // if num is repeated in the same row return false
        for (int rows = 0; rows < 9; rows++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[rows][i] == '.')
                    continue;
                if (seen.contains(board[rows][i]))
                    return false;
                seen.add(board[rows][i]);
            }
        }
        // set for columns
        for (int cols = 0; cols < 9; cols++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][cols] == '.')
                    continue;
                if (seen.contains(board[i][cols]))
                    return false;
                seen.add(board[i][cols]);
            }
        }
        // if num is repeated in the same cols return false
        // set for 9x9 grid
        // if num is repeated in the same grid return false
        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for(int i =0; i< 3; i++){
                for(int j = 0; j<3; j++){
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if(board[row][col] == '.') continue;
                    if(seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}