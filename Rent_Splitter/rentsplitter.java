
import java.util.Scanner;

public class rentsplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Smart Rent Splitter ===");

        // Step 1: Total rent and apartment size
        System.out.print("Enter total rent amount: $");
        double totalRent = scanner.nextDouble();

        System.out.print("Enter total apartment square footage: ");
        double totalSqFt = scanner.nextDouble();

        // Step 2: Room data
        System.out.print("Enter number of rooms: ");
        int numRooms = scanner.nextInt();

        double[] roomSizes = new double[numRooms];
        int[] occupantsPerRoom = new int[numRooms];
        double[] costPerRoom = new double[numRooms];

        double totalRoomSqFt = 0;

        // Get size and occupants for each room
        for (int i = 0; i < numRooms; i++) {
            System.out.print("\nEnter square footage for Room " + (i + 1) + ": ");
            roomSizes[i] = scanner.nextDouble();

            System.out.print("Enter number of people in Room " + (i + 1) + ": ");
            occupantsPerRoom[i] = scanner.nextInt();

            totalRoomSqFt += roomSizes[i];
        }

        // Step 3: Calculate rent per room and per person
        System.out.println("\n=== Rent Breakdown ===");
        int personID = 1;
        for (int i = 0; i < numRooms; i++) {
            // Room rent based on size
            costPerRoom[i] = (roomSizes[i] / totalRoomSqFt) * totalRent;
            double rentPerPerson = costPerRoom[i] / occupantsPerRoom[i];

            for (int j = 0; j < occupantsPerRoom[i]; j++) {
                System.out.printf("Person %d (Room %d): $%.2f\n", personID++, i + 1, rentPerPerson);
            }
        }

        scanner.close();
    }
}
