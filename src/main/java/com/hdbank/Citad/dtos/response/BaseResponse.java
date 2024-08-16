package com.hdbank.Citad.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hdbank.Citad.shared.enums.ResponseEnum;
import lombok.Setter;


@Setter
public class BaseResponse<T>  {
    @JsonProperty("response_code")
    private String responseCode;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private T data;
}
