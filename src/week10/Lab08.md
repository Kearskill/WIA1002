**<ins>Lab: Recursion (Fundamental)</ins>**

1. Create a recursive function that accepts a String parameter, and substitute any of the
   lowercase “a” (no applicable for uppercase "A") found with “i” char. Example:
```text
   substituteAI ("flabbergasted ") → "flibbergisted "
   substituteAI ("Astronaut ") → " Astroniut"
```

```java
package week10;

public class SubstituteAI {
    public static void main(String[] args) {
        System.out.println(substituteAI("flabbergasted"));
        System.out.println(substituteAI("Astronaut"));
    }
    public static String substituteAI (String str) {
        //Base Case:
        if (str.length()==0) {
            return str;
        }
        //Recursive Case:
        else if (str.charAt(0) == ('a')) {
            return 'i' + substituteAI(str.substring(1));
        }
        else {
            return str.charAt(0) + substituteAI(str.substring(1));
        }
    }
}
```

2. Write a recursive method called permuteString() that will find and print all the possibilities to
   arrange the letters of a given word. Example:<br>
   Input String : “ABC”<br>
   Output Permutation :<br>
```text
ABC  
ACB  
BAC  
BCA  
CAB  
CBA  
```   
Tips:  

a) Take out the first char from String and permute the remaining chars.<br>
   If String = “ABC”<br>
   First char = A and remaining chars permutations are BC and CB.<br>

b) Insert first char in the available positions in the permutations.<br>
   BC -> ABC, BAC, BCA<br>
   CB -> ACB, CAB, CBA<br>

c) Then write a recursive function call to return the permutations and then another function call to insert
   the first characters to get the complete list of permutations.<br>

```java
package week10;

public class Recursion {
    public static void permuteString(String beginningString, String endingString) {
        if (endingString.length() <= 1) {
            System.out.println(beginningString + endingString);
        }
        else {
            for (int i = 0; i < endingString.length(); i++) {
                String newString = endingString.substring(0, i) + endingString.substring(i + 1);
                permuteString(beginningString + endingString.charAt(i), newString);
            }
        }
    }
    public static void main(String[] args) {
        permuteString("", "ABC");
    }
}
```


3. Write a recursive method called exponent(x,y) to perform exponentiation return xy, assuming
   y >= 0. Example:<br>

   `exponent(10,3) → will produce an output of 1000`

   Method signature as follows:

   `public static long exponent(int x, int m) {
   }`

```java
 public static long exponent(int x, int m) {
    if (m == 0) {
        return 1;
    }
    if (m == 1) {
        return x;
    }
    return x * exponent(x, m - 1);
}
```