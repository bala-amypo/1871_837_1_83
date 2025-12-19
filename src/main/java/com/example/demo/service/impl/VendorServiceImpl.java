package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;

import java.util.List;

public class VendorServiceImpl implements VendorService {

    private final VendorRepository repo;

    public VendorServiceImpl(VendorRepository repo) {
        this.repo = repo;
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        if (repo.existsByName(vendor.getName()))
            throw new IllegalArgumentException("unique");
        vendor.setActive(true);
        return repo.save(vendor);
    }

    @Override
    public Vendor getVendorById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<Vendor> getAllVendors() {
        return repo.findAll();
    }

    @Override
    public void deactivateVendor(Long id) {
        Vendor v = getVendorById(id);
        v.setActive(false);
        repo.save(v);
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        Vendor v = getVendorById(id);
        v.setName(vendor.getName());
        return repo.save(v);
    }
}
