package testTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TwitterHashTags {

    public static void main(String[] args) {

    }

//    private List<String> getHashTags(List<String> message) {
//        if (Objects.isNull(message) || message.isEmpty()) {
//            return new ArrayList<>();
//        }
//        List<String> collect = message.stream().flatMap(twits ->
//                getHashTagsFromListOfWords(twits).stream().fi)
//            .collect(Collectors.toList());
//        return collect;
//        collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//    }

    private List<String> getHashTagsFromListOfWords(String twits) {
        return Arrays.asList(twits.split(" "))
            .stream()
            .filter(word -> word.startsWith("#"))
            .collect(Collectors.toList());
    }


}
