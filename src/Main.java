import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class BubbleSort {
    public int[] sortArray(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return arr;
    }
}


public class Main {
    public static void main(String[] args) {
        // init
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        BubbleSort bbSort = new BubbleSort();
        rand.setSeed(39102301);

        // Get user configration
        int element_num;
        int element_max_num;

        // start program
        boolean stop = false;
        do {
            System.out.print("Input element num: ");
            element_num = sc.nextInt();
            System.out.print("Input element max num: ");
            element_max_num = sc.nextInt();
            sc.nextLine(); // clean buffer..

            // Random integer generate
            System.out.println("Generating random array . . .");
            int[] rand_arr = new int[element_num];
            for (int i = 0; i < element_num; i++)
                rand_arr[i] = rand.nextInt(element_max_num);
            System.out.println("Generated random array.\n" + Arrays.toString(rand_arr));

            // Bubble sort
            System.out.println("Bubble sorting . . .");
            int[] sorted_arr = new int[element_num];
            sorted_arr = bbSort.sortArray(rand_arr);
            System.out.println("Bubble sorted!\n" + Arrays.toString(sorted_arr));

            System.out.print("Retry? [y/n]: ");
            String user_stop = sc.nextLine();
            if (user_stop.equalsIgnoreCase("y")) stop = true;
        } while (!stop);

        // good byeeeee
        System.out.println("Good bye...");
    }
}