// Vehicle.java
public class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void displayInfo(){
        System.out.println("License plate: " + getLicensePlate());
    }
}
