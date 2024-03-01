package com.tymuro.amazontestapplication.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportOptions {

    private String dateGranularity;
    private String asinGranularity;
}