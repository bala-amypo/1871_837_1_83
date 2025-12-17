package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SLARequirement;

public interface SLARequirementRepository extends JpaRepository<SLARequirement, Long> {

    Optional<SLARequirement> findByVendorNameAndSlaType(String vendorName, String slaType);
}
