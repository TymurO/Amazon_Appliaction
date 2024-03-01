package com.tymuro.amazontestapplication.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class ReportSpecification {

    private String reportType;

    @Embedded
    private ReportOptions reportOptions;

    private LocalDate dataStartTime;

    private LocalDate dataEndTime;

    private List<String> marketplaceIds;
}
