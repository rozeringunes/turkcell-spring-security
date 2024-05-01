package com.turkcell.springSecurity.api.controller;

import com.turkcell.springSecurity.business.abstracts.CarService;
import com.turkcell.springSecurity.business.dto.requests.CreateCarRequest;
import com.turkcell.springSecurity.business.dto.responses.CreatedCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cars")
public class CarsController {
    private CarService carService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest){
        return carService.add(createCarRequest);
    }

}
