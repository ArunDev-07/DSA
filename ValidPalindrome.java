class Solution {
    public boolean isPalindrome(String s) {
        String clean = "" ;
        for(char c : s.toCharArray()){
              if(Character.isLetterOrDigit(c)){
                clean += Character.toLowerCase(c) ;
              }
        }
        String rev = "" ;
        for(int j = clean.length()-1 ; j>=0 ; j--){
            rev+= clean.charAt(j) ;
        }
        return rev.equals(clean) ;
    }
}


// in this we find the valid palindrome. first we clean the input because input have symbols punctuations so cleaning each letter using character first we change the normal input to chararray
//for each character in the array it checks if the character is letter or digit if it is it add with the clean the storing variable to lowercase. now we get the clean text with lowercase .
//now we reverse it by the normal string reverse method in initialization we reduce the index by -1 the length next decrease the value until the index become 0 then we compare the clean and reverse.
