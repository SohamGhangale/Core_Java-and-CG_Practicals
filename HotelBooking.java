import java.util.Scanner;

public class HotelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] rooms = new int[5][4]; // 5 floors, 4 rooms each
        int choice;

        System.out.println("Welcome to Hotel Booking System");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. View Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("\nRoom Status:");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (rooms[i][j] == 0) {
                            System.out.print("F" + (i + 1) + "R" + (j + 1) + ": Available\t");
                        } else {
                            System.out.print("F" + (i + 1) + "R" + (j + 1) + ": Booked\t");
                        }
                    }
                    System.out.println();
                }

            } else if (choice == 2) {
                System.out.print("Enter floor number (1-5): ");
                int floor = sc.nextInt();
                System.out.print("Enter room number (1-4): ");
                int room = sc.nextInt();

                if (floor >= 1 && floor <= 5 && room >= 1 && room <= 4) {
                    if (rooms[floor - 1][room - 1] == 0) {
                        rooms[floor - 1][room - 1] = 1;
                        System.out.println("Room booked successfully!");
                    } else {
                        System.out.println("Room already booked. Try another room.");
                    }
                } else {
                    System.out.println("Invalid floor or room number.");
                }

            } else if (choice == 3) {
                System.out.println("Exiting system...");
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }

        } while (choice != 3);

        System.out.println("Thank you for using the Hotel Booking System!");
        sc.close();
    }
}
