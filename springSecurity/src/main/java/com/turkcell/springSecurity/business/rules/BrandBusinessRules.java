package com.turkcell.springSecurity.business.rules;

import com.turkcell.springSecurity.business.messages.BrandMessages;
import com.turkcell.springSecurity.core.utilities.exceptions.types.BusinessException;
import com.turkcell.springSecurity.dataAccess.abstracts.BrandRepository;
import com.turkcell.springSecurity.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class  BrandBusinessRules {
    BrandRepository brandRepository;
    public void brandNameCanNotBeDuplicated(String brandName){
        Optional<Brand>brand=brandRepository.findByNameIgnoreCase(brandName);
        if(brand.isPresent()){
            throw new BusinessException(BrandMessages.brandNameAlreadyExists);
        }
    }
}
