class Solution {
    public int maxArea(int[] heights) {
        int pool = 0;

        int l = 0, r = heights.length - 1;

        while (l < r) {
            int width = r - l;
            int water = Math.min(heights[l], heights[r]);
            int tempPool = width * water;
            pool = Math.max(tempPool, pool);
            if (heights[l] > heights[r])
                r--;
            else
                l++;
        }
        return pool;
    }
}
