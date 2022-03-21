package P17Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =  Integer.parseInt(scanner.nextLine());

        List<String> listOfProduct = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String product = scanner.nextLine();
            listOfProduct.add(product);

        }
        Collections.sort(listOfProduct);

        for (int i = 0; i < listOfProduct.size(); i++) {
            System.out.printf("%d.%s%n",i + 1, listOfProduct.get(i) );
        }
    }
}
