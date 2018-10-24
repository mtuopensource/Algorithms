package club.mtuopensource.algorithms.test.sort;

import club.mtuopensource.algorithms.sort.ISort;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutomatedSortTest {
    private static final int SEED = 0xdeadbeef;
    private static final int NUMBER_OF_ELEMENTS = 99;

    @ParameterizedTest
    @MethodSource("getSorters")
    public void sort(Class<? extends ISort> algorithm) {
        try {
            Supplier<Stream<Integer>> data = () -> new Random(SEED).ints(NUMBER_OF_ELEMENTS).boxed();
            ArrayList<Integer> a = (ArrayList) data.get().collect(Collectors.toList());
            ArrayList<Integer> b = (ArrayList) data.get().sorted().collect(Collectors.toList());
            ISort<Integer> sorter = algorithm.newInstance();
            sorter.sort(a);
            assertEquals(a, b);
        } catch(InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static Stream<Arguments> getSorters() {
        Reflections reflections = new Reflections("club.mtuopensource.algorithms");
        Set<Class<? extends ISort>> sorters = reflections.getSubTypesOf(ISort.class);
        return sorters.stream().map(Arguments::of);
    }
}
