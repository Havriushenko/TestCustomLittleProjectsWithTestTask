package reversesList;

import java.util.Collections;
import java.util.List;

public class ReversList {

    public List customReversList(List list) {
        for (int i = 0; i < list.size() / 2; i++) {
            Object revObject = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, revObject);
        }
        return list;
    }

    public List collectReversList(List list) {
        Collections.reverse(list);
        return list;
    }

    public <T> List typeReversList(List<T> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            T revObject = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, revObject);
        }
        return list;
    }
}
