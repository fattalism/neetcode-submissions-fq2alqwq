class Solution {
    public int[] replaceElements(int[] arr) {
        // another two pointers hehe :3

        int rightMax = -1;
        
        for(int i = arr.length -1; i>=0; i--){
            int curr = arr[i];
            arr[i] = rightMax;
            rightMax = Math.max(rightMax, curr);
        }

        return arr;
        
    }
}