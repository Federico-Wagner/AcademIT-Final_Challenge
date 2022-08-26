package com.examen.federicowagner.services;
import com.examen.federicowagner.entities.Vendor;
import java.util.List;
import java.util.Optional;

public interface IVendorService {
    List<Vendor> getAllVendors();
    Vendor saveNewVendor(Vendor vendor);
    Optional<Vendor> findById(Long id);
    Vendor save(Vendor vendor);
}
