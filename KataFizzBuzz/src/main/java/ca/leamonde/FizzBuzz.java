package ca.leamonde;

public class FizzBuzz {
    public static final int START = 1;
    public static final int STEP = 1;

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    private int count;

    public FizzBuzz()
    {
        count = FizzBuzz.START;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment()
    {
        count += FizzBuzz.STEP;
    }

    public String output()
    {
        if(count % 3 == 0 && count % 5 == 0)
            return FIZZ + BUZZ;
        if(count % 3 == 0)
            return FIZZ;
        if(count % 5 == 0)
            return BUZZ;

        return Integer.toString(count);
    }
}
