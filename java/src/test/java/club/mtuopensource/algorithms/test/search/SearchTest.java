package club.mtuopensource.algorithms.test.search;

import club.mtuopensource.algorithms.search.LinearSearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    @Test
    public void testLinearSearch() {
        LinearSearch<Integer> linearSearch = new LinearSearch<>();
        Integer[] values = new Integer[9];
        for(int i = 0; i < values.length; i++) {
            assertTrue(linearSearch.search(values, i) == -1);
            values[i] = i;
            assertTrue(linearSearch.search(values, i) == i);
        }
    }
}
