class Solution {
    public String toLowerCase(String s) {
        String ans  = "" ;
        for(int i=0 ;i<s.length() ; i++){
            char c = s.charAt(i) ;
            ans += Character.toLowerCase(c) ;
        }
        return ans ;
    }
}

// ans for storing the each character in the string we use the loop for get the each character in the string we store it in the s character  in the char c and then we use Character.toLowerCase(c).
// to store the lowercase of the string
