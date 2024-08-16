package com.hdbank.Citad.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class BaseList <T>{
    @JsonProperty("current_page")
    private String currentPage;
    @JsonProperty("page_size")
    private String pageSize;
    @JsonProperty("total_page")
    private String totalPage;
    @JsonProperty("total_record")
    private String totalRecord;
    @JsonProperty("data")
    private List<T> data;
}
