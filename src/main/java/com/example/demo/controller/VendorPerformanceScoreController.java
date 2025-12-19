package com.example.demo.controller;

import com.example.demo.model.VendorPerformanceScore;
import com.example.demo.service.VendorPerformanceScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class VendorPerformanceScoreController {

    public VendorPerformanceScoreController(VendorPerformanceScoreService s) {}

    @PostMapping("/calculate/{vendorId}")
    public VendorPerformanceScore calculate(@PathVariable Long vendorId) {
        return null;
    }

    @GetMapping("/latest/{vendorId}")
    public VendorPerformanceScore latest(@PathVariable Long vendorId) {
        return null;
    }

    @GetMapping("/vendor/{vendorId}")
    public List<VendorPerformanceScore> history(@PathVariable Long vendorId) {
        return List.of();
    }
}
