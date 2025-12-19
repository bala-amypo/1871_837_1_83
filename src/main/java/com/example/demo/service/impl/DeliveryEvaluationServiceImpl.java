package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DeliveryEvaluationService;

import java.util.Date;
import java.util.List;

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
                .orElseThrow(() -> new RuntimeException("not found"));

        if (!vendor.getActive()) {
            throw new IllegalStateException("active vendors");
        }

        SLARequirement sla = slaRepo.findById(eval.getSlaRequirement().getId())
                .orElseThrow(() -> new RuntimeException("not found"));

        if (eval.getActualDeliveryDays() < 0) {
            throw new IllegalArgumentException(">= 0");
        }

        if (eval.getQualityScore() < 0 || eval.getQualityScore() > 100) {
            throw new IllegalArgumentException("between 0 and 100");
        }

        eval.setMeetsDeliveryTarget(
                eval.getActualDeliveryDays() <= sla.getMaxDeliveryDays()
        );

        eval.setMeetsQualityTarget(
                eval.getQualityScore() >= sla.getMinQualityScore()
        );

        // ✅ SET evaluation date
        eval.setEvaluationDate(new Date());

        return evaluationRepo.save(eval);
    }

    @Override
    public DeliveryEvaluation getEvaluationById(Long id) {
        return evaluationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
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
