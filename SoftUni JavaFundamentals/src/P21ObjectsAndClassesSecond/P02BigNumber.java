package P21ObjectsAndClassesSecond;

import java.math.BigInteger;
import java.util.Scanner;

public class P02BigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        BigInteger firstNum = new BigInteger(scanner.nextLine());
        BigInteger secondNum = new BigInteger(scanner.nextLine());

        BigInteger result = new BigInteger(String.valueOf(firstNum.add(secondNum)));

        System.out.println(result);
    }
}
