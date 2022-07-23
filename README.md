# Class-Scheduler
This project schedules a class based on the times students are available
The starting times students are available are put into one array and their ending times put into another array
2 classes are scheduled based on most common times, 1 on most common starting time, the other on most common ending time 
The ConvertTime file converts military time to standard time and vice versa
The Occurrences file counts how many of each time was entered
The QueueClass file puts the starting time in a Queue so they can be printed earliest to latest
The StackClass file puts the ending times in a Stack so they can be printed latest to earliest
The BT and BTNode file create binary trees to put in times that are common enough where if 1 more student wants it then a third class could be reasonable
The Times file keeps track of how any different times, and the most common times, it also checks a a time a student entered would be valid for a third class
The StudentTimes file keeps track of the starting and ending times, uses bubble sort to put them in order, calls the above classes to do their task,
displays the two classes scheduled based on the times, and asks the user to enter a time to see if a third class could be requested
