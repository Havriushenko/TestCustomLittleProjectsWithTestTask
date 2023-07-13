package streamapi.mergeTwoMaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoMaps {

    public void mergeTwoMaps() {
        Map<String, Integer> map1 = Map.of("Maths", 45, "Physics", 57, "Chemistry", 52, "History", 41);
        Map<String, Integer> map2 = Map.of("Economics", 49, "Maths", 42, "Biology", 41, "History", 55);
        System.out.println("Map 1: " + map1);
        System.out.println("Map 2: " + map2);
        System.out.println("Map Merge result: " + mapMerge(map1, map2));
        System.out.println("Stream Concat result: " + streamConcat(map1, map2));
        System.out.println("Stream FlatMap result: " + streamFlatMap(map1, map2));
        System.out.println("Stream Pipeline result: " + streamPipeline(map1, map2));
    }

    public Map<String, Integer> mapMerge(Map<String, Integer> map1, Map<String, Integer> map2) {
        //Merging Map-1 and Map-2 into Map-3
        //If any two keys are found same, their values are added
        Map<String, Integer> result = new LinkedHashMap<>(map1);
        map2.forEach((key, value) -> result.merge(key, value, (v1, v2) -> v1 + v2));
        return result;
    }

    public Map<String, Integer> streamConcat(Map<String, Integer> map1, Map<String, Integer> map2) {
        //Merging Map-1 and Map-2 into Map-3
        //If any two keys are found same, largest value will be selected
        Map<String, Integer> result = Stream
            .concat(map1.entrySet().stream(), map2.entrySet().stream())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1 > v2 ? v1 : v2, HashMap::new));
//            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1 + v2, HashMap::new));
//            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum, HashMap::new));
        return result;
    }

    public Map<String, Integer> streamFlatMap(Map<String, Integer> map1, Map<String, Integer> map2) {
        //Merging Map-1 and Map-2 into Map-3
        //If any two keys are found same, their values are added using method reference : Integer::sum
        Map<String, Integer> result = Stream.of(map1, map2)
            .flatMap(map -> map.entrySet().stream())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum, HashMap::new));
        return result;
    }

    public Map<String, Integer> streamPipeline(Map<String, Integer> map1, Map<String, Integer> map2) {
        //Merging Map-1 and Map-2 into Map-3
        //If any two keys are found same, smallest value is selected
        Map<String, Integer> result = map2.entrySet()
            .stream()
            .collect(Collectors
                .toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1 < v2 ? v1 : v2, () -> new HashMap<>(map1)));
        return result;
    }
}
