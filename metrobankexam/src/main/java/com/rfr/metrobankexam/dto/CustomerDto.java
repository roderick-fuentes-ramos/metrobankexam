package com.rfr.metrobankexam.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

	private Long id;
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private String address1;
	private String address2;
	private String accountType;
	
	private List<SavingsDto> savings;

}
