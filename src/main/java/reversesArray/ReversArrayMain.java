package reversesArray;

public class ReversArrayMain {

    public static void main(String[] args) {
        Object[] array = new Object[]{"a", 1, 2, 3, 4, 's', "test"};
        printArray(array);
        ReversArray reversArray = new ReversArray();
        printArray(reversArray.reversArray(array));
    }

    private static void printArray(Object[] array){
        for(int i = 0;i <array.length;i++){
            if(i != array.length-1){
                System.out.print("index: " + i + " Object: " + array[i] + ", ");
                continue;
            }
            System.out.println("index: " + i + " Object: " + array[i] + ";");
        }
    }
}
