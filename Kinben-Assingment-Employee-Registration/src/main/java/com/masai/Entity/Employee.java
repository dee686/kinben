package com.masai.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Employee_ID;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String Employee_Name;
	
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "Mobile Number start with 6,7,8,9 and must be 10 digit")
	private String Contact_Number;
	
	@Email
	private String Email_id;
	
	private String  Address;
	
	@Enumerated(EnumType.STRING)
	private Education education;
	
	private Integer Year_of_Experience;
	

}
