package com.example.demo.service;

import com.example.demo.model.Vendor;
import java.util.List;
import java.util.Optional;

public interface VendorService {
    Vendor createVendor(Vendor vendor);
    Optional<Vendor> getVendor(Long id);
    List<Vendor> listAll();
    boolean existsByName(String name);
}
