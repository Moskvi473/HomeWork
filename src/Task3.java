import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 7, 3, 2, 0, 4, 9, 6};
        System.out.println("Второй по величине элемент: " + findSecondLargest(numbers));
    }

    public static int findSecondLargest(int[] array) {
        Arrays.sort(array);
        return array[array.length - 2];
    }
}