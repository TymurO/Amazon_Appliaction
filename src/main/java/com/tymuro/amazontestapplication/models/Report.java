package com.tymuro.amazontestapplication.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Report {

    @Id
    private String id;

    private ReportSpecification reportSpecification;

    private List<SalesAndTrafficByDate> salesAndTrafficByDate;

    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
}
