package com.example.retailer.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rtl_customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;
  @Column(name = "name", nullable = false)
  private String name;

  @JsonManagedReference
  @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
  private List<Transaction> transactions = new ArrayList<>();

  @Override
  public String toString() {
    return "Customer{" +
        "customer_id=" + id +
        ", customer_name='" + name + '\'' +
        '}';
  }




}

