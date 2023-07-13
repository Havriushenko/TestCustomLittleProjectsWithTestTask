package interviewtask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterviewTestTask1 {
    /**
     * <p>
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == target.
     * <p>
     * Notice that the solution set must not contain duplicate triplets.
     * <p>
     * Example:
     * <p>
     * Input: nums = [-1,0,2,-1,-4,1,0], target = 0
     * <p>
     * Output: [[-1,-1,2],[-1,0,1]]
     * <p>
     * Explanation:
     * <p>
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * <p>
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * <p>
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * <p>
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * <p>
     * Notice that the order of the output and the order of the triplets does not matter.
     */

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 2, -1, -4, 1};
        System.out.println(searchArraysSumEqualsValue(array, 0));
    }

    private static List<List<Integer>> searchArraysSumEqualsValue(int[] array, int value) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = 1 + i; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (isElementsAreCorrect(array[i], array[j], array[k], value, result)) {
                        result.add(List.of(array[i], array[j], array[k]));
                    }
                }
            }
        }
        return result;
    }

    private static boolean isElementsAreCorrect(int firstNumber, int secondNumber, int thirdNumber,
                                                int value, List<List<Integer>> triplets) {
        return sumOfElementsIsEqualsValue(firstNumber, secondNumber, thirdNumber, value)
            && !isTripletsAreUnique(List.of(firstNumber, secondNumber, thirdNumber), triplets);
    }

    private static boolean isTripletsAreUnique(List<Integer> values, List<List<Integer>> triplets) {
        return triplets.contains(values);
    }

    private static boolean sumOfElementsIsEqualsValue(int a, int b, int c, int value) {
        return a + b + c == value;
    }
}
