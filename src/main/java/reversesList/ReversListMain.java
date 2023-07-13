package reversesList;

import java.util.ArrayList;
import java.util.List;

public class ReversListMain {

    public static void main(String[] args) {
        List list = new ArrayList() {{
            add("a");
            add(1);
            add(2);
            add(3);
            add(4);
            add('s');
            add("test");
        }};
        printList(list);
        ReversList reversList = new ReversList();
        printList(reversList.customReversList(list));
        printList(reversList.collectReversList(list));
    }

    private static void printList(List list) {
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print("index: " + i + " Object: " + list.get(i) + ", ");
                continue;
            }
            System.out.println("index: " + i + " Object: " + list.get(i) + ";");
        }
    }
}
