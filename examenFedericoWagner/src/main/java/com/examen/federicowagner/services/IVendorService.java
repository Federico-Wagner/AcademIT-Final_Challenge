package com.examen.federicowagner.services;
import com.examen.federicowagner.entities.Vendor;
import java.util.List;

public interface IVendorService {
    public List<Vendor> getAllVendors();
    public Vendor saveNewVendor(Vendor vendor);
}
