import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackPackTest {
    BackPack backPack;

    @Before
    public void setUp() throws Exception {
        backPack = new BackPack();
    }

    @After
    public void tearDown() throws Exception {
        backPack = null;
    }

    @Test
    public void backPack_Solution() {
        int m = 9;
        int n = 4;
        int w[] = {2,4,5,6};
        int p[] = {7,8,9,11};

        int[][] c ={{0,0,0,0,0,0,0,0,0,0},{0,0,7,7,7,7,7,7,7,7},{0,0,7,7,8,8,15,15,15,15},{0,0,7,7,8,9,15,16,16,17},{0,0,7,7,8,9,15,16,18,18}};
        assertArrayEquals(c,backPack.BackPack_Solution(m, n, w, p));

    }
}