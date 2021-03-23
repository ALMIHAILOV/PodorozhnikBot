package org.PodorozhnikBot.services;

import org.PodorozhnikBot.Constants;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class GetDate {
    public Date getEndDate() {
        LocalDateTime now = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("Europe/Moscow");

        return Date.from(now.atZone(zoneId).toInstant());
    }

    public Date getStartDate(String period) {
        LocalDateTime now = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("Europe/Moscow");

        switch (period) {
            case Constants.TODAY -> {
                return Date.from(now.with(LocalTime.MIDNIGHT).atZone(zoneId).toInstant());
            }
            case Constants.WEEK -> {
                return Date.from(now.with(LocalTime.MIDNIGHT).with(TemporalAdjusters.previous(DayOfWeek.MONDAY)).atZone(zoneId).toInstant());
            }
            case Constants.MONTH -> {
                return Date.from(now.with(LocalTime.MIDNIGHT).with(TemporalAdjusters.firstDayOfMonth()).atZone(zoneId).toInstant());
            }
            case Constants.YEAR -> {
                return Date.from(now.with(LocalTime.MIDNIGHT).with(TemporalAdjusters.firstDayOfYear()).atZone(zoneId).toInstant());
            }
            default -> {
                return Date.from(now.atZone(zoneId).toInstant());
            }
        }
    }

}
