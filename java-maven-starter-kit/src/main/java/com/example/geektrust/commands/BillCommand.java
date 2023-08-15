package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.IRideServices;

public class BillCommand implements ICommand {

    private IRideServices rideServices;

    public BillCommand(IRideServices rideServices)
    {
        this.rideServices=rideServices;
    }

    @Override
    public void execute(List<String> tokens) {
        int rideIdIndex=1;
        rideServices.printBill(tokens.get(rideIdIndex));
  
    }
    
}
