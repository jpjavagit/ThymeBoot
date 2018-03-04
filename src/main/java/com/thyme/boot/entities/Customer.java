package com.thyme.boot.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

/**
 * 
 * @author joao.sanches
 * Customer Pojo
 */
@Entity
@Table(name="tb_customer")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = -4007253563587327733L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "E-mail is empty")
	@Column(name="email", nullable = false, length= 50)
	private String email;
	
	@NotNull(message= "Value is empty")
	@NumberFormat(pattern="#,##0.00")
	@Column(name="valueOfPurchase", nullable = false)
	private BigDecimal valueOfPurchase;

	//Getters and Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getValueOfPurchase() {
		return valueOfPurchase;
	}

	public void setValueOfPurchase(BigDecimal valueOfPurchase) {
		this.valueOfPurchase = valueOfPurchase;
	}
	
}
