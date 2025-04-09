package model;

import java.time.LocalDate;

public class Reservation {
    protected LocalDate date;

    public Reservation(LocalDate dateReservation) {
        this.date = dateReservation;
    }

    @Override
    public String toString() {
        return "Le " + date.getDayOfMonth() + "/" + date.getMonthValue();
    }
}