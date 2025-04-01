package week3;

public class MyArray{
    /*
        main method that creates 3 arrays of
        a) integer containing the numbers 1,2,3,4 and 5
        b) string containing names, Jane, Tom and Bob
        c) character containing alphabet, a, b and c
    */
    public static void main(String[] args) {
//        int[] integerArr = {1,2,3,4,5}; // this is banned, don't use primitive
//        char[] charArr = {'a','b','c'}; // this is banned, use Capital Character

        Integer[] integerArr = {1,2,3,4,5};
        String[] stringArr = {"Jane", "Tom", "Bob"};
        Character[] charArr = {'a','b','c'};

        System.out.println("Integer array: ");
        MyArray.<Integer>listAll(integerArr); // you can remove <Integer>, Explicit type arguments can be inferred
        System.out.println("String array: ");
        MyArray.<String>listAll(stringArr);
        System.out.println("Character array: ");
        MyArray.<Character>listAll(charArr);
    }
    private static <E> void listAll(E[] list){
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+" ");
        }
        System.out.println();
        System.out.println();
    }
}
