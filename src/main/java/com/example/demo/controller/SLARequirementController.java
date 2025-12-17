package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;

@RestController
@RequestMapping("/api/sla")
public class SLARequirementController {

    private final SLARequirementRepository slaRequirementRepository;

    public SLARequirementController(SLARequirementRepository slaRequirementRepository) {
        this.slaRequirementRepository = slaRequirementRepository;
    }

    @PostMapping
    public SLARequirement createSLA(@RequestBody SLARequirement slaRequirement) {
        return slaRequirementRepository.save(slaRequirement);
    }

    @GetMapping("/test")
    public SLARequirement createSLATest(
            @RequestParam String vendorName,
            @RequestParam String slaType,
            @RequestParam Integer thresholdValue,
            @RequestParam String unit) {

        SLARequirement sla = new SLARequirement(
                vendorName,
                slaType,
                thresholdValue,
                unit
        );

        return slaRequirementRepository.save(sla);
    }

    @GetMapping
    public List<SLARequirement> getAllSLAs() {
        return slaRequirementRepository.findAll();
    }
}
