// BookingSystem.java
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<ParkingSpace> availableSpaces;
    private List<ParkingSpace> bookedSpaces;

    public BookingSystem() {
        availableSpaces = new ArrayList<>();
        bookedSpaces = new ArrayList<>();
    }

    public void addParkingSpace(ParkingSpace space) {
        availableSpaces.add(space);
    }

    public void bookSpace(User user, ParkingSpace space) {
        if (!space.isOccupied()) {
            space.occupySpace();
            bookedSpaces.add(space);
            System.out.println("Booking confirmed for " + user.getUsername());
        } else {
            System.out.println("Parking space is already occupied.");
        }
    }

    public List<ParkingSpace> getAvailableSpaces() {
        return availableSpaces;
    }

    public List<ParkingSpace> getBookedSpaces(User user) {
        List<ParkingSpace> userBookedSpaces = new ArrayList<>();
        for (ParkingSpace space : bookedSpaces) {
            if (space.getId() / 100 == user.getUsername().hashCode()) {
                userBookedSpaces.add(space);
            }
        }
        return userBookedSpaces;
    }
}
