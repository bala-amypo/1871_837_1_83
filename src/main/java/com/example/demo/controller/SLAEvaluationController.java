package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DeliveryEvaluation;
import com.example.demo.service.SLAEvaluationService;

@RestController
@RequestMapping("/api/evaluate")
public class SLAEvaluationController {

    private final SLAEvaluationService slaEvaluationService;

    public SLAEvaluationController(SLAEvaluationService slaEvaluationService) {
        this.slaEvaluationService = slaEvaluationService;
    }
    @PostMapping
    public DeliveryEvaluation evaluateSLA(
            @RequestParam String vendorName,
            @RequestParam String slaType,
            @RequestParam Integer actualValue) {

        return slaEvaluationService.evaluateSLA(
                vendorName, slaType, actualValue);
    }

    @GetMapping("/test")
    public DeliveryEvaluation evaluateSLATest(
            @RequestParam String vendorName,
            @RequestParam String slaType,
            @RequestParam Integer actualValue) {

        return slaEvaluationService.evaluateSLA(
                vendorName, slaType, actualValue);
    }

    @GetMapping("/summary")
    public Map<String, Object> getSLASummary(
            @RequestParam String vendorName) {

        return slaEvaluationService.getVendorSLASummary(vendorName);
    }
}
