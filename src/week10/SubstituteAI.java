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
