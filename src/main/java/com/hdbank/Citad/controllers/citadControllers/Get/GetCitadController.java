package com.hdbank.Citad.controllers.citadControllers.Get;


import com.hdbank.Citad.dtos.response.BaseList;
import com.hdbank.Citad.dtos.response.BaseResponse;
import com.hdbank.Citad.dtos.response.CitadReponse;
import com.hdbank.Citad.services.CitadServices.CitadService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import reactor.core.publisher.Mono;

@RestController
@SecurityRequirement(name = "Api-Key")
@Tag(name = "Get Citad Controller", description = "Get Citad Controller")
@RequestMapping("/api/v1/citad")
public class GetCitadController {

    private final CitadService citadService;
    @Autowired
    public GetCitadController(CitadService citadService) {
        this.citadService = citadService;
    }


    @GetMapping
    public Mono<BaseResponse<BaseList<CitadReponse>>> getCitad(@RequestParam String current, @RequestParam String pageSize) {
        return citadService.queryCitads(current, pageSize);
    }
}
