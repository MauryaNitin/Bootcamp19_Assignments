package com.ttn.java.collections;

import java.util.LinkedList;

/**
 * 7. Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and
 * an additional operation getMin() which should return minimum element from the SpecialStack.
 * (Expected complexity ­ O(1))
 */

interface MyStack{
    void push(int element);
    int pop();
    boolean isFull();
    boolean isEmpty();
}

class SpecialStack implements MyStack{
    private final int MAXSIZE = 100;
    private int minimum = Integer.MAX_VALUE;
    private final LinkedList<Integer> stack = new LinkedList<>();

    public void push(int element){
        if(element < minimum){
            minimum = element;
        }
        stack.push(element);
    }
    public int pop(){
        return stack.pop();
    }
    public boolean isFull(){
        return (stack.size() == MAXSIZE);
    }
    public boolean isEmpty(){
       return (stack.size() == 0);
    }
    public int getMin(){
        return minimum;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}

public class Ques7_SpecialStack {
    public static void main(String[] args) {
        SpecialStack s = new SpecialStack();

        System.out.println("Stack : " + s);

        System.out.println("Is Empty: " + s.isEmpty());

        s.push(5);
        s.push(10);
        s.push(2);
        s.push(20);
        s.push(7);

        System.out.println("Stack : " + s);

        System.out.println("Popped: " + s.pop());
        System.out.println("Popped: " + s.pop());

        System.out.println("Is Full: " + s.isFull());

        System.out.println("Is Empty: " + s.isEmpty());

        System.out.println("Minimum Element: " + s.getMin());

        System.out.println("Stack : " + s);

    }
}
