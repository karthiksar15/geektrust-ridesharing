package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.IRideServices;

public class StartRideCommand implements ICommand {

    private IRideServices rideServices;
    private int rideIdIndex = 1;
    private int posIndex = 2;
    private int riderIdIndex = 3;

    public StartRideCommand(IRideServices rideServices) {
        this.rideServices = rideServices;
    }

    @Override
    public void execute(List<String> tokens) {

        String rideId = tokens.get(rideIdIndex);
        Integer position = Integer.parseInt(tokens.get(posIndex));
        String riderId = tokens.get(riderIdIndex);

        rideServices.startRide(rideId, position, riderId);

    }

}
