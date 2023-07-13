package testTasks;

import java.util.Arrays;

public class HashMapDebagTest {

//    private static int[] elementData = new int[10];
//    private static int[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};
//    public static final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;
//    private static final int DEFAULT_CAPACITY = 10;
//
//
//    public static void main(String[] args) {
//        System.out.println(elementData.length);
//        for (int i = 0; i < 30; i++) {
//            int[] grow = grow(elementData.length + 20);
//            elementData = grow;
//            System.out.println(elementData.length);
//        }
//    }

//    private static int[] grow(int minCapacity) {
//        int oldCapacity = elementData.length;
//        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
//            int newCapacity = newLength(oldCapacity,
//                minCapacity - oldCapacity, /* minimum growth */
//                oldCapacity >> 1           /* preferred growth */);
//            return elementData = Arrays.copyOf(elementData, newCapacity);
//        } else {
//            return elementData = new int[Math.max(DEFAULT_CAPACITY, minCapacity)];
//        }
//    }
//
//    public static int newLength(int oldLength, int minGrowth, int prefGrowth) {
//        // preconditions not checked because of inlining
//        // assert oldLength >= 0
//        // assert minGrowth > 0
//
//        int prefLength = oldLength + Math.max(minGrowth, prefGrowth); // might overflow
//        if (0 < prefLength && prefLength <= SOFT_MAX_ARRAY_LENGTH) {
//            return prefLength;
//        } else {
//            // put code cold in a separate method
//            return hugeLength(oldLength, minGrowth);
//        }
//    }
//
//    private static int hugeLength(int oldLength, int minGrowth) {
//        int minLength = oldLength + minGrowth;
//        if (minLength < 0) { // overflow
//            throw new OutOfMemoryError(
//                "Required array length " + oldLength + " + " + minGrowth + " is too large");
//        } else if (minLength <= SOFT_MAX_ARRAY_LENGTH) {
//            return SOFT_MAX_ARRAY_LENGTH;
//        } else {
//            return minLength;
//        }
//    }
}
