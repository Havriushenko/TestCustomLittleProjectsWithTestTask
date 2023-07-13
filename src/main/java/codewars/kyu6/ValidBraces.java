package codewars.kyu6;

public class ValidBraces {

    private static String START = "{[(";
    private static String END = ")]}";


    public static void main(String[] args) {
        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("([{}])"));
        System.out.println(isValid("(}"));
        System.out.println(isValid("[(])"));
        System.out.println(isValid("[({})](]"));
    }

    public static boolean isValid(String braces) {

        return false;
    }

}
