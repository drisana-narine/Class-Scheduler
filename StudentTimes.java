package com.CSCI260Project;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StudentTimes {
    public static void main(String[] args) {
        //ARRAY REQUIREMENT
        //put students starting times and ending times into two different arrays
        int[] startingTimes = {8,9,18,9,8,17,7,9,8,12,14,9,12,14,15,7,16,8,12,13,17,9,10,11,11,12,8,9,10,13,8,9,14,15,10,7,18,9,8,12};
        int[] endingTimes = {23,22,20,15,18,19,17,12,13,23,22,22,20,19,18,21,13,14,16,16,17,14,15,20,19,12,11,11,17,14,20,21,20,17,12,13,11,23,21,21};

        //BUBBLE SORT REQUIREMENT
        //use bubble sort to put arrays in order
        bubbleSort(startingTimes);
        bubbleSort(endingTimes);

        //LINKED LIST REQUIREMENT
        //figure out classes on most common starting and ending times
        //linked lists for different times and another for their occurrences
        LinkedList<Integer> differentStartingTimes = Times.differentTimes(startingTimes);
        LinkedList<Integer> startingTimesOccurrences = Occurrences.countOccurrences(differentStartingTimes, startingTimes);
        LinkedList<Integer> differentEndingTimes = Times.differentTimes(endingTimes);
        LinkedList<Integer> endingTimesOccurrences = Occurrences.countOccurrences(differentEndingTimes, endingTimes);

        //QUEUE REQUIREMENT
        System.out.println("40 students were asked what times they were willing to start and end CSCI 260.");
        Queue<Integer> q = QueueClass.makeQueue(differentStartingTimes);
        System.out.println("Staring times entered by students earliest to latest:");
        QueueClass.printQueue(q);
        System.out.println();

        //STACK REQUIREMENT
        Stack s = StackClass.makeStack(differentEndingTimes);
        System.out.println("Ending times entered by students latest to earliest: ");
        StackClass.printStack(s);
        System.out.println();
        System.out.println("_________________________________________________________________________________________");

        //BINARY TREE REQUIREMENT
        //find most common starting time and use it to schedule first class
        int greatest= Times.findMostCommon(startingTimesOccurrences);
        int validNum = greatest;
        BT startingTimesBT = new BT();
        BT endingTimesBT = new BT();

        int firstTime= differentStartingTimes.get(startingTimesOccurrences.indexOf(greatest));
        System.out.println("The most common starting time is "+ConvertTime.militaryToStandard(firstTime)+" with "+greatest+" occurrences.");
        System.out.println("Therefore, the first CSCI 260 class is from "+ConvertTime.militaryToStandard(firstTime)+
                " to "+ConvertTime.militaryToStandard(firstTime+3));
        System.out.println();

        //put starting times that could be potential third class into binary tree
        for(int i =0;i<startingTimesOccurrences.size();i++){
            if(startingTimesOccurrences.get(i)==validNum||startingTimesOccurrences.get(i)==(validNum-1))
                if(differentStartingTimes.get(i)!=firstTime){
                    startingTimesBT.insert(differentStartingTimes.get(i));
                }
        }

        //find most common ending time and use it to schedule second class
        greatest = Times.findMostCommon(endingTimesOccurrences);
        int validNum2 = greatest;
        int secondTime= differentEndingTimes.get(endingTimesOccurrences.indexOf(greatest));
        System.out.println("The most common ending time is "+ConvertTime.militaryToStandard(secondTime)+" with "+greatest+" occurrences.");
        System.out.println("Therefore, the second CSCI 260 class is from "+ConvertTime.militaryToStandard(secondTime-3)+
                " to "+ConvertTime.militaryToStandard(secondTime));
        System.out.println();

        //put ending times that could be potential third class into binary tree
        for(int i =0;i<endingTimesOccurrences.size();i++){
            if(endingTimesOccurrences.get(i)==validNum2||endingTimesOccurrences.get(i)==(validNum2-1))
                if(differentEndingTimes.get(i)!=secondTime){
                    endingTimesBT.insert(differentEndingTimes.get(i));
                }
        }

        //check for potential third class
        System.out.println("_________________________________________________________________________________________");
        Times.checkForNewTime(startingTimesBT,endingTimesBT);
    }

    private static void bubbleSort(int[] intArray) {
        int n = intArray.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(intArray[j-1] > intArray[j]){
                    //swap the elements!
                    temp = intArray[j-1];
                    intArray[j-1] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
    }
}
