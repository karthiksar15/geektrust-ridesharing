package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.IDriverServices;

public class AddDriverCommand implements ICommand {

    private IDriverServices driverServices;
    private int driverIdIndex = 1;
    private int xPointIndex = 2;
    private int yPointIndex = 3;

    public AddDriverCommand(IDriverServices driverServices) {
        this.driverServices = driverServices;
    }

    @Override
    public void execute(List<String> tokens) {
        String driverId = tokens.get(driverIdIndex);
        String xPoint = tokens.get(xPointIndex);
        String yPoint = tokens.get(yPointIndex);

        driverServices.saveDriver(driverId, xPoint, yPoint);
    }

}
