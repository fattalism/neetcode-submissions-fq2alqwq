class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        
        // int to save max
        int max = -1;
        int counter = 0;

        for(int num : nums){
            counter = (num == 1)? counter + 1: 0;
            max = Math.max(max, counter);
        }

        
        //return the int
        return max;
        
    }
}