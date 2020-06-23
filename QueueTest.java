import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;

/**
 * The test class QueueTest tests the Queue class.
 *
 * @author  Valerie Foster
 * @version 3/15/2018
 */
public class QueueTest {
    
    Queue<Integer> testQ;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        testQ = new Queue<Integer>();
        testQ.add(1);
        testQ.add(2);
        testQ.add(3);
        testQ.add(4);
    }

    @Test
    public void testAdd() {
        assertEquals(4, testQ.size());
    }
    
    @Test
    public void testRemove() {
        Integer int1 = 1;
        assertEquals(int1, testQ.remove());
        assertEquals(3, testQ.size());
    }
    
    @Test (expected = NoSuchElementException.class)
    public void testPrecon() {
        testQ.clear();
        testQ.remove();
    }
    
    @Test
    public void testPeek() {
        Integer int2 = 1;
        assertEquals(int2, testQ.peek());
        assertEquals(4, testQ.size());
    }
    
    @Test
    public void testIsEmpty() {
        testQ.clear();
        assertTrue(testQ.isEmpty());
    }
    
}
