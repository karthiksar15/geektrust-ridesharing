package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.entities.Location;
import com.example.geektrust.services.IRideServices;

public class StopRideCommand implements ICommand {

    private IRideServices rideServices;
    private int rideIdIndex = 1;
    private int xPoint = 2;
    private int yPoint = 3;
    private int timeTaken = 4;

    public StopRideCommand(IRideServices rideServices) {
        this.rideServices = rideServices;
    }

    @Override
    public void execute(List<String> tokens) {

        Integer xPointInt = Integer.parseInt(tokens.get(xPoint));
        Integer yPointInt = Integer.parseInt(tokens.get(yPoint));
        Integer timeTakenInt = Integer.parseInt(tokens.get(timeTaken));
        Location location = new Location(xPointInt, yPointInt);
        String rideId = tokens.get(rideIdIndex);

        rideServices.stopRide(rideId, location, timeTakenInt);

    }

}
