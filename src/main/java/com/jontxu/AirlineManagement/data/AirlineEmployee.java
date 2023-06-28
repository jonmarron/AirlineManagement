package com.jontxu.AirlineManagement.data;

import java.time.LocalDate;

public abstract class AirlineEmployee {
    private final String name;
    private final LocalDate birthDate;
    private boolean isReady;

    public AirlineEmployee(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        isReady = false;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
}
