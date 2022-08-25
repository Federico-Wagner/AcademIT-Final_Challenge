package com.examen.federicowagner.services;
import com.examen.federicowagner.entities.Vendor;
import com.examen.federicowagner.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService implements IVendorService{
    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public List<Vendor> getAllVendors() {
        return this.vendorRepository.findAll();
    }

    @Override
    public Vendor saveNewVendor(Vendor vendor) {
        return this.vendorRepository.save(vendor);
    }

    @Override
    public Optional<Vendor> findById(Long id) {
        return this.vendorRepository.findById(id);
    }

    @Override
    public Vendor save(Vendor vendor) {
        return this.vendorRepository.save(vendor);
    }
}
