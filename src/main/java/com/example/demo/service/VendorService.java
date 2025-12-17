package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor createVendor(Vendor vendor) {
        if (vendorRepository.existsByName(vendor.getName())) {
            throw new IllegalArgumentException("Vendor name must be unique");
        }
        return vendorRepository.save(vendor);
    }

    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public void deactivateVendor(Long id) {
        Vendor vendor = getVendorById(id);
        vendor.setActive(false);
        vendorRepository.save(vendor);
    }
}
