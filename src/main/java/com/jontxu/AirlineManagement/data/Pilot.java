package com.jontxu.AirlineManagement.data;

import java.time.LocalDate;

public class Pilot extends AirlineEmployee {
    private final PilotType pilotType;
    private boolean hasCompass;
    public Pilot(String name, LocalDate birthDate, PilotType pilotType, boolean hasCompass) {
        super(name, birthDate);
        this.pilotType = pilotType;
        this.hasCompass = hasCompass;
    }

    public void setHasCompass(boolean hasCompass) {
        this.hasCompass = hasCompass;
    }

    public boolean hasCompass() {
        return hasCompass;
    }
}
