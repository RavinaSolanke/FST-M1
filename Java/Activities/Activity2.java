package Activities;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Activity2 {
    public static void main(String[] args) {
        int[] numb = {10, 77, 10, 54, -11, -10};
        System.out.println("Original Array " + Arrays.toString(numb));

        int search = 10;
        int fix = 30;
        System.out.println("Result: " + result(numb, search, fix));
    }

    public static boolean result(int[] numbers, int search, int fix) {
        int temp_sum = 0;
        for (int number : numbers) {
            if (number == search) {
                temp_sum += search;

            }
            if (temp_sum > fix) {
                break;
            }

        }
        return temp_sum == fix;
    }
}
