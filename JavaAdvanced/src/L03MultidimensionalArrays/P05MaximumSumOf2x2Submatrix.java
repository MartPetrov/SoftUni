package L03MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");

        int[][] matrix = new int[Integer.parseInt(data[0])][Integer.parseInt(data[1])];

        for (int i = 0; i <matrix.length ; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i]=arr;
        }
        int sum =0;
        int biggestSum=0;
        String[] numbers = new String[4];

        for (int i = 0; i <matrix.length ; i++) {
            int[] first = matrix[i];
            if(i!=matrix.length-1){
                int[] second = matrix[i+1];

                int counter=0;
                while (counter<first.length-1){

                    sum+=first[counter];
                    sum+=second[counter];

                    sum+=first[counter+1];
                    sum+=second[counter+1];

                    if(sum>biggestSum){
                        biggestSum=sum;
                        numbers[0] = first[counter]+"";
                        numbers[1] = first[counter+1]+"";
                        numbers[2] = second[counter]+"";
                        numbers[3] = second[counter+1]+"";
                    }
                    sum=0;
                    counter++;
                }

            }else{
                break;
            }


        }
        System.out.println(numbers[0]+" "+numbers[1]);
        System.out.println(numbers[2]+" "+numbers[3]);

        System.out.println(biggestSum);

    }
}
