package com.example.demo.service;

import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        if (vendorRepository.existsByName(vendor.getName())) {
            throw new IllegalArgumentException("Vendor name must be unique");
        }
        return vendorRepository.save(vendor);
    }

    @Override
    public Optional<Vendor> getVendor(Long id) {
        return vendorRepository.findById(id);
    }

    @Override
    public List<Vendor> listAll() {
        return vendorRepository.findAll();
    }

    @Override
    public boolean existsByName(String name) {
        return vendorRepository.existsByName(name);
    }
}
