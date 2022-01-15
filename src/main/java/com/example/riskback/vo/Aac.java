package com.example.riskback.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aac {
    @JsonProperty("Diameter")
    private String Diameter;
    @JsonProperty("Staging")
    private String Staging;
    @JsonProperty("TumorDiff")
    private String TumorDiff;
    @JsonProperty("Invasion")
    private String Invasion;
}
