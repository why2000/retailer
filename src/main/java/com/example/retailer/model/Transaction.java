package com.example.retailer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.Month;

@Entity
@Table(name = "rtl_transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;
  @Column(name= "amount", nullable = false)
  private Integer amount;
  @Column(name= "month", nullable = false)
  private int month;

  @JsonBackReference
  @ManyToOne(targetEntity = Customer.class,fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id",referencedColumnName = "id")
  private Customer customer;

  public Integer getReward(){
    if(this.amount <= 50) return 0;
    else if(this.amount <=100) return this.amount-50;
    else return 50+2*(this.amount-100);
  }

  // starts from 1=Jan
  public Month getMonth() {
    return Month.of(month);
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "transaction_id=" + id +
        "month='" + month + "'" +
        ", customer_id=" + customer.getId() +
        ", customer_name='" + customer.getName() + "'" +
        ", amount=" + amount +
        '}';
  }




}

