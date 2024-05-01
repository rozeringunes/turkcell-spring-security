package com.turkcell.springSecurity.business.concretes;

import com.turkcell.springSecurity.business.abstracts.BrandService;
import com.turkcell.springSecurity.business.dto.requests.CreateBrandRequest;
import com.turkcell.springSecurity.business.dto.responses.CreatedBrandResponse;
import com.turkcell.springSecurity.business.dto.responses.GetAllBrandResponse;
import com.turkcell.springSecurity.business.rules.BrandBusinessRules;
import com.turkcell.springSecurity.core.utilities.mapping.ModelMapperService;
import com.turkcell.springSecurity.dataAccess.abstracts.BrandRepository;
import com.turkcell.springSecurity.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;
    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());
        Brand brand=this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        Brand createdBrand=brandRepository.save(brand);
        CreatedBrandResponse createdBrandResponse=this.modelMapperService.forResponse().map(createdBrand, CreatedBrandResponse.class);

        return createdBrandResponse;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        var result=brandRepository.findAll();
        List<GetAllBrandResponse>response =result.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class)).toList();
        return response;
    }
}
