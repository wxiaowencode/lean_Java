import java.util.Random;
import java.util.Scanner;

public class CodeTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of the list > ");
        int n = s.nextInt();
        int[] list = new int[n];
        System.out.println("Unsorted List: ");
        for (int i = 0; i <= n - 1; i++) {
            list[i] = (int) (Math.random() * n + 1);
            System.out.print(list[i] + " ");
        }
        System.out.println("");
        System.out.print("Enter the item to search for > ");
        int data = s.nextInt();
        for (int i = 1; i <= n - 1; i++) {
            if (data == list[i]) {
                System.out.println("LinearSearch took " + (i + 1) + " steps.");
                System.out.println("Item found at index " + i + ".");
            } else {
                continue;
            }
        }
        System.out.println("Sorted List: ");
        for (int i = 0; i <= n - 1; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (list[i] > list[j]) {
                    int tmp = 0;
                    tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                } else {
                    continue;
                }
            }
            System.out.print(list[i] + " ");
        }
        int low = 0;
        int high = n - 1;
        int mid = (low + high) / 2;
        int steps = 0;
        while (low <= high) {
            steps++;
            if (list[mid] > data) {
                high = mid - 1;
            } else if (list[mid] < data) {
                low = mid + 1;
            } else {
                break;
            }
            mid = (low + high) / 2;
        }
        System.out.println("");
        System.out.println("BinarySearch took " + steps + " steps.");
        System.out.println("Item found at index " + mid + ".");
    }
}
