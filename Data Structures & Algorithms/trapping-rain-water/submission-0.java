class Solution {
    public int trap(int[] height) {
        if( height.length == 0)
        return 0;


        int l = 0;
        int r = height.length - 1;

        int maxL = height[l];
        int maxR = height[r];

        int trappedWater = 0;
        

        while(l<r){
            
            if(maxL < maxR)
            {
                l++;
                maxL = Math.max(maxL, height[l]);
                trappedWater += maxL - height[l];
            }
            else
            {
                r--;
                maxR = Math.max(maxR, height[r]);
                trappedWater += maxR - height[r];
            }

        }
        return trappedWater;
        
    }
}
