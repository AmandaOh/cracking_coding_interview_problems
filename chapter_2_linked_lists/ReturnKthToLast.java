import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReturnKthToLast {

    private List<Integer> solve(LinkedList<Integer> list, int index) {
        List<Integer> kthToLast = new ArrayList<>();
        ListIterator<Integer> integerListIterator = list.listIterator();

        while (integerListIterator.hasNext()) {
            int number = integerListIterator.next();
            if (integerListIterator.nextIndex() >= index) {
                kthToLast.add(number);
            }
        }

        return kthToLast;
    }

    @Test
    void test_2nd_to_last_element() {
        LinkedList<Integer> list = new LinkedList<>(
                Arrays.asList(1, 2, 3, 4)
        );
        List<Integer> expected = Arrays.asList(2, 3, 4);

        assertEquals(expected, solve(list, 2));
    }

    @Test
    void test_0th_element_returns_all() {
        LinkedList<Integer> list = new LinkedList<>(
                Arrays.asList(1, 2, 3, 4)
        );

        assertEquals(list, solve(list, 0));
    }
}
