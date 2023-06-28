package com.jontxu.AirlineManagement.data;

import java.util.List;

public record Flight(
        int uniqueId,
        Language language,
        List<Pilot> pilots,
        List<FlightAttendant> flightAttendants
) {}
