package com.example.m2_Testing_David_SansSinSpringWeb.repositories;


import com.example.m2_Testing_David_SansSinSpringWeb.entities.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartPhonesRepository extends JpaRepository<SmartPhone, Long> {
        List<SmartPhone> findByManufacturerIgnoreCase(String manufacturer);
        List<SmartPhone> findByPriceLessThan(Double price);
        List<SmartPhone> findByPixelAndRam(Integer pixels, Integer Ram);
        List<SmartPhone> findByModelIgnoreCase(String model);
}
