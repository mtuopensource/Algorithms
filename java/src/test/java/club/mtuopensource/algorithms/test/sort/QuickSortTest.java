package club.mtuopensource.algorithms.test.sort;

import club.mtuopensource.algorithms.sort.ISort;
import club.mtuopensource.algorithms.sort.QuickSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class QuickSortTest{
	ISort<Integer> sorter;
	ArrayList<Integer> expectedData;
	ArrayList<Integer> data;

	@BeforeEach
	public void setup() {
		sorter = new QuickSort<Integer>();
	}

	@Test
	public void test1() {
		data = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		expectedData = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		sorter.sort(data);
		assertEquals(expectedData, data);
	}

	@Test
	public void test2() {
		data = new ArrayList<>(Arrays.asList(10,9,8,7,6,5,4,3,2,1));
		expectedData = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		sorter.sort(data);
		assertEquals(expectedData, data);
	}

	@Test
	public void test3() {
		data = new ArrayList<>(Arrays.asList(1,10,2,9,3,8,4,5,7,6));
		expectedData = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		sorter.sort(data);
		assertEquals(expectedData, data);
	}

	@Test
	public void test4() {
		data = new ArrayList<>(Arrays.asList(10,9,9,7,6,6,6,3,2,1));
		expectedData = new ArrayList<>(Arrays.asList(1,2,3,6,6,6,7,9,9,10));
		sorter.sort(data);
		assertEquals(expectedData, data);
	}

	@Test
	public void test5() {
		data = new ArrayList<>();
		expectedData = new ArrayList<>();

        int a = 5; //a must be 4c+1
        int b = 3; //b must be odd
        int m = 1024;

        int x = 10; //the first number;
        data.add(x);
		for (int i=1;i<1024;i++ ) {
			x = ( a * x + b ) % m;
			data.add(x);
		}

		for (int i=0;i<1024;i++ ) {
			expectedData.add(i);
		}
		sorter.sort(data);
		assertEquals(expectedData, data);
	}
}
