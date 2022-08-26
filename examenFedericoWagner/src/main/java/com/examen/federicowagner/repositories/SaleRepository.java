package com.examen.federicowagner.repositories;

import com.examen.federicowagner.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository< Sale, Long> {
    List<Sale> findAllByVendorId(Long vendor_id);

    List<Sale> findAllByVendorIdAndDateAfterAndDateBeforeOrderByDate(Long vendor_id, LocalDate date1, LocalDate date2);
}
