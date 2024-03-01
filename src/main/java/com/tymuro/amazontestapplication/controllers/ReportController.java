package com.tymuro.amazontestapplication.controllers;

import com.tymuro.amazontestapplication.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/report")
@RequiredArgsConstructor
@RestController
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/all")
    public ResponseEntity<?> getReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @GetMapping("/asin")
    public ResponseEntity<?> getReportsByAsin(@RequestBody(required = false) List<String> asins) {
        if (asins == null) {
            asins = new ArrayList<>();
        }
        return reportService.getReportsContainingAsin(asins);
    }

    @GetMapping("/date")
    public ResponseEntity<?> getReportsByDate(@RequestParam(name = "date", required = false) String date, @RequestParam(required = false, name = "dateEndTime") String dateEndTime) {
        String key = "";
        key += date + dateEndTime;
        return reportService.getReportsByDate(date, dateEndTime, key);
    }
}
