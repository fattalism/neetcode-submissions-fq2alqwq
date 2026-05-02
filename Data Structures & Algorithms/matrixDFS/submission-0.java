class Solution {
    public int countPaths(int[][] grid) {
        return helper(grid, 0,0, new HashSet<>());
    }

    public int helper(int[][] grid, int r, int c, Set<String> visited){
        int ROWS = grid.length, COLS = grid[0].length;
        // are we out of bound?
        if(Math.min(r,c) < 0 || r == ROWS || c == COLS)
        return 0;
        // are we hitting a blocked roud?
        if(grid[r][c] == 1)
        return 0;
        // did we visit this?
        if(visited.contains(r + "," + c))
        return 0;
        // are we at the dst?
        if(r == ROWS -1 && c == COLS -1)
        return 1;

        // recursive calls
        visited.add(r + "," + c);

        int count = 0;
        count += helper(grid, r + 1, c, visited);
        count += helper(grid, r - 1, c, visited);
        count += helper(grid, r, c + 1, visited);
        count += helper(grid, r, c  - 1, visited);

        visited.remove(r + "," + c);
        return count;

    }
}
