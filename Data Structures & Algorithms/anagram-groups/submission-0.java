class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        
        for(String s : strs){

            // count the char occurance pattern
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
            // append the current string to the pattern
            String pattern = Arrays.toString(count); // array to string, 125
            res.putIfAbsent(pattern, new ArrayList<>());
            res.get(pattern).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
