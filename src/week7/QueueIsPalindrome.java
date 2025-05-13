package week7;
import java.util.LinkedList;
import java.util.Queue;

public class QueueIsPalindrome {
    private static boolean isPalindrome(String str){
        str = str.toLowerCase();
        Queue<Character> queue = new LinkedList<>();

        for (char c : str.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                queue.offer(c);
            }
        }

        StringBuilder reversedStr = new StringBuilder();
        while(!queue.isEmpty()){
            reversedStr.append(queue.poll());
        }
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]","");
        return cleanedStr.equals(reversedStr.reverse().toString()); // if the reverse is the same as reverse of the reverse
    }

    public static void main(String[] args) {
        String[] testCases = {
                "race car",
                "not a palindrome",
                "A man, a plan, a canal. Panama",
                "never odd or even",
                "nope",
                "almostomla",
                "My age is 0, 0 si ega ym.",
                "1 eye for of 1 eye.",
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Is \"" + testCases[i] + "\" palindrome: " + isPalindrome(testCases[i]));
        }
    }
}
