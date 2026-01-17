package main.java.other1.cabFinder;

import java.util.*;

/*
City Dimension: 50, Radius: 5
Cab Locations: c1: 10, c2: 19, c3: 22, c4: 30

r1 = bookRide(u1: 15, end: 35)

r2 = bookRide(u2: 16, end: 5)

endRide(r1)

r3 = bookRide(u3: 38, end: 20)

endRide(r3)

r4 = bookRide(u4: 49, end: 40)

getDetails(c2)

getDetails(u1)

getDetails(r4)
 */

public class Meesho {
    final TreeMap<Integer, Set<String>> cabPositions;
    final Integer searchRadius;
    final Integer citySize;
    final Map<String, TripDetail> tripDetails;
    final Map<String, UserProfile> userProfileMap;
    final Map<String, Cab> cabMap;

    public Meesho(int k, int r) {
        cabPositions = new TreeMap<>();
        searchRadius = r;
        citySize = k;
        tripDetails = new HashMap<>();
        userProfileMap = new HashMap<>();
        cabMap = new HashMap<>();

    }


    public static void main(String[] args) {
        //initialise
        var obj = new Meesho(50, 5);

        var driver1 = new UserProfile("d1", UserType.DRIVER);
        var driver2 = new UserProfile("d2", UserType.DRIVER);
        var driver3 = new UserProfile("d3", UserType.DRIVER);
        var driver4 = new UserProfile("d4", UserType.DRIVER);


        var user1 = new UserProfile("u1", UserType.RIDER);
        var user2 = new UserProfile("u2", UserType.RIDER);
        var user3 = new UserProfile("u3", UserType.RIDER);
        var user4 = new UserProfile("u4", UserType.RIDER);

        obj.userProfileMap.put(driver1.id, driver1);
        obj.userProfileMap.put(driver2.id, driver2);
        obj.userProfileMap.put(driver3.id, driver3);
        obj.userProfileMap.put(driver4.id, driver4);
        obj.userProfileMap.put(user1.id, user1);
        obj.userProfileMap.put(user2.id, user2);
        obj.userProfileMap.put(user3.id, user3);
        obj.userProfileMap.put(user4.id, user4);


        List<Cab> cabs = new ArrayList<>();
        cabs.add(new Cab("cab1", 10, "d1"));
        cabs.add(new Cab("cab2", 19, "d2"));
        cabs.add(new Cab("cab3", 22, "d3"));
        cabs.add(new Cab("cab4", 30, "d4"));

        for (Cab cab : cabs) {
            obj.cabMap.put(cab.id, cab);
            obj.cabPositions.computeIfAbsent(cab.location, k -> new HashSet<>()).add(cab.id);
        }

        var r1 = obj.bookTrip("u1", 15, 35);
        var r2 = obj.bookTrip("u2", 16, 5);
        obj.endTrip(r1);
        var r3 = obj.bookTrip("u3", 38, 20);
        obj.endTrip(r3);
        var r4 = obj.bookTrip("u4", 49, 40);

        obj.getDetails(r1, DetailType.TRIP);
        obj.getDetails(user3.id, DetailType.RIDER);

    }

    void addUserProfile(UserProfile userProfile) {
        userProfileMap.put(userProfile.id, userProfile);
    }

    public Integer findNearest(int target) {
        Integer floor = cabPositions.floorKey(target);   // greatest <= target
        Integer ceil = cabPositions.ceilingKey(target); // smallest >= target

        if (floor == null)
            return ceil;
        if (ceil == null)
            return floor;

        // both exist → pick closer one
        return (target - floor <= ceil - target) ? floor : ceil;
    }

    void getDetails(String id, DetailType type) {
        switch (type) {
            case DRIVER, RIDER:
                UserProfile userProfile = userProfileMap.get(id);
                TripDetail tripDetail = tripDetails.get(userProfile.trips.get(userProfile.trips.size() - 1));
                System.out.printf("\nTotal trips ::%d, total transaction Amount::%d, last ride details:: start::%d, " +
                        "end::%d, fare::%d", userProfile.trips.size(), userProfile.totalTransactionAmount, tripDetail.startPoint, tripDetail.endPoint, tripDetail.fare);
                return;
            case TRIP:
                TripDetail detail = tripDetails.get(id);
                System.out.printf("\nstart::%d, end::%d, fare::%d", detail.startPoint, detail.endPoint, detail.fare);
                return;
        }
    }


    String bookTrip(String userId, int start, int end) {
        Integer nearest = findNearest(start);
        if (nearest != null) {
            String cabId = cabPositions.get(nearest).stream().findFirst().orElse(null);
            if (Math.abs(nearest - start) > searchRadius || cabId == null) {
                System.out.printf("\nNo cabs available at location %d", start);
                return null;
            }

            cabPositions.get(nearest).remove(cabId);
            if (cabPositions.get(nearest).isEmpty()) {
                cabPositions.remove(nearest);
            }

            Cab cab = cabMap.get(cabId);
            String tripId = userId + nearest + new Random().nextInt();
            int fare = Math.abs(start - end) * 10;
            TripDetail tripDetail = new TripDetail(tripId, start, end, fare, TripStatus.ONGOING, cabId, cab.driverId, userId);
            tripDetails.put(tripId, tripDetail);
            UserProfile userProfile = userProfileMap.get(userId);
            if (userProfile != null) {
                userProfile.addTrip(tripDetail);
                userProfileMap.put(tripId, userProfile);
            }

            UserProfile driverProfile = userProfileMap.get(cab.driverId);
            if (driverProfile != null) {
                driverProfile.addTrip(tripDetail);
                userProfileMap.put(tripId, userProfile);
            }

            System.out.printf("\nCab booked. Trip id :%s , cab id :%s", tripId, cab.id);
            return tripId;
        }
        System.out.printf("\nNo cabs available at location %d", start);
        return null;
    }

    void endTrip(String tripId) {
        TripDetail tripDetail = tripDetails.get(tripId);
        if (tripDetail != null) {
            String cabId = tripDetail.cabId;
            int endPoint = tripDetail.endPoint;
            cabPositions.computeIfAbsent(endPoint, k -> new HashSet<>()).add(cabId);

            tripDetail.status = TripStatus.COMPLETED;
            tripDetails.put(tripId, tripDetail);
        }
    }


}

enum UserType {
    RIDER,
    DRIVER
}

enum DetailType {
    RIDER,
    DRIVER,
    TRIP
}

class UserProfile {
    public String id;
    public UserType type;

    public List<String> trips;
    public int totalTransactionAmount;

    public UserProfile(String id, UserType type) {
        this.id = id;
        this.type = type;
        this.trips = new ArrayList<>();
    }

    public void addTrip(TripDetail tripDetail) {
        trips.add(tripDetail.id);
        totalTransactionAmount += tripDetail.fare;
    }
}

enum TripStatus {
    ONGOING,
    COMPLETED
}

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Location other) {
        return Math.abs(x - other.x) + Math.abs(y - other.y);
    }
}


class Cab {
    public String id;
    public int location;
    public String driverId;

    public Cab(String id, int location, String driverId) {
        this.id = id;
        this.location = location;
        this.driverId = driverId;
    }
}


