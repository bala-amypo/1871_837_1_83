package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DeliveryEvaluation;
import com.example.demo.entity.SLARequirement;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.repository.SLARequirementRepository;

@Service
public class SLAEvaluationService {

    private final SLARequirementRepository slaRequirementRepository;
    private final DeliveryEvaluationRepository deliveryEvaluationRepository;

    public SLAEvaluationService(
            SLARequirementRepository slaRequirementRepository,
            DeliveryEvaluationRepository deliveryEvaluationRepository) {
        this.slaRequirementRepository = slaRequirementRepository;
        this.deliveryEvaluationRepository = deliveryEvaluationRepository;
    }

    public DeliveryEvaluation evaluateSLA(
            String vendorName,
            String slaType,
            Integer actualValue) {

        SLARequirement sla = slaRequirementRepository
                .findByVendorNameAndSlaType(vendorName, slaType)
                .orElseThrow(() ->
                        new RuntimeException("SLA not defined for vendor: " + vendorName));

        boolean slaMet = actualValue <= sla.getThresholdValue();

        DeliveryEvaluation evaluation =
                new DeliveryEvaluation(vendorName, actualValue, slaMet);

        return deliveryEvaluationRepository.save(evaluation);
    }

    public Map<String, Object> getVendorSLASummary(String vendorName) {

        long total = deliveryEvaluationRepository.countByVendorName(vendorName);
        long met = deliveryEvaluationRepository
                .countByVendorNameAndSlaMetTrue(vendorName);
        long violated = deliveryEvaluationRepository
                .countByVendorNameAndSlaMetFalse(vendorName);

        Map<String, Object> summary = new HashMap<>();
        summary.put("vendorName", vendorName);
        summary.put("totalEvaluations", total);
        summary.put("slaMet", met);
        summary.put("slaViolated", violated);

        return summary;
    }
}
