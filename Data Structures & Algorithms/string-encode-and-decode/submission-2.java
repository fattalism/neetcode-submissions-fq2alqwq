class Solution {

    public String encode(List<String> strs) {
        if (strs.size() < 1)
            return "";
        StringBuilder string = new StringBuilder();
        for (String str : strs) {
            string.append(str).append("~");
        }
        return string.toString();

    }

    public List<String> decode(String str) {
        if(str.length() == 0)
        return new ArrayList<>();
        List<String> decoded = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        for(char s:str.toCharArray()){
            if(s == '~'){
                decoded.add(string.toString());
                string = new StringBuilder();
            }
            else{
                string.append(s);
            }
        }
        return decoded;

    }
}
