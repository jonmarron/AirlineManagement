package com.jontxu.AirlineManagement.logic;

import com.jontxu.AirlineManagement.data.AirlineEmployee;
import com.jontxu.AirlineManagement.data.Flight;
import com.jontxu.AirlineManagement.data.FlightAttendant;
import com.jontxu.AirlineManagement.data.Pilot;

import java.util.List;

public class FlightService {
    private final Flight flight;

    public FlightService(Flight flight) {
        this.flight = flight;
    }

    public boolean checkFlightAttendantsReady(List<FlightAttendant> flightAttendants){
        for (FlightAttendant flightAttendant : flightAttendants) {
            if (flightAttendant.isReady()) flightAttendant.setReady(true);
        }
        return flightAttendants.size() == 3 && flightAttendants.stream()
                .allMatch(flightAttendant -> flightAttendant.getLanguages().contains(flight.language()));
    }
    public boolean checkPilotsReady(List<Pilot> pilots){
        for (Pilot pilot : pilots) {
            if(pilot.hasCompass()) pilot.setReady(true);
        }
        return pilots.size() == 2 && pilots.stream()
                .allMatch(AirlineEmployee::isReady);
    }

    public boolean readyToFly(){
        return checkPilotsReady(flight.pilots()) && checkFlightAttendantsReady(flight.flightAttendants());
    }
}
