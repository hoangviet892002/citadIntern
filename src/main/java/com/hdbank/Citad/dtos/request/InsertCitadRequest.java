package com.hdbank.Citad.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InsertCitadRequest {
    @JsonProperty("citads")
    List<CitadDTO> citads;
}
