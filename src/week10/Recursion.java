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
