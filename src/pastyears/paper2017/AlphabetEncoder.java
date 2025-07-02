package pastyears.paper2017;

import java.util.ArrayList;
import java.util.Scanner;

public class AlphabetEncoder {
    public static void main(String[] args) {
        Character[] alphabetArray = new Character[26];

        for (int i = 0; i < 26; i++) {
            alphabetArray[i] = (char) ('a' + i);
        }

        Queue<Character> alphabetQueue = new Queue<>(alphabetArray);

        System.out.println("Queue: "+ alphabetQueue);

        System.out.print("Index: [");
        for (int i = 0; i < 26; i++) {
            System.out.print(i);
            if (i<25) System.out.print(", ");
        }
        System.out.println("]");

        Scanner sc = new Scanner(System.in);
        System.out.print("How many times will you enter a number: ");
        int n = sc.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();

        if (n==0){ // weird edge case
            System.out.println("(Please enter your number(s) between 0-26.)");
            System.out.println("The entered numbers are " + numbers);
            System.out.println("The deciphered values are -Cannot decipher. No value was entered.-");
            return;
        }

        System.out.println("(Please enter your number(s) between 0-26.)");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + " >> ");
            int num = sc.nextInt();
            numbers.add(num);
        }

        // Display entered numbers
        System.out.println("The entered numbers are " + numbers);

        // iv) Decipher values
        StringBuilder result = new StringBuilder();
        for (int index : numbers) {
            if (index >= 0 && index < alphabetQueue.getSize()) {
                result.append(alphabetQueue.getElement(index));
            } else {
                result.append('?'); // invalid index
            }
        }

        System.out.println("The deciphered values are " + result.toString());
    }
}
