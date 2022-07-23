package com.CSCI260Project;

public class ConvertTime {

    public static String militaryToStandard(int time){
        if(time>=1 && time<=11){
            return time+" a.m.";
        }
        else if(time==12){
            return time+" p.m.";
        }
        else if(time==0){
            return time+" a.m.";
        }
        else
            return (time-12)+" p.m.";
    }

    public static int standardToMilitary(int num, String meridiem){
        if(meridiem.equalsIgnoreCase("am")){
            if(num==12)
                return 0;
            else
                return num;
        }
        else{
            if(num ==12)
                return num;
            else
                return num+12;
        }

    }
}
