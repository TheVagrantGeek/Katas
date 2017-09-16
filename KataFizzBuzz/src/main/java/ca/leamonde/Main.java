package ca.leamonde;

public class Main {
    public static void main(String [ ] args)
    {
        FizzBuzz fb = new FizzBuzz();
        fb.setCount(1);
        for(int i = fb.getCount(); i <= 100; i++)
        {
            fb.setCount(i);
            System.out.println(fb.output());
        }
    }
}
