package P28TextProcessingExercise;

import java.math.BigInteger;
import java.util.Scanner;

public class P05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger number = new BigInteger(scanner.nextLine());
        BigInteger secondNum  =  new BigInteger(scanner.nextLine());

        System.out.println(number.multiply(secondNum));
    }
}
