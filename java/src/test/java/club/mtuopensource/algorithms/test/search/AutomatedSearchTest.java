package club.mtuopensource.algorithms.test.search;

import club.mtuopensource.algorithms.search.ISearch;
import club.mtuopensource.algorithms.sort.ISort;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.reflections.Reflections;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutomatedSearchTest {
    private static final int SEED = 0xdeadbeef;
    private static final int NUMBER_OF_ELEMENTS = 99;

    /**
     * Search
     * Fills one ArrayList with {@link AutomatedSearchTest#NUMBER_OF_ELEMENTS} random Integers.
     * ArrayList is then searched using the given algorithm and Java's built-in Binary Search routine.
     * Asserts that both indices are equal.
     * @param algorithm currently being tested
     */
    @ParameterizedTest
    @MethodSource("getSearches")
    public void search(Class<? extends ISearch> algorithm) {
        try {
            Supplier<Stream<Integer>> supplier = () -> new Random(SEED).ints(NUMBER_OF_ELEMENTS).boxed();
            ArrayList<Integer> sorted = (ArrayList) supplier.get().sorted().collect(Collectors.toList());
            ISearch<Integer> search = algorithm.newInstance(); // TODO: Deprecated
            for(int i = 0; i < sorted.size(); i++) {
                int key = sorted.get(i);
                int a = search.search(sorted, key);
                int b = Collections.binarySearch(sorted, key);
                assertEquals(a, b);
            }
        } catch(InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * GetSearches
     * @return Stream of ISearch implementations. Used as parameters in the Search Test.
     */
    private static Stream<Arguments> getSearches() {
        Reflections reflections = new Reflections("club.mtuopensource.algorithms");
        Set<Class<? extends ISearch>> sorters = reflections.getSubTypesOf(ISearch.class);
        return sorters.stream().map(Arguments::of);
    }
}
