package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.IRiderServices;

public class AddRiderCommand implements ICommand {

    private IRiderServices riderServices;
    private int riderIdIndex = 1;
    private int xPointIndex = 2;
    private int yPointIndex = 3;

    public AddRiderCommand(IRiderServices riderServices) {
        this.riderServices = riderServices;
    }

    @Override
    public void execute(List<String> tokens) {
        String riderId = tokens.get(riderIdIndex);
        String xPoint = tokens.get(xPointIndex);
        String yPoint = tokens.get(yPointIndex);

        riderServices.save(riderId, xPoint, yPoint);

    }

}
