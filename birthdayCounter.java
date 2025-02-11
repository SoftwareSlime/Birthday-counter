package Other;

import java.util.Scanner;

public class birthdayCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Get birthday and current date from user
        System.out.println("Birthday (dd-MM-yyyy): ");
        String birthday = scan.nextLine();
        System.out.println("Current date (dd-MM-yyyy): ");
        String currentDate = scan.nextLine();

        // Extract day, month, and year from birthday
        int dayB = Integer.parseInt(birthday.substring(0, 2));
        int monthB = Integer.parseInt(birthday.substring(3, 5));
        int yearB = Integer.parseInt(birthday.substring(6, 10));

        // Extract day, month, and year from current date
        int dayC = Integer.parseInt(currentDate.substring(0, 2));
        int monthC = Integer.parseInt(currentDate.substring(3, 5));
        int yearC = Integer.parseInt(currentDate.substring(6, 10));

        // Calculate the differences
        int year = yearC - yearB;
        int month = monthC - monthB;
        int day = dayC - dayB;

        // Adjust for negative day
        if (day < 0) {
            month--;
            day += getDaysInMonth(monthC - 1, yearC);
        }

        // Adjust for negative month
        if (month < 0) {
            year--;
            month += 12;
        }

        // Output the age
        System.out.println("You are " + year + " years, " + month + " months, and " + day + " days old.");
    }

    // Helper method to get the number of days in a month
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: // January
            case 3: // March
            case 5: // May
            case 7: // July
            case 8: // August
            case 10: // October
            case 12: // December
                return 31;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                return 30;
            case 2: // February
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0; // Invalid month
        }
    }

    // Helper method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
