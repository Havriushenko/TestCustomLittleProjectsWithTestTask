package sortandsearch;

import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("Index of element is: " + binarySearch(getListOfElements(), 15));
    }

    private static List<Integer> getListOfElements() {
        return List.of(1, 2, 3, 5, 7, 8, 15, 32, 54, 64, 88, 128, 512, 567, 577);
    }

    private static Integer binarySearch(List<Integer> list, int search) {
        int low = 0;
        int high = list.size() - 1;
        int numberOfIteration = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = list.get(mid);
            if (result == search) {
                System.out.println("Last iteration is: " +  numberOfIteration);
                return result;
            } else if (result < search) {
                low = ++mid;
            } else if (result > search) {
                high = --mid;
            }
            System.out.println("Iteration number is: " + numberOfIteration++);
        }
        throw new IllegalArgumentException("Value: " + search + ", not found in array!");
    }
}
