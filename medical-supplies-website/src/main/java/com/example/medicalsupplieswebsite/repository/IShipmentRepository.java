package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;


public interface IShipmentRepository extends JpaRepository<Shipment,Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into shipment (invoice_code,date_of_create,shipment_type_id,customer_id,employee_id) values (?1,?2,?3,?4,?5)", nativeQuery = true)
    void addShipment(String invoiceCode, Date dateOfCreate,Long shipmentTypeId, Long customerId, Long employeeId);


    @Query(value = "select shipment_id from shipment where invoice_code = ?1", nativeQuery = true)
    Long findByShipmentIDInvoice(String invoiceCode);

    @Query(value = "select shipment_id, date_of_create,invoice_code,note,customer_id,employee_id,shipment_type_id from shipment where invoice_code = ?1", nativeQuery = true)
    Shipment findByIdShipmentInvoiceCode(String invoiceCode);
}
