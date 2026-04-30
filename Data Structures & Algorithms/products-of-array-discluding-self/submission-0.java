class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for(int i =0; i<result.length; i++){
            result[i] = 1;
        }

        int prefix = 1;
        for(int i=0; i<result.length; i++){
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int i=result.length -1; i>=0; i--){
            result[i] *= postfix ;
            postfix *= nums[i];
        }

        return result;
        
    }
}  
