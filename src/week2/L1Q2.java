package week2;

import java.io.*;
import java.util.Scanner;

/*1. Write a program to read a text file (namely, text1.txt) that has a sequence of characters that
are delimited (separated) by special character (i.e., comma, semi colons, spaces, etc.). The
number of characters can vary from 1 to N. Your task is to :
a. Calculate the number of characters retrieved from text1.txt without the special
characters.
b. Display all characters from the text file without the special characters*/

public class L1Q2 {
    public static void main(String[] args) {
        try {
            // scanning files 1-4
            File file1 = new File("src/week2/text1.txt");
            Scanner readFile1 = new Scanner(file1);

            File file2 = new File("src/week2/text2.txt");
            Scanner readFile2 = new Scanner(file2);

            File file3 = new File("src/week2/text3.txt");
            Scanner readFile3 = new Scanner(file3);

            File file4 = new File("src/week2/text4.txt");
            Scanner readFile4 = new Scanner(file4);

            // text1.txt (character separated by comma)
            System.out.println("Text 1 from text1.txt :");
            while(readFile1.hasNextLine()){
                String curr = readFile1.nextLine(); // curr = current
                curr = curr.replace(",","");
                System.out.println(curr);
            }
            System.out.println("End of text 1.\n\n");

            // text2.txt (numbers separated by comma and space)
            System.out.println("Text 2 from text2.txt :");
            while(readFile2.hasNextLine()) {
                String curr = readFile2.nextLine(); // curr = current
                curr = curr.replace(", ", " ");
                System.out.println(curr);
                System.out.println("End of text 2.\n\n");
            }

            // text3.txt ((real numbers separated by semicolon and space)
            System.out.println("Text 3 from text3.txt :");
            while (readFile3.hasNextLine()) {
                String curr = readFile3.nextLine(); // curr = current
                curr = curr.replace("; ", " ");
                System.out.println(curr);
            }
            System.out.println("End of text 3.\n\n");

            // text4.txt (alphabets separated by numbers)
            System.out.println("Text 4 from text4.txt :");
            while (readFile4.hasNextLine()) {
                String curr = readFile4.nextLine(); // curr = current
                curr = alphabetOnly(curr);
                System.out.println(curr);
            }
            System.out.println("End of text 4.\n");
            System.out.println("End of program.");
        } catch (FileNotFoundException err) {
            System.out.println("Errata : " + err);
        }
    }
    private static String alphabetOnly(String lines){
        String res = "";
        for (int i = 0; i < lines.length(); i++) {
            if (Character.isAlphabetic(lines.charAt(i))){
                res += lines.charAt(i);
            }
        }
        return res;
    }
}
