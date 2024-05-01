package com.turkcell.springSecurity.business.concretes;

import com.turkcell.springSecurity.business.abstracts.CarService;
import com.turkcell.springSecurity.business.dto.requests.CreateCarRequest;
import com.turkcell.springSecurity.business.dto.responses.CreatedCarResponse;
import com.turkcell.springSecurity.core.utilities.mapping.ModelMapperService;
import com.turkcell.springSecurity.dataAccess.abstracts.CarRepository;
import com.turkcell.springSecurity.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private ModelMapperService modelMapperService;
    private CarRepository carRepository;
    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);

        car.setCreatedDate(LocalDateTime.now());
        car.setState(1);
        Car createdCar = carRepository.save(car);

        CreatedCarResponse createdCarResponse = this.modelMapperService.forResponse()
                .map(createdCar,CreatedCarResponse.class);

        return createdCarResponse;
    }
}
