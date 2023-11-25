// BikeParkingSpace.java
public class BikeParkingSpace extends ParkingSpace {
    public BikeParkingSpace(int id) {
        super(id, Size.SMALL);
    }

    @Override
    public void occupySpace() {
        System.out.println("Bike parking space occupied.");
        this.isOccupied = true;
    }

    @Override
    public void vacantSpace() {
        System.out.println("Bike parking space vacant.");
        this.isOccupied = false;
    }
}
