import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        // Create a stack to store opening brackets
        Stack<Character> st = new Stack<>();

        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If it is an opening bracket, push it to the stack
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } 
            // If it is a closing parenthesis ')'
            else if (c == ')') {
                // Check if the top of stack has the matching '('
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop(); // matched, remove from stack
                } else {
                    return false; // mismatch or stack empty → invalid
                }
            } 
            // If it is a closing bracket ']'
            else if (c == ']') {
                // Check if the top of stack has the matching '['
                if (!st.isEmpty() && st.peek() == '[') {
                    st.pop(); // matched, remove
                } else {
                    return false; // mismatch or stack empty → invalid
                }
            } 
            // If it is a closing brace '}'
            else if (c == '}') {
                // Check if the top of stack has the matching '{'
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop(); // matched, remove
                } else {
                    return false; // mismatch or stack empty → invalid
                }
            }
        }

        // If stack is empty, all brackets matched → valid
        // Otherwise, there are unmatched opening brackets → invalid
        return st.isEmpty();

        /*
         Example to understand:

         Input: s = "{[()]}"

         Step 1: '{' → push → stack = ['{']
         Step 2: '[' → push → stack = ['{', '[']
         Step 3: '(' → push → stack = ['{', '[', '(']
         Step 4: ')' → matches '(' → pop → stack = ['{', '[']
         Step 5: ']' → matches '[' → pop → stack = ['{']
         Step 6: '}' → matches '{' → pop → stack = []

         Stack empty at end → return true ✅

         Failing Example:

         Input: s = "{[(])}"

         Step 1: '{' → push → stack = ['{']
         Step 2: '[' → push → stack = ['{','[']
         Step 3: '(' → push → stack = ['{','[','(']
         Step 4: ']' → top is '(' → mismatch → return false ❌
        */
    }
}
