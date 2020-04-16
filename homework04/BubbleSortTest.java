import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class BubbleSortTest {
    private BubbleSort bubbleSort;
    @Before
    public void setup() throws Exception{
        bubbleSort = new BubbleSort();
    }
    @After
    public void tearDown() throws Exception{
        bubbleSort = null;
    }
    @org.junit.Test
    public void bubbleSort() {
        assertArrayEquals(new int[]{1, 2, 2, 5, 6},bubbleSort.bubbleSort(new int[]{1, 6, 2, 2, 5}));
        assertArrayEquals(new int[]{1, 2, 2, 5, 6},bubbleSort.bubbleSort(new int[]{2, 1,6, 2, 5}));
        assertArrayEquals(new int[]{1, 1, 3, 5, 6},bubbleSort.bubbleSort(new int[]{3,1, 1, 6, 5}));
        assertArrayEquals(new int[]{1,  2, 5, 6,20},bubbleSort.bubbleSort(new int[]{1, 6, 20, 2, 5}));
        assertArrayEquals(new int[]{2, 2, 2, 4 },bubbleSort.bubbleSort(new int[]{4, 2, 2, 2}));

    }
}