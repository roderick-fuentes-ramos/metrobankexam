package com.rfr.metrobankexam.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNumber;
    
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private String address1;
	private String address2;
	private String accountType;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
    private List<Savings> savings = new ArrayList<Savings>();
	
    public void addSavings(Savings savings) {
        savings.setCustomer(this); 
        this.savings.add(savings); 
    }
}
