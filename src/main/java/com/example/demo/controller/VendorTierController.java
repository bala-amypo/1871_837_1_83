package com.example.demo.controller;

import com.example.demo.model.VendorTier;
import com.example.demo.service.VendorTierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiers")
public class VendorTierController {

    public VendorTierController(VendorTierService s) {}

    @PostMapping
    public VendorTier create(@RequestBody VendorTier t) { return t; }

    @PutMapping("/{id}")
    public VendorTier update(@PathVariable Long id, @RequestBody VendorTier t) { return t; }

    @GetMapping("/{id}")
    public VendorTier get(@PathVariable Long id) { return null; }

    @GetMapping
    public List<VendorTier> all() { return List.of(); }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {}
}
