package com.examen.federicowagner.repositories;

import com.examen.federicowagner.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository< Vendor, Long> {

}
