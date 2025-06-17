package pastyears.paper2016;

import java.util.Scanner;

public class Day {
    private final int dayInt;
    private final String dayString;

    String[] days = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    public Day(int dayInt){
        this.dayInt = dayInt;
        int index = Math.abs(dayInt  - 1) % 7;
        this.dayString = days[index];
    }

    public String getToday(){
        return dayString;
    }

    public String getYesterday(){
        int index = 0;
        if (dayInt == 1){
            index = 6; // sunday
        } else {
            index = Math.abs(dayInt - 1) - 1 % 7;
        }
        return days[index];
    }

    public String getTomorrow(){
        int index = dayInt % 7;
        return days[index];
    }

    public String getDay(int daysAdded){
        int index = Math.abs(dayInt - 1 + daysAdded) % 7;
        return days[index];
    }

    public static void main(String[] args) {
        System.out.println("""
                Specify your day in number:
                1 for Monday
                2 for Tuesday
                3 for Wednesday
                4 for Thursday
                5 for Friday
                6 for Saturday
                7 for Sunday
                """);

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        Day day = new Day(choice);
        System.out.println("The name of the day is : "+day.getToday());
        System.out.println("The following day of " + day.getToday() + " is : " + day.getTomorrow());
        System.out.println("The previous day of " + day.getToday() + " is : " + day.getYesterday());

        System.out.println("How many days to add to the specified/current day (" + day.getToday() + ")? : ");
        choice = sc.nextInt();
        System.out.printf("The new day after the addition of %d day (s) is : %s\n",choice,day.getDay(choice));

        sc.close();
    }
}
