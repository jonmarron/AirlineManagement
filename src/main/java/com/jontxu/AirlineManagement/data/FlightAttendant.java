package com.jontxu.AirlineManagement.data;

import java.time.LocalDate;
import java.util.List;

public class FlightAttendant extends AirlineEmployee {
    private final List<Language> languages;
    public FlightAttendant(String name, LocalDate birthDate, List<Language> languages) {
        super(name, birthDate);
        this.languages = languages;
    }

    public List<Language> getLanguages() {
        return languages;
    }
}
