package main.java.other1.cabFinder;

public class TripDetail {
    public String id;
    public int startPoint;
    public int endPoint;
    public int fare;
    public TripStatus status;
    public String cabId;
    public String driverId;
    public String passengerId;

    public TripDetail(String id, int startPoint, int endPoint, int fare, TripStatus status, String cabId, String driverId, String passengerId) {
        this.id = id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.fare = fare;
        this.status = status;
        this.cabId = cabId;
        this.driverId = driverId;
        this.passengerId = passengerId;
    }
}
