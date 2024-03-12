import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DaysInMonth daysInMonth = new DaysInMonth();

        String monthInput;
        int month;

        do {
            System.out.print("Enter the month (full name, abbreviation, 3 letters, or number): ");
            monthInput = scanner.nextLine().toLowerCase();

            month = daysInMonth.getMonthNumber(monthInput);

            if (month == -1) {
                System.out.println("Invalid month input. Please enter a valid month.");
            }

        } while (month == -1);

        int year;

        do {
            System.out.print("Enter the year: ");
            year = scanner.nextInt();

            if (year <= 0) {
                System.out.println("Invalid year input. Please enter a positive year.");
            }

        } while (year <= 0);

        int daysInMonthResult = daysInMonth.calculateDaysInMonth(month, year);
        System.out.println("Number of days in " + daysInMonth.getMonthName(month) + " " + year + ": " + daysInMonthResult);

        scanner.close();
    }

    int getMonthNumber(String monthInput) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        for (int i = 0; i < months.length; i++) {
            if (monthInput.equals(months[i].toLowerCase()) || monthInput.equals(months[i].substring(0, 3).toLowerCase()) ||
                    monthInput.equals(String.valueOf(i + 1)) || monthInput.equals(getMonthAbbreviation(i + 1).toLowerCase())) {
                return i + 1;
            }
        }

        return -1; 
    }

    String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        return months[month - 1];
    }

    String getMonthAbbreviation(int month) {
        String[] abbreviations = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        return abbreviations[month - 1];
    }

    int calculateDaysInMonth(int month, int year) {
        int[] daysInMonth = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return daysInMonth[month - 1];
    }

    boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

