// ParkingSpace.java
public abstract class ParkingSpace {
    private int id;
    private Size size;
    public boolean isOccupied;
    private String licenseNumber;

    public ParkingSpace(int id, Size size) {
        this.id = id;
        this.size = size;
        this.isOccupied = false;
    }

    public enum Size {
        SMALL, MEDIUM
    }

    public int getId() {
        return id;
    }

    public Size getSize() {
        return size;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public abstract void occupySpace();

    public abstract void vacantSpace();
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

}
