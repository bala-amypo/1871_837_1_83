package com.example.demo.service.impl;

import com.example.demo.model.VendorTier;
import com.example.demo.repository.VendorTierRepository;
import com.example.demo.service.VendorTierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorTierServiceImpl implements VendorTierService {

    private final VendorTierRepository repo;

    public VendorTierServiceImpl(VendorTierRepository repo) {
        this.repo = repo;
    }

    @Override
    public VendorTier createTier(VendorTier tier) {

        if (tier.getMinScoreThreshold() < 0 || tier.getMinScoreThreshold() > 100) {
            throw new IllegalArgumentException("Score threshold must be between 0–100");
        }

        if (repo.existsByTierName(tier.getTierName())) {
            throw new IllegalArgumentException("Tier name must be unique");
        }

        tier.setActive(true);
        return repo.save(tier);
    }

    @Override
    public VendorTier updateTier(Long id, VendorTier tier) {
        VendorTier existing = getTierById(id);

        if (tier.getTierName() != null &&
                !existing.getTierName().equals(tier.getTierName()) &&
                repo.existsByTierName(tier.getTierName())) {
            throw new IllegalArgumentException("Tier name must be unique");
        }

        if (tier.getTierName() != null)
            existing.setTierName(tier.getTierName());

        if (tier.getDescription() != null)
            existing.setDescription(tier.getDescription());

        if (tier.getMinScoreThreshold() != null)
            existing.setMinScoreThreshold(tier.getMinScoreThreshold());

        return repo.save(existing);
    }

    @Override
    public VendorTier getTierById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Vendor tier not found"));
    }

    @Override
    public List<VendorTier> getAllTiers() {
        return repo.findAll();
    }

    @Override
    public void deactivateTier(Long id) {
        VendorTier tier = getTierById(id);
        tier.setActive(false);
        repo.save(tier);
    }
}
