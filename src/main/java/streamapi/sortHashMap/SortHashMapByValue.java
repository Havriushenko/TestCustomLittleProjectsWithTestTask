package streamapi.sortHashMap;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortHashMapByValue {

    public void sortHashMapByValue() {
        Map<Integer, String> map = Map.of(
            111, "Lisa", 222, "Narayan", 333, "Xiangh",
            444, "Arunkumar", 555, "Jyous", 666, "Klusener");
        System.out.println("Map: " + map);
        System.out.println("Base sort map by LinkedList: " + baseSortMapByLinkedList(map));
        System.out.println("Base sort map by Stream: " + sorterByStream(map));
        System.out.println("Base sort map by Collections Reverse Order: " + sorterByCollectionsReverseOrder(map));
        System.out.println("Base sort map by EntryComparingByValue by length: " + sorterByEntryComparingByValue(map));
        System.out.println("Base sort map by EntryComparingByValue Second Variant by length: " + sorterByEntryComparingByValueSecondVariant(map));

    }

    public Map<Integer, String> baseSortMapByLinkedList(Map<Integer, String> map) {
        //Get listOfEntry through entrySet() method
        List<Entry<Integer, String>> listOfEntry = new LinkedList<>(map.entrySet());

        //Sort listOfEntry using Collections.sort() by passing customized Comparator
        Collections.sort(listOfEntry, new Comparator<Entry<Integer, String>>() {
            @Override
            public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //Insert all elements of listOfEntry into new LinkedHashMap which maintains insertion order
        Map<Integer, String> result = new LinkedHashMap<Integer, String>();
        for (Entry<Integer, String> entry : listOfEntry) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public Map<Integer, String> sorterByStream(Map<Integer, String> map) {
        //Java 8 sorting using Entry.comparingByValue()
        Map<Integer, String> result = map.entrySet()
            .stream()
            .sorted(Entry.comparingByValue())
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return result;
    }

    public Map<Integer, String> sorterByCollectionsReverseOrder(Map<Integer, String> map) {
        //Java 8 sorting using Entry.comparingByValue()
        Map<Integer, String> result = map.entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Entry.comparingByValue()))
            // OR
            // .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return result;
    }

    public Map<Integer, String> sorterByEntryComparingByValue(Map<Integer, String> map) {
        //Java 8 sorting using Entry.comparingByValue()
        Map<Integer, String> result = map.entrySet()
            .stream()
            .sorted(Entry.comparingByValue((o1, o2) -> o1.length() - o2.length()))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return result;
    }

    public Map<Integer, String> sorterByEntryComparingByValueSecondVariant(Map<Integer, String> map) {
        //Java 8 sorting using Entry.comparingByValue()
        Map<Integer, String> result = map.entrySet()
            .stream()
            .sorted(Entry.comparingByValue((o1, o2) -> o2.length() - o1.length()))
            //OR
            //.sorted(Collections.reverseOrder(Entry.comparingByValue((o1, o2) -> o1.length() - o2.length())))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return result;
    }
}
