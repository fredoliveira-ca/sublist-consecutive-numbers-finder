import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubListConsecutiveNumbersFinder {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int arraySize = scanner.nextInt();
        int[] input = new int[arraySize];

        for (int i = 0; i < input.length; i++) {
            int item = scanner.nextInt();

            addItemArray(input, i, item);
        }

        int result = new SubListConsecutiveNumbersFinder().calculateSubarray(input);
        System.out.println("result = " + result);
    }

    private static void addItemArray(int[] array, int i, int item) {
        if(itemAlreadyExist(item, array)) {
            System.out.println("Item already exist, try another:");
            int newItem = scanner.nextInt();

            addItemArray(array, i, newItem);
        } else {
            array[i] = item;
        }
    }

    private static boolean itemAlreadyExist(Integer item, int[] array) {
        OptionalInt any = Arrays.stream(array).filter(item::equals).findAny();

        return any.isPresent();
    }

    public int calculateSubarray(int[] array) {
        List<int[]> list = splitIntoPossibleArrays(array);

        int largestConsecutiveSubListSize = 0;

        for (int[] ints : list) {
            List<Integer> sorted = Arrays.stream(ints)
                    .sorted().boxed()
                    .collect(Collectors.toList());

            largestConsecutiveSubListSize = findLargestConsecutiveSublistSize(largestConsecutiveSubListSize, sorted);
        }

        return largestConsecutiveSubListSize;
    }

    private List<int[]> splitIntoPossibleArrays(int[] array) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i <= array.length; i++) {
            for (int j = i + 1; j <= array.length ; j++) {
                list.add(Arrays.copyOfRange(array, i, j));
            }
        }

        return list;
    }

    private int findLargestConsecutiveSublistSize(int largestConsecutiveSubListSize, List<Integer> sorted) {
        boolean isConsecutive = false;

        int sortedSize = sorted.size();

        for (int j = 0; j < sortedSize; j++) {
            if(j + 1 == sortedSize) {
                if(sortedSize >= largestConsecutiveSubListSize) {
                    largestConsecutiveSubListSize = 1;
                }
                break;
            }

            isConsecutive = sorted.get(j + 1) - sorted.get(j) == 1;

            if(!isConsecutive)
                break;

        }

        if (isConsecutive && sortedSize >= largestConsecutiveSubListSize) {
            largestConsecutiveSubListSize = sortedSize;
        }

        return largestConsecutiveSubListSize;
    }

}
