package ca.leamonde;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {

    private MyQueue q;
    private final int A_VALUE = 1;
    private final int ANOTHER_VALUE = 42;

    @Before
    public void before() {
        q = new MyQueue();
    }

    @Test
    public void givenNewQueue_queueIsEmpty() {
        assertTrue(q.isEmpty());
    }

    @Test
    public void givenNewQueue_popReturnsNull() {
        assertNull(q.pop());
    }

    @Test
    public void givenNewQueue_peekReturnsNull() {
        assertNull(q.peek());
    }

    @Test
    public void givenNewQueue_whenObjectPushed_queueIsNotEmpty() {
        q.push(A_VALUE);
        assertFalse(q.isEmpty());
    }

    @Test
    public void givenNewQueue_whenObjectPushed_popIsNotNull() {
        q.push(A_VALUE);
        assertNotNull(q.pop());
    }

    @Test
    public void givenNewQueue_whenObjectPushed_peekIsNotNull() {
        q.push(A_VALUE);
        assertNotNull(q.peek());
    }

    @Test
    public void givenNewQueue_whenObjectPushed_peekIsPushedValue(){
        q.push(A_VALUE);
        assertEquals(A_VALUE, q.peek());
    }

    @Test
    public void givenNewQueue_afterPushedThenPop_queueIsEmpty(){
        q.push(A_VALUE);
        q.pop();
        assertTrue(q.isEmpty());
    }

    @Test
    public void givenNewQueue_afterPushedThenPop_popedIsPushedValue(){
        q.push(A_VALUE);
        assertEquals(A_VALUE, q.pop());
    }

    @Test
    public void givenNewQueue_afterTwoPush_popIsFirstValue()
    {
        q.push(A_VALUE);
        q.push(ANOTHER_VALUE);
        assertEquals(A_VALUE, q.pop());
    }

    @Test
    public void givenNewQueue_afterTwoPush_peekIsFirstValue()
    {
        q.push(A_VALUE);
        q.push(ANOTHER_VALUE);
        assertEquals(A_VALUE, q.peek());
    }

    @Test
    public void givenNewQueue_afterTwoPushThenTwoPop_popReturnValuesInRightOrder()
    {
        q.push(A_VALUE);
        q.push(ANOTHER_VALUE);
        assertEquals(A_VALUE,q.pop());
        assertEquals(ANOTHER_VALUE,q.pop());
    }

    @Test
    public void givenNewQueue_afterTwoPushThenTwoPop_queueIsEmpty()
    {
        q.push(A_VALUE);
        q.push(ANOTHER_VALUE);
        q.pop();
        q.pop();
        assertTrue(q.isEmpty());
    }

}