package com.CSCI260Project;

import java.util.LinkedList;

public class Occurrences {

    //counts how many of each time entered
    public static LinkedList<Integer> countOccurrences(LinkedList<Integer> times, int[] a){
        LinkedList<Integer> occurrence = new LinkedList<>();
        int count=0;
        int lookingFor;
        for(int j=0;j<times.size();j++) {
            lookingFor=times.get(j);
            for (int i = 0; i < a.length; i++) {
                if (a[i] == lookingFor)
                    count++;
            }
            occurrence.add(count);
            count = 0;
        }
        return occurrence;
    }
}
