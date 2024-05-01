package com.turkcell.springSecurity.api.controller;

import com.turkcell.springSecurity.business.abstracts.BrandService;
import com.turkcell.springSecurity.business.dto.requests.CreateBrandRequest;
import com.turkcell.springSecurity.business.dto.responses.CreatedBrandResponse;
import com.turkcell.springSecurity.business.dto.responses.GetAllBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController  {
    private BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest){
        return brandService.add(createBrandRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAll(){
        return brandService.getAll();
    }
}