// CarParkingSpace.java
public class CarParkingSpace extends ParkingSpace {
    public CarParkingSpace(int id) {
        super(id, Size.MEDIUM);
    }

    @Override
    public void occupySpace() {
        System.out.println("Car parking space occupied.");
        this.isOccupied = true;
    }

    @Override
    public void vacantSpace() {
        System.out.println("Car parking space vacant.");
        this.isOccupied = false;
    }
}
