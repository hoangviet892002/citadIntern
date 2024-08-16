package com.hdbank.Citad.services.CitadServices.operations;


import com.hdbank.Citad.dtos.response.BaseList;
import com.hdbank.Citad.dtos.response.BaseResponse;
import com.hdbank.Citad.dtos.response.CitadReponse;
import reactor.core.publisher.Mono;

public interface QueryCitadService {
    Mono<BaseResponse<BaseList<CitadReponse>>> queryCitads(String currentPage, String pageSize);
}
