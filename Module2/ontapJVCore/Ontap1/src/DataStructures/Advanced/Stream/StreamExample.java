package DataStructures.Advanced.Stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // Example code for stream operations will go here
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        //Stream pipeline
        List<String> result = names.stream()
                .filter(s -> s.length() > 2)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result); // Output: [ALICE, BOB, CHARLIE, DAVID]
    }
}
