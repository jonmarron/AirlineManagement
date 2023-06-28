package com.jontxu.AirlineManagement.logic;

import com.jontxu.AirlineManagement.data.Flight;
import com.jontxu.AirlineManagement.data.FlightAttendant;
import com.jontxu.AirlineManagement.data.Pilot;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static com.jontxu.AirlineManagement.data.Language.*;
import static com.jontxu.AirlineManagement.data.PilotType.CAPTAIN;
import static com.jontxu.AirlineManagement.data.PilotType.CO_PILOT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.of;

class FlightServiceTest {

    List<FlightAttendant> flightAttendants = List.of(new FlightAttendant("name1", LocalDate.now(), List.of(SPANISH, GERMAN)),
            new FlightAttendant("name2", LocalDate.now(), List.of(ENGLISH, SPANISH)),
            new FlightAttendant("name3", LocalDate.now(), List.of(ENGLISH, RUSSIAN, SPANISH)));
    List<Pilot> pilots = List.of(new Pilot("name1", LocalDate.now(), CAPTAIN, true),
            new Pilot("name2", LocalDate.now(), CO_PILOT, true));
    Flight flight = new Flight(1, SPANISH, pilots, flightAttendants);
    FlightService flightService = new FlightService(flight);

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(List.of(new FlightAttendant("name1", LocalDate.now(), List.of(SPANISH, GERMAN)),
                                new FlightAttendant("name2", LocalDate.now(), List.of(ENGLISH, SPANISH)),
                                new FlightAttendant("name3", LocalDate.now(), List.of(ENGLISH, RUSSIAN, SPANISH))),
                        List.of(new Pilot("name1", LocalDate.now(), CAPTAIN, true),
                                new Pilot("name2", LocalDate.now(), CO_PILOT, true)),
                        true
                ),
                of(List.of(new FlightAttendant("name1", LocalDate.now(), List.of(SPANISH, GERMAN)),
                                new FlightAttendant("name3", LocalDate.now(), List.of(ENGLISH, RUSSIAN, SPANISH))),
                        List.of(new Pilot("name1", LocalDate.now(), CAPTAIN, true),
                                new Pilot("name2", LocalDate.now(), CO_PILOT, true)),
                        false
                )
        );
    }


    @ParameterizedTest
    @MethodSource("parameters")
    void readyToFly(List<FlightAttendant> flightAttendants, List<Pilot> pilots, boolean expected) {
        Flight flight = new Flight(1, SPANISH, pilots, flightAttendants);
        FlightService flightService = new FlightService(flight);

        boolean result = flightService.readyToFly();

        assertEquals(expected, result);
    }


}