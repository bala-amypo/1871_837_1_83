package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public ResponseEntity<Vendor> create(@RequestBody Vendor vendor) {
        Vendor created = vendorService.createVendor(vendor);
        return ResponseEntity.created(URI.create("/api/vendors/" + created.getId())).body(created);
    }

    @GetMapping
    public List<Vendor> list() {
        return vendorService.listAll();
    }
}
