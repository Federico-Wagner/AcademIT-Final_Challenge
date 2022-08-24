package com.examen.federicowagner.services;
import com.examen.federicowagner.entities.Vendor;
import java.util.List;
import java.util.Optional;

public interface IVendorService {
    public List<Vendor> getAllVendors();
    public Vendor saveNewVendor(Vendor vendor);

    public Optional<Vendor> findById(Long id);

    public Vendor save(Vendor vendor);
}
