package com.example.geektrust.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.example.geektrust.entities.Driver;
import com.example.geektrust.entities.Fare;
import com.example.geektrust.entities.Location;
import com.example.geektrust.entities.MatchedDriver;
import com.example.geektrust.entities.Ride;
import com.example.geektrust.entities.RideStatus;
import com.example.geektrust.entities.Rider;
import com.example.geektrust.repositories.IRideRepository;

public class RideServices implements IRideServices, Fare {

    private IRideRepository rideRepository;
    private IDriverServices driverServices;
    private IRiderServices riderServices;
    private static List<MatchedDriver> driversAvailable;
    private Ride ride;
    private Rider rider;

    public RideServices(IRideRepository rideRepository, IDriverServices driverServices, IRiderServices riderServices) {
        this.rideRepository = rideRepository;
        this.driverServices = driverServices;
        this.riderServices = riderServices;
    }

    @Override
    public void findMatch(String riderId) {
        rider = riderServices.findRider(riderId);
        driversAvailable = fetchNearestDriver(rider.getLocation());
        Comparator<MatchedDriver> matchedDriversSorted = Comparator.comparingDouble(MatchedDriver::getDistance)
                .thenComparing(MatchedDriver::getDriverId);
        Collections.sort(driversAvailable, matchedDriversSorted);

        if (!driversAvailable.isEmpty()) {
            printMessagesWithout("DRIVERS_MATCHED");
            for (MatchedDriver matchedDriver : driversAvailable) {
                printMessagesWithout(" ");
                printMessagesWithout(matchedDriver.getDriverId());
            }
            printMessages("");

        } else {
            printMessages("NO_DRIVERS_AVAILABLE");
        }

    }

    public List<MatchedDriver> fetchNearestDriver(Location location) {
        List<Driver> drivers = driverServices.findAllDrivers();
        List<MatchedDriver> nearestDrivers = new ArrayList<>();
        Double distanceLimit = 5.0;
        for (Driver driver : drivers) {
            Double distance = getLocationRadius(driver.getLocation(), location);
            if (distance <= distanceLimit) {
                nearestDrivers.add(new MatchedDriver(distance, driver.getId()));
            }
        }
        return nearestDrivers;
    }

    public Double getLocationRadius(Location location1, Location location2) {
        int pow = 2;
        Double num1 = Math.pow((location2.getX() - location1.getX()), pow);
        Double num2 = Math.pow((location2.getY() - location1.getY()), pow);
        return Math.sqrt(num1 + num2);
    }

    public void startRide(String rideId, Integer driverNos, String riderId) {
        int subsPos = 1;
        Optional<Ride> rideOptional = rideRepository.findById(rideId);
        if (rideOptional.isPresent())
            ride = rideOptional.get();

        MatchedDriver matchedDriver = driversAvailable.get(driverNos - subsPos);
        Driver driver = driverServices.findDriver(matchedDriver.getDriverId());
        rider = riderServices.findRider(riderId);
        if (driverNos > driversAvailable.size() || ride != null) {
            printMessages("INVALID_RIDE");
        } else {
            ride = new Ride(rideId, driver, rider);
            rideRepository.save(ride);
            printMessages("RIDE_STARTED " + rideId);
        }
    }

    public void stopRide(String rideId, Location location, Integer timeTaken) {

        ride = rideRepository.findById(rideId).isPresent() ? rideRepository.findById(rideId).get() : null;

        if (ride == null || ride.getRideStatus() == RideStatus.COMPLETED) {
            printMessages("INVALID_RIDE");
        } else {
            printMessages("RIDE_STOPPED " + rideId);
            Location driverLocation = ride.getDriver().getLocation();
            Double totalKm = getLocationRadius(driverLocation, location);
            updateBill(ride, totalKm, timeTaken);
        }
    }

    public void updateBill(Ride ride, Double totalKm, Integer timeTaken) {
        Double amount = BASEFARE + (EVERYKM * totalKm) + (timeTaken * EVERYMIN);
        Double totAmount = amount + (amount * SERVICETAX);
        ride = new Ride(ride, RideStatus.COMPLETED, totAmount);
        rideRepository.save(ride);
    }

    public void printBill(String rideId) {
        ride = rideRepository.findById(rideId).get();
        if (ride.getRideStatus() == RideStatus.COMPLETED)
            printMessages("BILL " + rideId + " " + ride.getDriver().getId() + " " + ride.getBillAmount());
        else
            printMessages("RIDE_NOT_COMPLETED");
    }

    public void printMessages(String message) {
        System.out.println(message);
    }
     public void printMessagesWithout(String message) {
        System.out.print(message);
    }

}
