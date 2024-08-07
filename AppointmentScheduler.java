import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Appointment {
    private String date;
    private String time;
    private String description;

    public Appointment(String date, String time, String description) {
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }
}

public class AppointmentScheduler {
    private ArrayList<Appointment> appointments;

    public AppointmentScheduler() {
        appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment added successfully.");
    }

    public void removeAppointment(int index) {
        if (index >= 0 && index < appointments.size()) {
            appointments.remove(index);
            System.out.println("Appointment removed successfully.");
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }

    public void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            System.out.println("Scheduled Appointments:");
            for (int i = 0; i < appointments.size(); i++) {
                Appointment appointment = appointments.get(i);
                System.out.println((i + 1) + ". Date: " + appointment.getDate() +
                        ", Time: " + appointment.getTime() +
                        ", Description: " + appointment.getDescription());
            }
        }
    }

    private boolean isValidDate(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isValidTime(String time) {
        try {
            LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentScheduler scheduler = new AppointmentScheduler();
        System.out.println("\nCreated by:- \nAditya Godara\nOm Gupta\nManik Kaushal\nAbhishek Saurabh\nRaviraj Srivastav");
        while (true) {
            System.out.println("\nAppointment Scheduler Menu:");
            System.out.println("1. Add Appointment");
            System.out.println("2. Remove Appointment");
            System.out.println("3. View Appointments");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter date (MM/DD/YYYY): ");
                    String date = scanner.nextLine();
                    if (!scheduler.isValidDate(date)) {
                        System.out.println("Invalid date format. Please enter the date in MM/DD/YYYY format.");
                        break;
                    }

                    System.out.print("Enter time (HH:MM): ");
                    String time = scanner.nextLine();
                    if (!scheduler.isValidTime(time)) {
                        System.out.println("Invalid time format. Please enter the time in HH:MM format.");
                        break;
                    }

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    scheduler.addAppointment(new Appointment(date, time, description));
                    break;
                case 2:
                    System.out.print("Enter the index of appointment to remove: ");
                    int index = scanner.nextInt();
                    scheduler.removeAppointment(index - 1);
                    break;
                case 3:
                    scheduler.displayAppointments();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
