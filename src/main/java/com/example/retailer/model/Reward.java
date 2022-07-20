package com.example.retailer.model;

import java.time.Month;
import java.util.Arrays;


public class Reward {
  private final Customer customer;
  private final int[] rewards;

  public Reward(Customer customer, int[] rewards) {
    this.customer = customer;
    this.rewards = rewards;
  }

  @Override public String toString() {
    StringBuilder temp = new StringBuilder();
    for(int i = 0; i < 12; i++){
      if(rewards[i] != 0)
        temp.append(Month.of(i+1)).append("_Reward: ").append(this.rewards[i]).append(", ");
    }
    temp.append("Total: ").append(this.rewards[12]);
    return "Reward{" + "customer_id=" + customer.getId() + ", "
        + "customer_name='" + customer.getName() + "', " + temp + '}';
  }
}
