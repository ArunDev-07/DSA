package com.example.DSA_JAVA.Recursion;

/*
 PROBLEM:
 Remove the substring "apple" from the given string using recursion.

 INPUT  : "baccappled"
 OUTPUT : "baccd"

 CONCEPT USED:
 - Recursion
 - String methods: startsWith(), substring()
*/

public class SubsetRecursion {

    public static void main(String[] args) {

        // Input string
        String words = "baccappled";

        // Answer string (initially empty)
        String ans = "";

        // Calling recursive function
        String answer = recurse(words, ans);

        // Printing final result
        System.out.println(answer); // baccd
    }

    /*
     RECURSIVE FUNCTION
     words -> remaining string to process
     ans   -> answer formed so far
    */
    static String recurse(String words, String ans){

        // BASE CONDITION:
        // If the string becomes empty, return the accumulated answer
        if(words.isEmpty()){
            return ans;
        }

        // If the current string starts with "apple"
        // skip 5 characters (length of "apple")
        if(words.startsWith("apple")){
            return recurse(words.substring(5), ans);
        }
        else{
            // Take first character and add to answer
            // Move to the next character
            return recurse(words.substring(1), ans + words.charAt(0));
        }
    }
}

/*
--------------------------------------------------
ONE PARAGRAPH EXPLANATION:

This program removes the substring "apple" from a given string using recursion.
The recursive function processes the string character by character. If the current
string starts with "apple", it skips those five characters at once using substring(5).
Otherwise, it adds the first character to the answer and continues recursion with the
remaining string. The recursion stops when the string becomes empty, and the accumulated
answer is returned. This approach avoids loops and uses pure recursion with string slicing.
--------------------------------------------------

DRY RUN (Step-by-Step):

Initial call:
words = "baccappled"
ans   = ""

1️⃣ words = "baccappled"
    startsWith("apple") ❌
    ans = "b"
    recurse("accappled", "b")

2️⃣ words = "accappled"
    startsWith("apple") ❌
    ans = "ba"
    recurse("ccappled", "ba")

3️⃣ words = "ccappled"
    startsWith("apple") ❌
    ans = "bac"
    recurse("cappled", "bac")

4️⃣ words = "cappled"
    startsWith("apple") ❌
    ans = "bacc"
    recurse("appled", "bacc")

5️⃣ words = "appled"
    startsWith("apple") ✅
    skip "apple"
    recurse("d", "bacc")

6️⃣ words = "d"
    startsWith("apple") ❌
    ans = "baccd"
    recurse("", "baccd")

7️⃣ words = ""
    base condition hit
    return "baccd"

FINAL OUTPUT:
baccd
--------------------------------------------------
*/
