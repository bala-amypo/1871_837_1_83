package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DeliveryEvaluation;
import com.example.demo.repository.DeliveryEvaluationRepository;

@RestController
@RequestMapping("/api/evaluations")
public class DeliveryEvaluationController {

    private final DeliveryEvaluationRepository deliveryEvaluationRepository;

    public DeliveryEvaluationController(DeliveryEvaluationRepository deliveryEvaluationRepository) {
        this.deliveryEvaluationRepository = deliveryEvaluationRepository;
    }
    
    @GetMapping
    public List<DeliveryEvaluation> getAllEvaluations() {
        return deliveryEvaluationRepository.findAll();
    }
    @GetMapping("/{vendorName}")
    public List<DeliveryEvaluation> getByVendor(@PathVariable String vendorName) {
        return deliveryEvaluationRepository.findByVendorName(vendorName);
    }
}
