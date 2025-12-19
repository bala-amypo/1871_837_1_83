package com.example.demo.service.impl;

import com.example.demo.model.VendorTier;
import com.example.demo.repository.VendorTierRepository;
import com.example.demo.service.VendorTierService;

import java.util.List;

public class VendorTierServiceImpl implements VendorTierService {

    public VendorTierServiceImpl(VendorTierRepository repo) {}

    public VendorTier createTier(VendorTier tier) {
        return tier;
    }

    public VendorTier updateTier(Long id, VendorTier tier) {
        return tier;
    }

    public VendorTier getTierById(Long id) {
        throw new RuntimeException("not found");
    }

    public List<VendorTier> getAllTiers() {
        return List.of();
    }

    public void deactivateTier(Long id) {}
}
