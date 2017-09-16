package ca.leamonde;

import java.util.LinkedList;

public class MyQueue {
    private Boolean isEmpty = true;
    private LinkedList<Object> l = new LinkedList<Object>();

    public Boolean isEmpty(){
        return l.isEmpty();
    }

    public Object pop(){
        if(l.isEmpty())
            return null;
        return l.removeFirst();
    }

    public Object peek(){
        if(l.isEmpty())
            return null;
        return l.getFirst();
    }

    public void push(Object o)
    {
        isEmpty = false;
        l.add(o);
    }

}
