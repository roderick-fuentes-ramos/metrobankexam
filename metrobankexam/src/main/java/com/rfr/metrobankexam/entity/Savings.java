package com.rfr.metrobankexam.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "savings")
public class Savings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private Long accountNumber;
    private String accountType;
    private Integer availableBalance;
    
    @ManyToOne
    @JoinColumn(name = "customerNumber")
    @JsonIgnore
    private Customer customer;
    
}
