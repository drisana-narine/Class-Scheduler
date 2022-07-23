package com.CSCI260Project;

import java.util.LinkedList;
import java.util.Scanner;

public class Times {

    //keeps track of how many different times
    public static LinkedList<Integer> differentTimes(int[] a){
        LinkedList<Integer> l=new LinkedList<>();
        for(int i=0;i<a.length;i++){
            if(!l.contains(a[i])){
                l.add(a[i]);
            }
        }
        return l;
    }

    //finds most common time
    public static int findMostCommon(LinkedList<Integer> l){
        int greatest=0;
        for(int i=0;i<l.size();i++){
            if(l.get(i)>greatest){
                greatest=l.get(i);
            }
        }
        return greatest;
    }

    //checks if new time entered could be a potential new class
    public static void checkForNewTime(BT bt1, BT bt2){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a time to see if it is valid to ask for a third class");
        System.out.println("Enter numerical value of the time: ");
        int num = keyboard.nextInt();
        System.out.println("Enter \"am\" for a.m. and \"pm\" for p.m.: ");
        String meridiem = keyboard.next();
        int input=ConvertTime.standardToMilitary(num,meridiem);
        System.out.println("Type \"starting\" to enter a starting time and \"ending\" to enter a ending time: ");
        String check = keyboard.next();
        if(check.equals("starting")){
            if(bt1.search(input))
                System.out.println("Including you, enough people want this time to make an additional class. Contact the school.");
            else
                System.out.println("There's not enough people who want this time for an additional class.");
        }
        if(check.equals("ending")){
            if(bt2.search(input))
                System.out.println("Including you, enough people want this time to make an additional class. Contact the school.");
            else
                System.out.println("There's not enough people who want this time for an additional class.");
        }

    }

}
