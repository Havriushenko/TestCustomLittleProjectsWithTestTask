package codewars.kyu7;

import java.util.ArrayList;
import java.util.List;

public class MultiplesOf3Or5 {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    private static int solution(int number) {
        if (number < 3) {
            return 0;
        }
        List<Integer> values = new ArrayList<>();
        for (int index = 3; index < number; index++) {
            if (index % 3 == 0 || index % 5 == 0){
                values.add(index);
            }
        }
        return values.stream().reduce((num1, num2) -> num1 + num2).get();
    }
}
