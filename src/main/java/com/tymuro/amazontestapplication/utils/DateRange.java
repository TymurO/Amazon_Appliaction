package com.tymuro.amazontestapplication.utils;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
public class DateRange implements Iterable<LocalDate> {

    private final LocalDate start;

    private final LocalDate end;

    @Override
    public Iterator<LocalDate> iterator() {
        return stream().iterator();
    }

    public Stream<LocalDate> stream() {
        return Stream.iterate(start, d -> d.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end) + 1);
    }

    public List<LocalDate> toList() {
        List<LocalDate> dates = new ArrayList<>();

        for (LocalDate d = start; !d.isAfter(end); d = d.plusDays(1)) {
            dates.add(d);
        }

        return dates;
    }
}
