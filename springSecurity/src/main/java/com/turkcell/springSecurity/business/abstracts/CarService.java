package com.turkcell.springSecurity.business.abstracts;

import com.turkcell.springSecurity.business.dto.requests.CreateCarRequest;
import com.turkcell.springSecurity.business.dto.responses.CreatedCarResponse;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest createCarRequest);
}
