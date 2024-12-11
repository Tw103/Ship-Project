// Te'Variyae Woods

import java.util.Scanner;


public class ClockTimeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String repeat;

        do {
            try {
                // First Object - ask for military time
                TimeConverter time1 = new TimeConverter();
                System.out.println("Welcome to the military time converter ^_^");
                System.out.println("Enter the hours on the military clock (0 to 23):");
                int hours = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the minutes on the military clock (0 to 59):");
                int minutes = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the seconds on the military clock (0 to 59):");
                int seconds = Integer.parseInt(scanner.nextLine());
                
                time1.updateTime(hours, minutes, seconds);
                System.out.print("12-hour clock time → ");
                time1.displayTime();

                // Second Object - ask for time string
                System.out.println("Enter 24 hour clock time in the format \"hours:minutes:seconds\":");
                String timeString = scanner.nextLine();

                TimeConverter time2 = new TimeConverter();
                time2.updateTime(timeString);
                System.out.print("12 hour clock time → ");
                time2.displayTime();

            } catch (TimeException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("EXCEPTION: Invalid input format!");
            }

            System.out.println("Would you like to do this again? Enter \"Yes\" or \"No\":");
            repeat = scanner.nextLine();
        } while (repeat.equalsIgnoreCase("yes"));

        System.out.println("Exiting the program!");
        scanner.close();
    }
}