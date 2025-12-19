package com.example.demo.controller;

import com.example.demo.model.SLARequirement;
import com.example.demo.service.SLARequirementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sla-requirements")
public class SLARequirementController {

    private final SLARequirementService service;

    public SLARequirementController(SLARequirementService service) {
        this.service = service;
    }

    // 1️⃣ Create SLA requirement
    @PostMapping
    public SLARequirement create(@RequestBody SLARequirement req) {
        return service.createRequirement(req);
    }

    // 2️⃣ Update SLA requirement
    @PutMapping("/{id}")
    public SLARequirement update(@PathVariable Long id,
                                 @RequestBody SLARequirement req) {
        return service.updateRequirement(id, req);
    }

    // 3️⃣ Get SLA requirement by ID
    @GetMapping("/{id}")
    public SLARequirement getById(@PathVariable Long id) {
        return service.getRequirementById(id);
    }

    // 4️⃣ Get all SLA requirements
    @GetMapping
    public List<SLARequirement> getAll() {
        return service.getAllRequirements();
    }

    // 5️⃣ Deactivate SLA requirement
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateRequirement(id);
    }
}
