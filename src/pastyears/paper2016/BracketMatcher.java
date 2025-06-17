package pastyears.paper2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class BracketMatcher {

    private static boolean isBalanced(String s){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '<'){
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == '>'){
                if (!st.empty() && (
                    (st.peek() == '[' && s.charAt(i) == ']') ||
                    (st.peek() == '{' && s.charAt(i) == '}') ||
                    (st.peek() == '(' && s.charAt(i) == ')') ||
                    (st.peek() == '<' && s.charAt(i) == '>'))
                ) {
                    st.pop();
                } else{
                    return false;
                }
            }

        }
        return st.empty(); // true if balanced, false if unbalanced
    }

    private static boolean hasBrackets(String s){
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '<' || s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == '>'){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String filename = "src/pastyears/paper2016/BracMatch.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String s = "";
            while ((s = br.readLine()) != null){
                System.out.println(s);
                if(!hasBrackets(s)){
                    System.out.println("There is no bracket in the input");
                } else if (isBalanced(s)) {
                    System.out.println("YES - all matched!");
                } else {
                    System.out.println("Not all brackets are matched");
                }
                System.out.println();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
