package com.tymuro.amazontestapplication.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesAndTrafficByAsin {

    private String parentAsin;

    private Sales salesByAsin;

    private Traffic trafficByAsin;
}
