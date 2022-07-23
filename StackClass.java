package com.CSCI260Project;

import java.util.LinkedList;
import java.util.Stack;

public class StackClass {
    Stack s = new Stack();

    public static Stack makeStack(LinkedList<Integer> l){
        Stack s = new Stack();
        for(int i=0;i<l.size();i++){
            s.add(ConvertTime.militaryToStandard(l.get(i)));
        }
        return s;
    }

    public static void printStack(Stack s){
        int count=s.size();
        for(int i=0;i<count;i++){
            System.out.print(s.peek()+" ");
            s.pop();
        }
        System.out.println();
    }
}
