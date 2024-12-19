
package finnall;

import java.util.Date;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        RoomList roomList = new RoomList();
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("\n===== Room Management System =====");
                System.out.println("1. Add a new Meeting Room");
                System.out.println("2. Add a new Bedroom");
                System.out.println("3. Update Room by ID");
                System.out.println("4. Delete Room by ID");
                System.out.println("5. Find Room by ID");
                System.out.println("6. Display all Rooms");
                System.out.println("7. Find the most expensive Room");
                System.out.println("8. Count the total number of Meeting Rooms and Bedrooms");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1 -> addMeetingRoom(roomList, scanner);
                        
                    case 2 -> addBedroom(roomList, scanner);
                        
                    case 3 -> updateRoomById(roomList, scanner);
                        
                    case 4 -> deleteRoomById(roomList, scanner);
                        
                    case 5 -> findRoomById(roomList, scanner);
                        
                    case 6 -> roomList.displayAllRooms();
                        
                    case 7 -> findMostExpensiveRoom(roomList);
                        
                    case 8 -> roomList.countRooms();
                        
                    case 0 -> System.out.println("Exiting program. Goodbye!");
                        
                    default -> System.out.println("Invalid choice! Please enter a valid option.");
                }
            } while (choice != 0);
        }
    }

    private static void addMeetingRoom(RoomList roomList, Scanner scanner) {
        System.out.println("Enter Meeting Room Details:");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Base Cost: ");
        double baseCost = scanner.nextDouble();
        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        MeetingRoom meetingRoom = new MeetingRoom(id, name, baseCost, new Date(), new Date(), capacity) {
            @Override
            public void enterRoomInfo() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void updateRoomById(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        roomList.addMeetingRoom(meetingRoom);
        System.out.println("Meeting Room added successfully!");
    }

    private static void addBedroom(RoomList roomList, Scanner scanner) {
        System.out.println("Enter Bedroom Details:");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Base Cost: ");
        double baseCost = scanner.nextDouble();
        System.out.print("Number of Beds: ");
        int numberOfBeds = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        BedRoom bedRoom = new BedRoom(id, name, baseCost, new Date(), new Date(), numberOfBeds) {
            @Override
            public void enterRoomInfo() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void updateRoomById(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        roomList.addBedroom(bedRoom);
        System.out.println("Bedroom added successfully!");
    }

    private static void updateRoomById(RoomList roomList, Scanner scanner) {
        System.out.print("Enter the Room ID to update: ");
        String id = scanner.nextLine();

        System.out.println("Enter new Room Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Base Cost: ");
        double baseCost = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        Room updatedRoom = new MeetingRoom(id, name, baseCost, new Date(), new Date(), 0) {
            @Override
            public void enterRoomInfo() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void updateRoomById(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }; // Dummy capacity
        roomList.updateRoomById(id, updatedRoom);
    }

    private static void deleteRoomById(RoomList roomList, Scanner scanner) {
        System.out.print("Enter the Room ID to delete: ");
        String id = scanner.nextLine();
        roomList.deleteRoomById(id);
    }

    private static void findRoomById(RoomList roomList, Scanner scanner) {
        System.out.print("Enter the Room ID to find: ");
        String id = scanner.nextLine();
        Room room = roomList.findRoomById(id);
        if (room != null) {
            room.displayDetails();
        }
    }

    private static void findMostExpensiveRoom(RoomList roomList) {
        Room mostExpensiveRoom = roomList.findMostExpensiveRoom();
        if (mostExpensiveRoom != null) {
            System.out.println("The most expensive Room is:");
            mostExpensiveRoom.displayDetails();
        } else {
            System.out.println("No rooms available.");
        }
    }
}
