package codewars.kyu7;

public class Largest5DigitNumber {

    public static void main(String[] args) {
        System.out.println(solve("283910") == 83910);
        System.out.println(solve("1234567890") == 67890);
        System.out.println(solve("731674765") == 74765);
    }

    public static int solve(final String digits) {
        if (digits == null && digits.length() <= 5) {
            return Integer.valueOf(digits);
        }
        int bigNumber = digits.charAt(0);
        int indexBigNumber = 0;
        for (int index = 1; index <= digits.length() - 5; index++) {
            if (bigNumber < digits.charAt(index)) {
                bigNumber = digits.charAt(index);
                indexBigNumber = index;
            }
            if (bigNumber == digits.charAt(index) && isNewIndexBiggerThenOld(digits, indexBigNumber, index)) {
                indexBigNumber = index;
            }
        }
        return Integer.valueOf(digits.substring(indexBigNumber, indexBigNumber + 5)); // you code here
    }

    private static boolean isNewIndexBiggerThenOld(String digits, int indexBigNumber, int index) {
        int oldNumber = Integer.valueOf(digits.substring(indexBigNumber, indexBigNumber + 5));
        int newNumber = Integer.valueOf(digits.substring(index, index + 5));
        return oldNumber < newNumber;
    }
}
