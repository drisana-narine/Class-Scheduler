package com.CSCI260Project;

import java.util.LinkedList;
import java.util.Queue;

public class QueueClass {


    public static Queue<Integer> makeQueue(LinkedList<Integer> l){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<l.size();i++){
            q.add(l.get(i));
        }
        return q;
    }

    public static void printQueue(Queue<Integer> q2){
        int count = q2.size();
        for(int i=0;i<count;i++){
            System.out.print(ConvertTime.militaryToStandard(q2.peek())+" ");
            q2.remove();
        }
        System.out.println();
    }
}
