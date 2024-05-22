package com.turkcell.springSecurity.business.concretes;

import com.turkcell.springSecurity.business.dto.requests.CreateBrandRequest;
import com.turkcell.springSecurity.business.rules.BrandBusinessRules;
import com.turkcell.springSecurity.core.utilities.mapping.ModelMapperManager;
import com.turkcell.springSecurity.core.utilities.mapping.ModelMapperService;
import com.turkcell.springSecurity.dataAccess.abstracts.BrandRepository;
import com.turkcell.springSecurity.entities.concretes.Brand;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BrandManagerTest {
    private BrandManager brandManager;
    private BrandRepository brandRepository;

    @BeforeEach
    void setUp(){
        BrandRepository brandRepository = Mockito.mock(BrandRepository.class);
        ModelMapper mapper =new ModelMapper();
        ModelMapperService modelMapperService=new ModelMapperManager(mapper);
        BrandBusinessRules rules =new BrandBusinessRules(brandRepository);
        brandManager=new BrandManager(brandRepository,modelMapperService,rules);
        //File.Open
    }
    @AfterEach
    void tearDown(){
        //File.Close

    }
    @BeforeAll
    static void start(){
        //Bütün testler öncesi bir kez çalışır

    }
    @AfterAll
    static void end(){
        //Bütün testler sonrası bir kez çalışır

    }
    @Test
    void addBranWithExistingName_ShouldThrowException() {


        Mockito.when(brandRepository.findByNameIgnoreCase("BMW")).thenReturn(Optional.of(new Brand()));
        CreateBrandRequest request=new CreateBrandRequest("BMW");
        //
        brandManager.add(request);
        assertThrows(Exception.class,()->{
            brandManager.add(request);
        }
        );
    }

    @Test
    void addBrandSuccess(){
        Brand savedBrand=new Brand();
        savedBrand.setId(1);
        savedBrand.setName("BMW");
        Mockito.when(brandRepository.findByNameIgnoreCase("BMW")).thenReturn(Optional.empty());
        Mockito.when(brandRepository.save(Mockito.any())).thenReturn(savedBrand);
        CreateBrandRequest request =new CreateBrandRequest("BMW");
        brandManager.add(request);
        assert true;
    }
}