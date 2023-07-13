package reversesArray;

public class ReversArray {

    public Object[] reversArray(Object[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Object revObject = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = revObject;
        }
        return array;
    }
}
