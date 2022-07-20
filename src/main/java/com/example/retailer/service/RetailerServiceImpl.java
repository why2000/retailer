package com.example.retailer.service;

import com.example.retailer.model.Customer;
import com.example.retailer.model.Reward;
import com.example.retailer.model.Transaction;
import com.example.retailer.repository.CustomerRepository;
import com.example.retailer.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetailerServiceImpl implements RetailerService {

  private final CustomerRepository customerRepository;
  private final TransactionRepository transactionRepository;

  @Autowired
  public RetailerServiceImpl(CustomerRepository customerRepository,
      TransactionRepository transactionRepository) {
    this.customerRepository = customerRepository;
    this.transactionRepository = transactionRepository;
  }


  @Override public String getRewardByCustomerId(Long id) {
    Customer customer = getCustomerById(id);
    int[] rewards = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    List<Transaction> transactions = getTransactionsByCustomerId(id);
    for(Transaction transaction: transactions){
      rewards[transaction.getMonth().getValue()-1] += transaction.getReward();
      rewards[12] += transaction.getReward();
    }
    return new Reward(customer, rewards).toString();
  }

  @Override public List<String> getAllRewards() {
    List<Customer> customers = getAllCustomers();
    List<String> res = new ArrayList<>();
    for(Customer customer: customers){
      res.add(getRewardByCustomerId(customer.getId()));
    }
    return res;
  }

  @Override public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  @Override public Customer updateCustomerNameById(Long id, String name) {
    Customer customer = customerRepository.findById(id).orElse(null);
    if(customer != null) customer.setName(name);
    return customer;
  }

  @Override public boolean deleteCustomerById(Long id) {
    boolean flag = customerRepository.findById(id).orElse(null) != null;
    customerRepository.deleteById(id);
    return flag;
  }


  @Override public Customer getCustomerById(Long id){
    return customerRepository.findById(id).orElse(null);
  }


  private List<Transaction> getTransactionsByCustomerId(Long id){
    return transactionRepository.findByCustomerId(id);
  }
}
