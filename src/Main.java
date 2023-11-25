import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingSystem bookingSystem = initializeParkingSpaces();
    


        System.out.println("Welcome to the Parking System!");

        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    User loggedInUser = loginUser(scanner);
                    if (loggedInUser != null) {
                        handleParkingSystem(scanner, bookingSystem, loggedInUser);
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static BookingSystem initializeParkingSpaces() {
        BookingSystem bookingSystem = new BookingSystem();

        // Initialize parking spaces in different locations of Toronto
        for (int location = 1; location <= 8; location++) {
            for (int spot = 1; spot <= 10; spot++) {
                if (location % 2 == 0) {
                    // Even locations have Car parking spaces
                    bookingSystem.addParkingSpace(new CarParkingSpace(location * 100 + spot));
                } else {
                    // Odd locations have Bike parking spaces
                    bookingSystem.addParkingSpace(new BikeParkingSpace(location * 100 + spot));
                }
            }
        }

        return bookingSystem;
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.next();
        System.out.print("Enter a password: ");
        String password = scanner.next();
        User user = new User(username, password);
        System.out.println("Registration successful!");
    }

    private static User loginUser(Scanner scanner) {
        System.out.print("Enter your username: ");
        String enteredUsername = scanner.next();
        System.out.print("Enter your password: ");
        String enteredPassword = scanner.next();


        User user = new User(enteredUsername, enteredPassword);

        if (enteredUsername.equals(user.getUsername()) && enteredPassword.equals(user.getPassword())) {
            System.out.println("Login successful!");
            return user;
        } else {
            System.out.println("Login failed. Incorrect username or password.");
            return null;
        }
    }

    private static void handleParkingSystem(Scanner scanner, BookingSystem bookingSystem, User user) {
        while (true) {
            System.out.println("\nParking System Menu:");
            System.out.println("1. View Available Parking Spaces");
            System.out.println("2. Book a Parking Space");
            System.out.println("3. View Booked Spaces");
            System.out.println("4. Logout");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableParkingSpaces(bookingSystem);
                    break;
                case 2:
                    bookParkingSpace(scanner, bookingSystem, user);
                    break;
                case 3:
                    viewBookedSpaces(bookingSystem, user);
                    break;
                case 4:
                    System.out.println("Logging out. Goodbye!");
                    return; // Exit the method and go back to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewAvailableParkingSpaces(BookingSystem bookingSystem) {
        System.out.println("\nAvailable Parking Spaces:");
        for (ParkingSpace space : bookingSystem.getAvailableSpaces()) {
            System.out.println("ID: " + space.getId() + ", Size: " + space.getSize() + ", Occupied: " + space.isOccupied());
        }
    }

    private static void bookParkingSpace(Scanner scanner, BookingSystem bookingSystem, User user) {
        System.out.println("\nAvailable Parking Spaces:");
        for (ParkingSpace space : bookingSystem.getAvailableSpaces()) {
            System.out.println("ID: " + space.getId() + ", Size: " + space.getSize() + ", Occupied: " + space.isOccupied());
        }

        System.out.print("Enter the ID of the parking space you want to book: ");
        int parkingSpaceId = scanner.nextInt();

        System.out.println("Enter the number plate of your vehicle: ");
        String numberPlate = scanner.next();

        ParkingSpace selectedSpace = bookingSystem.getAvailableSpaces().stream()
                .filter(space -> space.getId() == parkingSpaceId)
                .findFirst()
                .orElse(null);

        if (selectedSpace != null) {
            bookingSystem.bookSpace(user, selectedSpace);
        } else {
            System.out.println("Invalid parking space ID. Please try again.");
        }
    }

    private static void viewBookedSpaces(BookingSystem bookingSystem, User user) {
        List<ParkingSpace> userBookedSpaces = bookingSystem.getBookedSpaces(user);

        if (userBookedSpaces.isEmpty()) {
            System.out.println("You haven't booked any parking spaces yet.");
        } else {
            System.out.println("\nYour Booked Spaces:");
            for (ParkingSpace space : userBookedSpaces) {
                System.out.println("ID: " + space.getId() + ", Size: " + space.getSize());
            }
        }
    }
}
