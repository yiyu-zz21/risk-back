package com.example.riskback.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Form {
    @JsonProperty("Far")
    private String Far;
    @JsonProperty("CA199")
    private String CA199;
    @JsonProperty("TumorDiff")
    private String TumorDiff;
    @JsonProperty("Staging")
    private String Staging;
}
