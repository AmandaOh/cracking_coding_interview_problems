import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OneAway {

    @Test
    void test() {
        assertTrue(solve("pale", "pale"));
        assertTrue(solve("pale", "ple"));
        assertTrue(solve("pale", "pael"));
        assertFalse(solve("pale", "baal"));
        assertFalse(solve("pale", "bake"));
    }

    static boolean solve(String word, String wordToEdit) {
        List<Integer> dontMatch = word.chars()
                .filter(character -> !wordToEdit.chars().anyMatch(x -> x == character))
                .boxed()
                .collect(Collectors.toList());

        return dontMatch.size() <= 1;
    }
}
