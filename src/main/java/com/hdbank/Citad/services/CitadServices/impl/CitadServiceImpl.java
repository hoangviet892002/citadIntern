package com.hdbank.Citad.services.CitadServices.impl;


import com.hdbank.Citad.dtos.request.CitadDTO;
import com.hdbank.Citad.dtos.response.BaseList;
import com.hdbank.Citad.dtos.response.BaseResponse;
import com.hdbank.Citad.dtos.response.CitadReponse;
import com.hdbank.Citad.mappers.CitadMapper;
import com.hdbank.Citad.models.CitadEntity;
import com.hdbank.Citad.repository.CitadRepo.CitadRepo;
import com.hdbank.Citad.services.CitadServices.CitadService;
import com.hdbank.Citad.shared.enums.ResponseEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CitadServiceImpl implements CitadService {

    private final CitadRepo citadRepo;

    private final CitadMapper citadMapper;

    public CitadServiceImpl(CitadRepo citadRepo, CitadMapper citadMapper) {
        this.citadRepo = citadRepo;
        this.citadMapper = citadMapper;
    }

    @Override
    public String insertCitad(String citad) {
        return "Citad inserted";
    }

    @Override
    public Mono<BaseResponse<String>> insertCitads(List<CitadDTO> citads) {
       Mono<List<CitadEntity>> monoCitadEntities = Flux.fromIterable(citads)
               .flatMap(
                          citadDTO -> {
                            CitadEntity citadEntity = citadMapper.mapToEntity(citadDTO);
                            return Mono.just(citadEntity);
                          }
                ).collectList();
        return monoCitadEntities.flatMap(
                citadEntities -> {
                    citadRepo.saveAll(citadEntities);
                    BaseResponse<String> response = new BaseResponse<String>();
                    response.setData("Citad inserted");
                    response.setResponseCode(ResponseEnum.SUCCESS.getResponseCode());
                    response.setMessage(ResponseEnum.SUCCESS.getMessage());
                    return Mono.just(response);
                }
        );

    }

    @Override
    public Mono<BaseResponse<BaseList<CitadReponse>>> queryCitads(String currentPage, String pageSize) {
        try {

            BaseList<CitadReponse> baseList = new BaseList<>();
            baseList.setCurrentPage(currentPage);
            baseList.setPageSize(pageSize);
            Page<CitadEntity> citadEntities = citadRepo.findAll(PageRequest.of(Integer.parseInt(currentPage), Integer.parseInt(pageSize)));
            List<CitadReponse> citadReponses = citadMapper.mapToResponse(citadEntities.getContent());
            baseList.setData(citadReponses);
            baseList.setTotalPage(String.valueOf(citadEntities.getTotalPages()));
            baseList.setTotalRecord(String.valueOf(citadEntities.getTotalElements()));
            BaseResponse<BaseList<CitadReponse>> response = new BaseResponse<>();
            response.setData(baseList);
            response.setResponseCode(ResponseEnum.SUCCESS.getResponseCode());
            response.setMessage(ResponseEnum.SUCCESS.getMessage());
            return Mono.just(response);
        } catch (Exception e) {
            BaseResponse<BaseList<CitadReponse>> response = new BaseResponse<>();
            response.setResponseCode(ResponseEnum.RESOURCE_NOT_FOUND.getResponseCode());
            response.setMessage(ResponseEnum.RESOURCE_NOT_FOUND.getMessage());
            return Mono.just(response);
        }
    }
}
