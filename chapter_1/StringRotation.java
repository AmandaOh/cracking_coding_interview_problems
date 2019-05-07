import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringRotation {

    @Test
    void test() {
        assertTrue(solve("water", "water"));
        assertTrue(solve("wateerbottle", "erbottlewate"));
        assertTrue(solve("wateerbottle", "eerbottlewat"));
        assertFalse(solve("wateerbottle", "eerbottlewate"));
    }

    static boolean solve(String word, String rotatedWord) {
        boolean isRotation = false;
        for (int i = 0; i < word.length(); i++) {
            if (isRotation) break;
            if(word.charAt(i) == rotatedWord.charAt(0)) {
                isRotation = (word.substring(i) + word.substring(0, i)).equals(rotatedWord);
            }
        }
        return isRotation;
    }
}
