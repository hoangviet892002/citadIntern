package com.hdbank.Citad.services.CitadServices.operations;


import com.hdbank.Citad.dtos.request.CitadDTO;
import com.hdbank.Citad.dtos.response.BaseResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface InsertCitadService {
    String insertCitad(String citad);

    Mono<BaseResponse<String>> insertCitads(List<CitadDTO> citads);


}
