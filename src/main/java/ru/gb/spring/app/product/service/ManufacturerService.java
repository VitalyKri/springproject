package ru.gb.spring.app.Manufacturer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.spring.app.product.dao.ManufacturerDao;
import ru.gb.spring.app.product.entity.Manufacturer;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerDao manufacturerDao;


    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerDao.save(manufacturer);
    }

    public Manufacturer edit(Manufacturer manufacturer) {
        return manufacturerDao.save(manufacturer);
    }

    public Manufacturer findById(Long id) {
        Optional<Manufacturer> byId = manufacturerDao.findById(id);
        return byId.orElseThrow(() -> new NoSuchElementException());

    }

    public List<Manufacturer> findAll() {
        return manufacturerDao.findAll();
    }



    public void deleteById(Long id){
        manufacturerDao.findById(id).ifPresent(
                m -> {
                    manufacturerDao.deleteById(m.getId());
                }
        );
    }



}
