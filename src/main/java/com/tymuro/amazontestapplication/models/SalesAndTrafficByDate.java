package com.tymuro.amazontestapplication.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesAndTrafficByDate {

    private LocalDate date;

    private Sales salesByDate;

    private Traffic trafficByDate;
}
