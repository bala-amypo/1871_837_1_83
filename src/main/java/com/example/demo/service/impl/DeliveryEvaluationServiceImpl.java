package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

    private final DeliveryEvaluationRepository evaluationRepo;
    private final VendorRepository vendorRepo;
    private final SLARequirementRepository slaRepo;

    public DeliveryEvaluationServiceImpl(
            DeliveryEvaluationRepository evaluationRepo,
            VendorRepository vendorRepo,
            SLARequirementRepository slaRepo) {
        this.evaluationRepo = evaluationRepo;
        this.vendorRepo = vendorRepo;
        this.slaRepo = slaRepo;
    }

    @Override
    public DeliveryEvaluation createEvaluation(DeliveryEvaluation eval) {

        Vendor vendor = vendorRepo.findById(eval.getVendor().getId())
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        if (!vendor.getActive()) {
            throw new IllegalStateException("Vendor is not active");
        }

        SLARequirement sla = slaRepo.findById(eval.getSlaRequirement().getId())
                .orElseThrow(() -> new RuntimeException("SLA not found"));

        if (eval.getActualDeliveryDays() < 0) {
            throw new IllegalArgumentException("Actual delivery days must be >= 0");
        }

        if (eval.getQualityScore() < 0 || eval.getQualityScore() > 100) {
            throw new IllegalArgumentException("Quality score must be between 0 and 100");
        }

        eval.setMeetsDeliveryTarget(
                eval.getActualDeliveryDays() <= sla.getMaxDeliveryDays()
        );

        eval.setMeetsQualityTarget(
                eval.getQualityScore() >= sla.getMinQualityScore()
        );

        eval.setEvaluationDate(new Date());

        return evaluationRepo.save(eval);
    }

    @Override
    public DeliveryEvaluation getEvaluationById(Long id) {
        return evaluationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForVendor(Long vendorId) {
        return evaluationRepo.findByVendorId(vendorId);
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForRequirement(Long requirementId) {
        return evaluationRepo.findBySlaRequirementId(requirementId);
    }
}
