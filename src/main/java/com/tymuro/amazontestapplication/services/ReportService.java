package com.tymuro.amazontestapplication.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.tymuro.amazontestapplication.config.LocalDateTypeAdapter;
import com.tymuro.amazontestapplication.converters.DtoConverter;
import com.tymuro.amazontestapplication.dto.SalesAndTrafficByDateDto;
import com.tymuro.amazontestapplication.models.*;
import com.tymuro.amazontestapplication.repositories.ReportRepository;
import com.tymuro.amazontestapplication.utils.DateRange;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.json.JsonObject;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportService {

    private final ReportRepository reportRepository;

    private final CacheManager cacheManager;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Cacheable(cacheNames = {"reportsByAsin"}, key="#asins")
    public ResponseEntity<?> getReportsContainingAsin(List<String> asins) {
        log.info("Function for getting reports by asin was called");
        if (asins.isEmpty()) {
            return ResponseEntity.ok(DtoConverter.convertStatsByAsin(reportRepository.getStatisticForEveryAsin()));
        }
        List<Report> reports = reportRepository.getReportsByAsins(asins);
        for (Report report: reports) {
            report.setSalesAndTrafficByDate(null);
            List<SalesAndTrafficByAsin> asinStats = new ArrayList<>();
            for (SalesAndTrafficByAsin stat: report.getSalesAndTrafficByAsin()) {
                if (asins.contains(stat.getParentAsin())) {
                    asinStats.add(stat);
                }
            }
            report.setSalesAndTrafficByAsin(asinStats);
        }
        return ResponseEntity.ok(reports);
    }

    @Cacheable(cacheNames = {"reportsByDate"}, key = "#key")
    public ResponseEntity<?> getReportsByDate(String date, String dateEndTime, String key) {
        log.info("Function for getting reports by date was called");
        List<Report> reports = reportRepository.findAll();
        if (date == null && dateEndTime == null) {
            return ResponseEntity.ok(DtoConverter.convertStatsByDate(reportRepository.getStatisticForAllTime()));
        }
        if (dateEndTime != null && date == null) {
            return ResponseEntity.status(400).body("Date can't be null if final date is not null");
        }
        LocalDate startDate = LocalDate.parse(date);
        LocalDate endDate = LocalDate.parse(date);
        if (dateEndTime != null) {
            endDate = LocalDate.parse(dateEndTime);
        }
        if (endDate.isBefore(startDate)) {
            return ResponseEntity.status(400).body("Final date can't be earlier than the first");
        }
        List<LocalDate> dates = new DateRange(startDate, endDate).toList();

        for (Report report: reports) {
            report.setSalesAndTrafficByAsin(null);
            List<SalesAndTrafficByDate> dateStats = new ArrayList<>();
            for (SalesAndTrafficByDate stat: report.getSalesAndTrafficByDate()) {
                if (dates.contains(stat.getDate())) {
                    dateStats.add(stat);
                }
            }
            report.setSalesAndTrafficByDate(dateStats);
        }
        reports =  reports.stream().filter(report -> !report.getSalesAndTrafficByDate().isEmpty()).toList();
        return ResponseEntity.ok(reports);
    }

    public void updateReport(Report report) {
        Report main = reportRepository.findAll().get(0);
        report.setId(main.getId());
        reportRepository.save(report);
        log.info("Data updated");
    }

    public void clearAllCache() {
        cacheManager.getCacheNames().forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }

//    @Scheduled(fixedRate = 60000)
//    public void readReports() throws IOException {
//        String json = new String(Files.readAllBytes(Paths.get("src/main/resources/test_report.json")));
//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
//        Report report = gson.fromJson(json, Report.class);
//        updateReport(report);
//        clearAllCache();
//    }
}
