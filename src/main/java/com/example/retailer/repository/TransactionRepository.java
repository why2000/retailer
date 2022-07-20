package com.example.retailer.repository;

import com.example.retailer.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  @Query(value = "select * from rtl_transaction t where t.customer_id=?1", nativeQuery = true)
  List<Transaction> findByCustomerId(Long id);
}
