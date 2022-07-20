package com.example.retailer.controller;

import com.example.retailer.model.Customer;
import com.example.retailer.model.Reward;
import com.example.retailer.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RetailerController {

  private final RetailerService retailerService;

  @Autowired
  public RetailerController(RetailerService retailerService) {
    this.retailerService = retailerService;
  }


  @GetMapping("/customer")
  public ResponseEntity<List<Customer>> getAllCustomers(){
    List<Customer> res = retailerService.getAllCustomers();
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @GetMapping("/customer/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
    Customer res = retailerService.getCustomerById(id);
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @GetMapping("/reward")
  public ResponseEntity<List<String>> getAllRewards(){
    List<String> res = retailerService.getAllRewards();
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @GetMapping("/reward/{id}")
  public ResponseEntity<String> getRewardByCustomerId(@PathVariable Long id) {
    String res = retailerService.getRewardByCustomerId(id);
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @PutMapping("/rename/{id}")
  public ResponseEntity<Customer> updateCustomerNameById(@PathVariable Long id,
      @RequestParam("name") String name){
    Customer res = retailerService.updateCustomerNameById(id, name);
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteCustomerById(@PathVariable Long id){
    String res = retailerService.deleteCustomerById(id)? "Success!": "Customer not found!";
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

}
