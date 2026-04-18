class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        
        // int to save max
        int max = -1;
        int counter = 0;

        for(int num : nums){
            if(num == 1)
            counter++;
            else
            counter = 0;

            max = Math.max(max, counter);
        }

        
        //return the int
        return max;
        
    }
}