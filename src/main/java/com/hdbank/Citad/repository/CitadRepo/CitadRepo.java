package com.hdbank.Citad.repository.CitadRepo;


import com.hdbank.Citad.models.CitadEntity;
import com.hdbank.Citad.repository.CitadRepo.operations.CitadCreateRepository;
import com.hdbank.Citad.repository.CitadRepo.operations.CitadDeleteRepository;
import com.hdbank.Citad.repository.CitadRepo.operations.CitadReadRepository;
import com.hdbank.Citad.repository.CitadRepo.operations.CitadUpdateRepository;
import org.reactivestreams.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitadRepo extends JpaRepository<CitadEntity, Integer>,
        CitadCreateRepository,
        CitadReadRepository,
        CitadUpdateRepository,
        CitadDeleteRepository {

}
