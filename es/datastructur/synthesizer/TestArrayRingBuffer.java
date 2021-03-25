package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(6);
        assertTrue(arb.isEmpty());
        arb.enqueue(0);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        assertTrue(arb.isFull());

        arb.dequeue();
        arb.dequeue();
        assertTrue(arb.fillCount() == 4);
        assertTrue(arb.peek() == 2);

        arb.enqueue(0);
        assertTrue(arb.fillCount() == 5);
    }

    @Test
    public void testEquals() {
        ArrayRingBuffer<Integer> a = new ArrayRingBuffer<>(5);
        ArrayRingBuffer<Integer> b = new ArrayRingBuffer<>(5);
        ArrayRingBuffer<Integer> c = new ArrayRingBuffer<>(6);

        assertFalse(a.equals(c));

        a.enqueue(0);
        a.enqueue(1);
        a.enqueue(2);
        b.enqueue(0);
        b.enqueue(1);
        b.enqueue(2);
        assertTrue(a.equals(b));

        assertTrue(a.equals(a));
        assertFalse(a.equals(null));
    }
}
