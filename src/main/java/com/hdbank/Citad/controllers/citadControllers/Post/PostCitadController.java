package com.hdbank.Citad.controllers.citadControllers.Post;


import com.hdbank.Citad.dtos.request.CitadDTO;
import com.hdbank.Citad.dtos.response.BaseResponse;
import com.hdbank.Citad.services.CitadServices.CitadService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@SecurityRequirement(name = "Api-Key")
@Tag(name = "Post Citad Controller", description = "Post Citad Controller")
@RequestMapping("/api/v1/citad")
public class PostCitadController {
    private final CitadService citadService;
    @Autowired
    public PostCitadController(CitadService citadService) {
        this.citadService = citadService;
    }

    @PostMapping
    public Mono<BaseResponse<String>> postCitad(@RequestBody List<CitadDTO> citads) {
        return citadService.insertCitads(citads);
    }
}
