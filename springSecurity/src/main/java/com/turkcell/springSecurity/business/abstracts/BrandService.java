package com.turkcell.springSecurity.business.abstracts;

import com.turkcell.springSecurity.business.dto.requests.CreateBrandRequest;
import com.turkcell.springSecurity.business.dto.responses.CreatedBrandResponse;
import com.turkcell.springSecurity.business.dto.responses.GetAllBrandResponse;
import com.turkcell.springSecurity.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
CreatedBrandResponse add(CreateBrandRequest createBrandRequest);
List<GetAllBrandResponse>getAll();
}

