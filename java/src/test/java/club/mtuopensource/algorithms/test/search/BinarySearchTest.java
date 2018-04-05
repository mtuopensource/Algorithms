package club.mtuopensource.algorithms.test.search;

import club.mtuopensource.algorithms.search.BinarySearch;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class BinarySearchTest {
    
	@Test
    public void BinarySearchTest() {
    	BinarySearch<Integer> binarysearch = new BinarySearch<>();
    	Integer[] value = new Integer[9];
    	int counter = 15;
    	for ( int i = 0; i < value.length; i++ ) {
    		value[i] = counter;
    		counter++;
    	}
    	
    	assertTrue(binarysearch.search(value, 15) == 0);
    	assertTrue(binarysearch.search(value, 16) == 1);
    	assertTrue(binarysearch.search(value, 17) == 2);
    	assertTrue(binarysearch.search(value, 18) == 3);
    	assertTrue(binarysearch.search(value, 19) == 4);
    	
    	assertTrue(binarysearch.search(value, 108) == -1);
    	assertTrue(binarysearch.search(value, 0) == -1);
    	assertTrue(binarysearch.search(value, -1) == -1);
    	
    }
}
