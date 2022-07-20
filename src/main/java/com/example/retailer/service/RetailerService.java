package com.example.retailer.service;

import com.example.retailer.model.Customer;
import com.example.retailer.model.Reward;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RetailerService {
  String getRewardByCustomerId(Long id);
  List<String> getAllRewards();
  Customer getCustomerById(Long id);
  List<Customer> getAllCustomers();
  Customer updateCustomerNameById(Long id, String name);
  boolean deleteCustomerById(Long id);
}
