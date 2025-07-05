package week14;

import java.util.Random;

public class generaterandomnumber {
    public static void main(String[] args) {
        Random rand = new Random();
        double[] numbers = new double[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextDouble(0.0,6.0);
        }
        for(double e: numbers){
            System.out.printf("%.1f ", e);
        }
    }
}
