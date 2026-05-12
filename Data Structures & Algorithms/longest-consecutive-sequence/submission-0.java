class Solution { 
    public int longestConsecutive(int[] nums) {
        Set<Integer> store = new HashSet<>();
        for (int num : nums) {
            store.add(num);
        }

        int longest = 0;

        for(int n:nums){
            int length = 0;
            while(store.contains(n + length)){
                length++;
            }
            longest = Math.max(length, longest);
        }
        return longest;
        
    }
}
