package com.hdbank.Citad.repository.CitadRepo.operations;

import com.hdbank.Citad.models.CitadEntity;

import java.util.List;
import java.util.Optional;

public interface CitadReadRepository {
    Optional<CitadEntity> findById(Long id);
    List<CitadEntity> findAll();
}
