import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDups {

    private LinkedList<Integer> solve(LinkedList<Integer> list) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        ListIterator<Integer> integerListIterator = list.listIterator();

        while(integerListIterator.hasNext()) {
            int number = integerListIterator.next();
            if (uniqueElements.contains(number)) {
                integerListIterator.remove();
            } else {
                uniqueElements.add(number);
            }
        }
        return list;
    }

    @Test
    void unsorted_linkedList() {
        LinkedList<Integer> unorderedList = new LinkedList<>(
                Arrays.asList(1, 4, 1, 1)
        );
        LinkedList<Integer> expectedList = new LinkedList<>(
                Arrays.asList(1, 4)
        );

        assertEquals(expectedList, solve(unorderedList));
    }

    @Test
    void unsorted_linkedList_2() {
        LinkedList<Integer> unorderedList = new LinkedList<>(
                Arrays.asList(1, 4, 2, 1, 2, 8)
        );
        LinkedList<Integer> expectedList = new LinkedList<>(
                Arrays.asList(1, 4, 2, 8)
        );

        assertEquals(expectedList, solve(unorderedList));
    }
}
