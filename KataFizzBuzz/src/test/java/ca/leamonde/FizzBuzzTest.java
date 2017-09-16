package ca.leamonde;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    public final int A_COUNT = 5;
    FizzBuzz fb;

    @Before
    public void before() {
        fb = new FizzBuzz();
    }

    @Test
    public void givenNew_countIsStartingValue()
    {
        assertEquals(FizzBuzz.START, fb.getCount());
    }

    @Test
    public void givenNew_afterIncrement_CountIsStartingValuePlusOne()
    {
        fb.increment();
        assertEquals(FizzBuzz.START+1, fb.getCount());
    }

    @Test
    public void givenNew_afterSetCount_CountIsSettedCount()
    {
        fb.setCount(A_COUNT);
        assertEquals(A_COUNT, fb.getCount());
    }


    @Test
    public void givenNew_afterSetCountOne_OutputIsStringOne()
    {
        fb.setCount(1);
        assertEquals("1", fb.output());
    }

    @Test
    public void givenNew_afterSetCountThree_OutputIsStringFizz()
    {
        fb.setCount(3);
        assertEquals(FizzBuzz.FIZZ, fb.output());
    }

    @Test
    public void givenNew_afterSetCountFize_OutputIsStringBuzz()
    {
        fb.setCount(5);
        assertEquals(FizzBuzz.BUZZ, fb.output());
    }

    @Test
    public void givenNew_afterSetCountFifteen_OutputIsStringFizzBuzz()
    {
        fb.setCount(15);
        assertEquals(FizzBuzz.FIZZ + FizzBuzz.BUZZ, fb.output());
    }

    @Test
    public void givenNew_afterSetCountZero_OutputIsStringFizzBuzz()
    {
        fb.setCount(0);
        assertEquals(FizzBuzz.FIZZ + FizzBuzz.BUZZ, fb.output());
    }



}