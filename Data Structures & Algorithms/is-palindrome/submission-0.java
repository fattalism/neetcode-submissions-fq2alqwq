class Solution {
    public boolean isPalindrome(String s) {
        // strip the text out of spaces
        String strippedText = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // use two pointers
        int i = 0;
        int j = strippedText.length() - 1;
        // at each step check if the two pointers match else return false
        while(i < strippedText.length() && i<j){
            if(strippedText.charAt(i) != strippedText.charAt(j))
            return false;
            else{
                i++;
                j--;
            }
        }
        return true;
        
    }
}
