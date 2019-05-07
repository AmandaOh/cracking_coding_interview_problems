import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompression {

    public static String solve(String word) {
        char currentCharacter = word.charAt(0);
        int currentCharacterCount = 1;
        String compressedWord = word.substring(0, 1);

        for (int i = 1; i < word.length() - 1; i++) {
            if(word.charAt(i) != currentCharacter) {
                compressedWord += currentCharacterCount;
                compressedWord += word.charAt(i);
                currentCharacterCount = 1;
                currentCharacter = word.charAt(i);
            } else {
                currentCharacterCount++;
            }
        }

        if(word.charAt(word.length() -1) == currentCharacter) {
            currentCharacterCount++;
            compressedWord += currentCharacterCount;
        } else {
            compressedWord += currentCharacterCount;
            compressedWord += word.charAt(word.length() -1);
            compressedWord += 1;
        }

        return compressedWord.length() < word.length() ? compressedWord : word;
    }

    @Test
    void returns_compressed_word() {
        assertEquals( "a1b6", solve("abbbbbb"));
        assertEquals( "a1b6c1", solve("abbbbbbc"));
    }

    @Test
    void returns_original_word_when_compressed_length_is_longer() {
        assertEquals( "abcd", solve("abcd"));
    }
}
