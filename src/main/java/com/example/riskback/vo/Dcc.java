package com.example.riskback.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dcc {
    @JsonProperty("Diameter")
    private String Diameter;
    @JsonProperty("CA199")
    private String CA199;
    @JsonProperty("TumorDiff")
    private String TumorDiff;
    @JsonProperty("Invasion")
    private String Invasion;
}
