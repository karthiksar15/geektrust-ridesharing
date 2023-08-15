package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.IRideServices;

public class MatchCommand implements ICommand {
    private IRideServices rideServices;

    public MatchCommand(IRideServices rideServices) {
        this.rideServices = rideServices;
    }

    @Override
    public void execute(List<String> tokens) {
        int riderIdIndex = 1;
        String riderId = tokens.get(riderIdIndex);
        rideServices.findMatch(riderId);

    }

}
