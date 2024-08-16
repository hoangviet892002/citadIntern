package com.hdbank.Citad.mappers;

import com.hdbank.Citad.dtos.request.CitadDTO;
import com.hdbank.Citad.dtos.response.CitadReponse;
import com.hdbank.Citad.models.CitadEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CitadMapper {
    public CitadEntity mapToEntity(CitadDTO dto) {
        CitadEntity entity = new CitadEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setBranch(dto.getBranch());
        return entity;
    }
    public List<CitadEntity> mapToEntity(List<CitadDTO> dtos) {
        return dtos.stream().map(this::mapToEntity).toList();
    }

    public CitadReponse mapToResponse(CitadEntity entity) {
        CitadReponse response = new CitadReponse();
        response.setCode(entity.getCode());
        response.setName(entity.getName());
        response.setBranch(entity.getBranch());
        return response;
    }
    public List<CitadReponse> mapToResponse(List<CitadEntity> entities) {
        return entities.stream().map(this::mapToResponse).toList();
    }


}
