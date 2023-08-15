package com.example.geektrust.appconfig;

import com.example.geektrust.commands.AddDriverCommand;
import com.example.geektrust.commands.AddRiderCommand;
import com.example.geektrust.commands.BillCommand;
import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.commands.MatchCommand;
import com.example.geektrust.commands.StartRideCommand;
import com.example.geektrust.commands.StopRideCommand;
import com.example.geektrust.repositories.DriverRepository;
import com.example.geektrust.repositories.IDriverRepository;
import com.example.geektrust.repositories.IRideRepository;
import com.example.geektrust.repositories.IRiderRepository;
import com.example.geektrust.repositories.RideRepository;
import com.example.geektrust.repositories.RiderRepository;
import com.example.geektrust.services.DriverServices;
import com.example.geektrust.services.IDriverServices;
import com.example.geektrust.services.IRideServices;
import com.example.geektrust.services.IRiderServices;
import com.example.geektrust.services.RideServices;
import com.example.geektrust.services.RiderServices;

public class ApplicationConfig {

  private IRideRepository rideRepository = new RideRepository();
  private IDriverServices driverServices = new DriverServices(new DriverRepository());
  private IRiderServices riderServices = new RiderServices(new RiderRepository());
  private IRideServices rideServices = new RideServices(rideRepository, driverServices, riderServices);
  

  private final CommandInvoker commandInvoker=new CommandInvoker();

    public CommandInvoker getCommandInvoker()
    {
        commandInvoker.register("ADD_DRIVER", new AddDriverCommand(driverServices));
        commandInvoker.register("ADD_RIDER", new AddRiderCommand(riderServices));
        commandInvoker.register("MATCH", new MatchCommand(rideServices));
        commandInvoker.register("START_RIDE", new StartRideCommand(rideServices));
        commandInvoker.register("STOP_RIDE", new StopRideCommand(rideServices));
        commandInvoker.register("BILL", new BillCommand(rideServices));
        return commandInvoker;
    }

}
